/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author jandre
 */
public abstract class NullEntity extends Entity{;
    
    public NullEntity(int x, int y, int width, int height, ID id){
        super(x, y, width, height, id, EntityType.Null);
    }
    
    public void paint(Graphics g){
        if(this.image == null){
            g.setColor(Color.PINK);
            g.fillRect(this.x + this.offsetX, this.y + this.offsetY, this.width, this.height);
        }else{
            g.drawImage(image, x, y, null);
        }
    }
    
    public void update(ArrayList<Entity> ents){
        
    };
    
    public void update(boolean[] keys, ArrayList<Entity> ents){
        
    };
}
