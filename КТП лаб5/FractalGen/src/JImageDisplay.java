import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class JImageDisplay extends JComponent {
    private final BufferedImage bufferedImg;
	
    public JImageDisplay(int width, int height) {
        bufferedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension dim = new Dimension(width, height);
        super.setPreferredSize(dim);        
    }    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImg, 0, 0, bufferedImg.getWidth(), bufferedImg.getHeight(), null);
    }    
    
    public void clearImage() {
        for (int i = 0; i < bufferedImg.getWidth(); i++) {
            for (int j = 0; j < bufferedImg.getHeight(); j++) {
                bufferedImg.setRGB(i, j, 0);
            }
        }
    }    
    
    public void drawPixel(int x, int y, int rgbColor) {
        bufferedImg.setRGB(x, y, rgbColor);
    }    
    
    public BufferedImage getBufferedImage() {
    	return bufferedImg;
    }
    
    
}
