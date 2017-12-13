/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object.Item;

import Object.Entity;
import Object.ID;
import Object.NullEntity;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author jandre
 */
public class Ground extends NullEntity{
    ID groundID;
    
    public Ground(int x, int y, ID id){
        super(x, y, 32, 32, ID.GROUND);
        this.groundID = id;
        try {
            if(this.groundID == ID.DIRT){
                this.image = (ImageIO.read(new File("Sheet.png")).getSubimage(0,0,32,32));
            }else{
                this.image = (ImageIO.read(new File("Sheet.png")).getSubimage(32,0,32,32));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paint(Graphics g){
        g.drawImage(image, this.x, this.y, this.width, this.height, null);
    }
    
    public void update(ArrayList<Entity> ents) {
    }

    public void update(boolean[] keys, ArrayList<Entity> ents) {
    }

    public void update() {
    }
}
