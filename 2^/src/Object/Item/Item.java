/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object.Item;

import Object.Entity;
import Object.ID;
import Object.NullEntity;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author studying
 */
public class Item extends NullEntity{
    ID ItemID;
    public boolean nearPlayer = false;
    public int damage;
    public int hits;
    int Yvel = 0;
    int acc = 16;
    final int MaxYvel = 16;
    
    public Item(int x, int y, int width, int height, ID id) {
        super(x, y, width, height, ID.ITEM);
        this.ItemID = id;
    }
    
    public boolean onGround(Ground g){
        return((this.y + this.height >= g.y) && (this.y + this.height - g.y) <= 16);
    }
    
    public void update(ArrayList<Entity> ents){
        Yvel += acc;
        if(Yvel > MaxYvel){
            Yvel = MaxYvel;
        }
        
        for(int i = 0; i < ents.size(); i++){
            if(ents.get(i).id == ID.GROUND && onGround((Ground)ents.get(i))){
                Yvel = 0;
                y = ((Ground)(ents.get(i))).y - this.height;
            }
        }
        
        y += Yvel;
    }
    
    public void paint(Graphics g){
        super.paint(g);
        if(nearPlayer){
            g.setColor(Color.RED);
            g.fillRect((this.x + (this.width / 2) - 3), this.y - 10, 6, 8);
        }
    }
    
}
