package Client;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Graphics.GraphicsGPUScreen;

public class Client extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu v=new Menu();
		
		
		DisplayMode DispMode = new DisplayMode(1920, 1080, 16, DisplayMode.REFRESH_RATE_UNKNOWN);

		Client k = new Client();
		k.run(DispMode);
	}

	public void run(DisplayMode dm) {
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setFont(new Font("Arial", Font.PLAIN, 24));

		GraphicsGPUScreen graf = new GraphicsGPUScreen();
		try {
			graf.setFullScreen(dm, this);
			try {
				Thread.sleep(5 * 1000);
			} catch (Exception ex) {
			}
		} finally {
			graf.restoreScreen();
		}

	}
	
	private void SaveImage() {
		File outputfile = new File("Test.png");
		Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage bufferedImage;
		try {
			bufferedImage = new Robot().createScreenCapture(area);
			ImageIO.write(bufferedImage, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		
		int x=200;
		int y=200;
		
		g.drawString("Hello World", x, y);
		g.drawLine(x, y, 970, 540);
		g.drawLine(970, 540, 1800, 200);

		
		g.drawOval(x-50, y-50, 100, 100);
		g.drawOval(970-50, 540-50, 100, 100);
		g.drawOval(1800-50, 200-50, 100, 100);
		
		SaveImage();
		
	}

}
