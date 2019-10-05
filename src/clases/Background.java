package clases;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class Background implements Border{
    
    public BufferedImage back;
    
    public Background(){
        try {
            URL imagePath = new URL(getClass().getResource("../utilitarios/background.png").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception e) {
            System.out.println("Error al leer la imagen de fondo");
        }
    }
    
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
        g.drawImage(back, (x + (width - back.getWidth())/2), (y + (height - back.getHeight())/2), null);
    }
    
    public Insets getBorderInsets(Component c){
        return new Insets(0, 0, 0, 0);
    }
    
    public boolean isBorderOpaque(){
        return false;
    }
    
}
