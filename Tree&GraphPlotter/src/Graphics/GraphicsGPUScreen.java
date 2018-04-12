package Graphics;

import java.awt.*;
import javax.swing.JFrame; 

public class GraphicsGPUScreen {

	//GPU 
	private GraphicsDevice GK;
	
	public GraphicsGPUScreen() {
		
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//GK MainScreen
		GK=env.getDefaultScreenDevice();
	}
	
	public void setFullScreen(DisplayMode DispMode, JFrame vindu) {
		vindu.setUndecorated(true);
		vindu.setResizable(false);
		
		GK.setFullScreenWindow(vindu);
		
		if(DispMode != null&&GK.isDisplayChangeSupported()) {
			try {
				GK.setDisplayMode(DispMode);
			}catch(Exception ex) {
				
			}
		}
	}

public Window getFullScreenWindow() {
	return GK.getFullScreenWindow();
	
}
	public void restoreScreen() {
		Window w=GK.getFullScreenWindow();
		if(w!=null) {
			w.dispose();
		}
		GK.setFullScreenWindow(null);
	}
	
}
