/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Jandre
 */
public class Main {

    public static void createAndShowGUI(){
        JFrame frame = new JFrame("2^");
        frame.setPreferredSize(new Dimension(640, 640));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CarritCanvas cc = new CarritCanvas();
        frame.add(cc);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowGUI();
			}
		});
    }
    
}
