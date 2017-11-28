import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class k2 extends JFrame {	
	public k2() {
		this.setTitle("���� 0.5�� �������� ������.");
		this.setContentPane(new DrawingPanel()); //  �г��� ����Ʈ������ ��� 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
	}
	// ���ο� �г� �ۼ�
	class DrawingPanel extends JPanel {
		DrawingThread th = new DrawingThread(this); 	
		Rectangle r = new Rectangle(100,100,0,0);
		
		public DrawingPanel() {
			this.addMouseListener(new MyMouseListener());
		}
		public void setObj(int x, int y) {
			r.x = x;
			r.y = y;
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // ������ ���������
			g.setColor(Color.MAGENTA);
			g.drawOval(r.x, r.y, 50,50); // ���ο� Ÿ�� ���� 
		}
		class MyMouseListener extends MouseAdapter {
			public void mousePressed(MouseEvent e) { 				
					th.start();				
			}
		}
	}
	class DrawingThread extends Thread {
		Object obj = new Object();
		DrawingPanel p;
		public DrawingThread(DrawingPanel p) {
			this.p = p;
		}
		public void run() {
			while(true) {
				int x = (int)(Math.random()*250); // �г��� ������ ���� ���� ����
				int y = (int)(Math.random()*250); // �г��� ���̺��� ���� ���� ����
					
				p.setObj(x,y); // �гο� �׸� Ÿ�� ���� ����
				p.repaint(); 
				try {
					Thread.sleep(400); // 400ms �� ���� ���� �ܴ�.
				}
				catch(InterruptedException e){return;}		
			}
		}
	}	
	public static void main(String [] args) {
		new k2();
	}
}