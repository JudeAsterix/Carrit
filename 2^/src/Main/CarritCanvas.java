/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jandre
 */
public class CarritCanvas extends Canvas implements MouseListener, KeyListener, Runnable{
    Graphics bg;
    Image i;
    EntityList list = new EntityList();
    boolean[] keys = {false, false, false, false, false, false}; // up, left, down, right, f, k
    boolean[] oneFrameKeys = {false, false}; //f, k
    public CarritCanvas(){
        t.start();
        this.addMouseListener(this);
        this.addKeyListener(this);
    }
    
    public void paint(Graphics g){
        if(i == null){
            i = createImage(640, 640);
            bg = i.getGraphics();
        }
        bg.setColor(new Color(105, 176, 239));
        bg.fillRect(0,0,640,640);
        list.paint(bg);
        g.drawImage(i, 0, 0, this);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    Thread t = new Thread(this);
    
    public void start(){
        if(t == null){
            t = new Thread(this);
            t.start();
        }
    }
    
    public void stop(){
        if(t != null){
            t.stop();
            t = null;
        }
    }
    
    
    public void run() {
        while(true){
            list.update(keys);
            if(this.keys[4] == true){
                this.keys[4] = false;
            }
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                this.keys[1] = true;
                break;
            case KeyEvent.VK_D:
                this.keys[3] = true;
                break;
            case KeyEvent.VK_W:
                this.keys[0] = true;
                break;
            case KeyEvent.VK_F:
                if(!this.oneFrameKeys[0]){
                    this.keys[4] = true;
                    this.oneFrameKeys[0] = true;
                }
                break;
            case KeyEvent.VK_K:
                if(!this.oneFrameKeys[1]){
                    this.keys[5] = true;
                    this.oneFrameKeys[1] = true;
                }
            default:
                break;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                this.keys[1] = false;
                break;
            case KeyEvent.VK_D:
                this.keys[3] = false;
                break;
            case KeyEvent.VK_W:
                this.keys[0] = false;
                break;
            case KeyEvent.VK_F:
                this.keys[4] = false;
                this.oneFrameKeys[0] = false;
                break;
            case KeyEvent.VK_K:
                this.keys[5] = false;
                this.oneFrameKeys[1] = false;
            default:
                break;
        }
    }
    
    public void keyTyped(KeyEvent e) {}
    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}


    
}
