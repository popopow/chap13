import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class k6 extends JFrame{
	public k6() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel k = new GamePanel();
		setContentPane(k);
		setSize(300,300);	
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new k6();
	}
}
class GamePanel extends JPanel {
	public GamePanel() {
		setLayout(null);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent a) {
				BubbleThread bubbleThread = new BubbleThread(a.getX(), a.getY());
				bubbleThread.start();
			}
		});
	}
	
	
	
					
	class BubbleThread extends Thread {
		JLabel gg;
		public BubbleThread(int imgx, int imgy) {
			ImageIcon q = new ImageIcon("images/s.jpg");
			gg = new JLabel(q);
			gg.setSize(q.getIconWidth(),q.getIconWidth());
			gg.setLocation(imgx, imgy);
			add(gg); // GamePanel에 add()
			repaint();
		}
		
		
		
		public void run() {
			while(true) {
				int x = gg.getX() ;
				int y = gg.getY() - 5;
				if(y < 0) {
					remove(gg);
					repaint();
					return; // thread ends
				}
				gg.setLocation(x, y);
				repaint();
				try {
					sleep(200);
				}
				catch(InterruptedException e) {}
			}
		}
	}
}
