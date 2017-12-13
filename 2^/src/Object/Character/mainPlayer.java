/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object.Character;

import Main.EntityList;
import Object.Entity;
import Object.Item.Ground;
import Object.ID;
import Object.InteractiveEntity;
import Object.Item.Item;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author jandre
 */
public class mainPlayer extends InteractiveEntity{
    int Yvel = 0;
    int Xvel = 0;
    int Xacc = 0;
    final int maxXVel = 12;
    int facing = 1;
    boolean isJumping = false;
    final int acc = 4, maxVel = 8;
    Item[] items = {null, null, null, null, null, null, null, null};
    int slotnum = 1;
    
    
    public mainPlayer(){
        super(100, 200, 32, 64, ID.PLAYER, true, true);
        try {
            this.image = ImageIO.read(new File("robot.png"));
        } catch (IOException ex) {
        }
        this.Yvel = 0;
    }

    public void paint(Graphics g){
        super.paint(g);
        if(items[slotnum] != null){
            if(facing == -1){
                g.drawImage(items[slotnum].image, x - (width / 2), y + (height / 2), null);
            }else{
                g.drawImage(items[slotnum].image, x + width - items[slotnum].image.getWidth() + (width / 2), y + (height / 2), null);
            }
        }
    }
    
    public boolean onGround(Ground g){
        return((this.y + this.height >= g.y) && (this.y + this.height - g.y) <= 16);
    }
    
    public boolean nearItem(Item i){
        return((this.x <= i.x && this.x + this.width >= i.x) || (this.x <= i.x + i.width && this.x + this.width >= i.x + i.width) || (this.x >= i.x && this.x + this.width <= i.x + i.width));
    }

    public void update(boolean[] keys, ArrayList<Entity> ents) {
        Yvel += acc;
        if(Yvel > maxVel){
            Yvel = maxVel;
        }
        
        for(int i = ents.size() - 1; i >= 0; i--){
            if(ents.get(i).id == ID.GROUND && onGround((Ground)ents.get(i))){
                Yvel = 0;
                y = ((Ground)(ents.get(i))).y - this.height;
                isJumping = false;
            }else if(ents.get(i).id == ID.ITEM){
                Item j = (Item)ents.get(i);
                if(keys[4] && nearItem(j)){
                    boolean foundSlot = false;
                    int num = 0;
                    while(!foundSlot && num < 8){
                        if(items[num] == null){
                            items[num] = j;
                            ents.remove(j);
                        }
                        num++;
                    }
                }if(j.nearPlayer == false && nearItem(j)){
                    j.nearPlayer = true;
                }else if(j.nearPlayer == true && !nearItem(j)){
                    j.nearPlayer = false;
                }
            }
        }
        
        if(keys[0] == true && !isJumping){
            Yvel = -16;
            isJumping = true;
        }
        
        if(keys[1] == true && keys[3] != true){
            Xacc = -2;
            Xvel += Xacc;
        }else if(keys[3] == true && keys[1] != true){
            Xacc = 2;
            Xvel += Xacc;
        }else if(Xvel != 0){
            Xacc = 0;
            Xvel -= 2 * (Xvel / Math.abs(Xvel));
        }
        if(Math.abs(Xvel) >= maxXVel){
            if(Xvel > 0){
                Xvel = maxXVel;
            }else{
                Xvel = -maxXVel;
            }
        }
        
        if(Xacc > 0){
            this.facing = 1;
        }else if(Xacc < 0){
            this.facing = -1;
        }
       
        x += Xvel;
        y += Yvel;
    }
    
    public void update(ArrayList<Entity> ents){
    };
}
