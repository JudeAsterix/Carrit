/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object.Item;

import Object.ID;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Jandre
 */
public class Baseball extends Item{
    
    public Baseball(int x, int y) {
        super(x, y, 7, 7, ID.BASEBALL);
        try {
            this.image = (ImageIO.read(new File("baseball.png")).getSubimage(0, 0, 7, 7));
        } catch (IOException ex) {
            Logger.getLogger(BaseballBat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
