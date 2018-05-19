import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FractalExplorer {   
    private final int dispSize;
    private JImageDisplay img;
    private FractalGenerator fGen;
    private final Rectangle2D.Double range;
    JFrame frame;
    JButton resetButton;
    JButton saveButton;
    JLabel label;
    JComboBox<FractalGenerator> fractalCBox;
    JPanel cbPanel;
    JPanel buttonPanel;    
    
    public FractalExplorer(int dispSize) {
        this.dispSize = dispSize;
        this.fGen = new Mandelbrot();
        this.range = new Rectangle2D.Double(0, 0, 0, 0);
        fGen.getInitialRange(this.range);
        
    }
    
    
    public void createAndShowGUI() {
        frame = new JFrame("Fractal Explorer");
        img = new JImageDisplay(dispSize, dispSize);
        resetButton = new JButton("Reset Display");
        resetButton.setActionCommand("reset");
        saveButton = new JButton("Save Image");
        saveButton.setActionCommand("save");
        label = new JLabel("Fractal: ");
        fractalCBox	= new JComboBox<>();
        cbPanel = new JPanel();
        cbPanel.add(label);
        cbPanel.add(fractalCBox);
        buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(resetButton);
        fractalCBox.addItem(new Mandelbrot());
        fractalCBox.addItem(new BurningShip());
        fractalCBox.addItem(new Tricorn());
        ActionHandler aHandler = new ActionHandler();
        MouseHandler mHandler = new MouseHandler();
        resetButton.addActionListener(aHandler);
        saveButton.addActionListener(aHandler);
        img.addMouseListener(mHandler);
        fractalCBox.addActionListener(aHandler);
        frame.setLayout(new java.awt.BorderLayout());
        frame.add(img, java.awt.BorderLayout.CENTER);
        frame.add(buttonPanel, java.awt.BorderLayout.SOUTH);
        frame.add(cbPanel, java.awt.BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    
    private void drawFractal() {
        for (int i = 0; i < dispSize; i++) {
            for (int j = 0; j < dispSize; j++) {
                double xCoord = FractalGenerator.getCoord(range.x, 
                                range.x + range.width, dispSize, i);
                double yCoord = FractalGenerator.getCoord(range.y, 
                        range.y + range.width, dispSize, j);
                double numIters = fGen.numIterations(xCoord, yCoord);
                
                if (numIters == -1) {                    
                    img.drawPixel(i, j, 0);
                }
                else {
					float hue = 0.7f + (float) numIters / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    img.drawPixel(i, j, rgbColor);
                }
            }
        }
        img.repaint();
    }
    
    
    public class ActionHandler implements ActionListener {    	
        @Override
        public void actionPerformed(ActionEvent e) { 
        	if ("reset".equals(e.getActionCommand())) {
                fGen.getInitialRange(range);
                drawFractal();
        	}
        	else if ("save".equals(e.getActionCommand())) {
        		JFileChooser fileChooser = new JFileChooser();
        		FileFilter filter 
        			= new FileNameExtensionFilter("PNG Images", "png");
        		fileChooser.setFileFilter(filter);
        		fileChooser.setAcceptAllFileFilterUsed(false);
        		int res = fileChooser.showSaveDialog(img);
        		
        		if (res == JFileChooser.APPROVE_OPTION) {
        			try {
						javax.imageio.ImageIO.write(img.getBufferedImage(),
								"png", fileChooser.getSelectedFile());
					} catch (NullPointerException | IOException e1) {
						javax.swing.JOptionPane.showMessageDialog(img,
								e1.getMessage(), "Cannot Save Image",
								JOptionPane.ERROR_MESSAGE);
					}
        		}
        		else {
        		}
        	}
        	else if (e.getSource() == (Object) fractalCBox) {
        		fGen = (FractalGenerator) fractalCBox.getSelectedItem();
                fGen.getInitialRange(range);
                drawFractal();
        	}
        }
    }
    
       public class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            double xCoord = FractalGenerator.getCoord(range.x, 
                    range.x + range.width, dispSize, e.getX());
            double yCoord = FractalGenerator.getCoord(range.y, 
                    range.y + range.width, dispSize, e.getY());
            fGen.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }
 
    public static void main(String[] args) {
        FractalExplorer fracExp = new FractalExplorer(500);
        fracExp.createAndShowGUI();
        fracExp.drawFractal();
    }
}
