import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Timer;

public class GameMechanics implements MouseListener, MouseMotionListener, ActionListener {

	private GameGraphics gg = new GameGraphics();	
	private int x;
	private int y;
	private Timer timer;
	private int delay = 8;
	
	public GameMechanics() {
		timer = new Timer(delay,this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		gg.repaint();
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent mevent) {
			
		gg.setMouseCoOrdinates(mevent.getX(),mevent.getY());
			
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Chuj");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
