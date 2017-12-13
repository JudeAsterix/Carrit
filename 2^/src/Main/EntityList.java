/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Object.Entity;
import Object.EntityType;
import Object.Item.Ground;
import Object.Character.mainPlayer;
import Object.ID;
import Object.Item.Baseball;
import Object.Item.BaseballBat;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class EntityList {
    ArrayList<Entity> el = new ArrayList<>();
    BufferedImage bi;
    
    public EntityList(){
        
        try {
            this.bi = (ImageIO.read(new File("Sheet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        el.add(new mainPlayer());
        for(int j = 544; j <= 640; j += 32){
            for(int i = 0; i < 20; i++){
                if(j == 544){
                    el.add(new Ground(i * 32, j, ID.GRASS));
                }else{
                    el.add(new Ground(i * 32, j, ID.DIRT));
                }
            }
        }
        el.add(new BaseballBat(40, 400));
        el.add(new Baseball(400, 400));
    }
    
    public EntityList(boolean b){
        try {
            this.bi = (ImageIO.read(new File("Sheet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paint(Graphics g){
        for(int i = 0; i < el.size(); i++){
            el.get(i).paint(g);
        }
    }
    
    public void update(boolean[] keys){
        for(int i = el.size() - 1; i >= 0; i--){
            if(el.get(i).type == EntityType.Null){
                el.get(i).update(el);
            }else{
                el.get(i).update(keys, el);
            }
        }
    }
}
