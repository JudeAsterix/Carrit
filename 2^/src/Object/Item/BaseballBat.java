/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object.Item;

import Object.Entity;
import Object.ID;
import Object.NullEntity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author studying
 */
public class BaseballBat extends Item{
    
    public BaseballBat(int x, int y) {
        super(x, y, 32, 7, ID.BASEBALLBAT);
        try {
            this.image = (ImageIO.read(new File("BaseballBat.png")).getSubimage(0, 14, 32, 7));
        } catch (IOException ex) {
            Logger.getLogger(BaseballBat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
