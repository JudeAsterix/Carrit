/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author jandre
 */
public abstract class Entity {
    public int x, y, width, height;
    public int offsetX = 0, offsetY = 0;
    public ID id;
    public EntityType type;
    public BufferedImage image;
    
    public Entity(int x, int y, int width, int height, ID id, EntityType type, BufferedImage image){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        this.type = type;
        this.image = image;
    }
    
    public Entity(int x, int y, int width, int height, ID id, EntityType type){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        this.type = type;
    }
    
    public abstract void paint(Graphics g);
    
    public abstract void update(ArrayList<Entity> ents);
    
    public abstract void update(boolean[] keys, ArrayList<Entity> ents);
}
