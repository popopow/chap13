import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class k2 extends JFrame {	
	public k2() {
		this.setTitle("원을 0.5초 간격으로 만들어라.");
		this.setContentPane(new DrawingPanel()); //  패널을 컨텐트팬으로 사용 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
	}
	// 새로운 패널 작성
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
			super.paintComponent(g); // 이전의 원을지우기
			g.setColor(Color.MAGENTA);
			g.drawOval(r.x, r.y, 50,50); // 새로운 타원 생성 
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
				int x = (int)(Math.random()*250); // 패널의 폭보다 작은 랜덤 정수
				int y = (int)(Math.random()*250); // 패널의 넓이보다 작은 랜덤 정수
					
				p.setObj(x,y); // 패널에 그릴 타원 정보 전달
				p.repaint(); 
				try {
					Thread.sleep(400); // 400ms 초 동안 잠을 잔다.
				}
				catch(InterruptedException e){return;}		
			}
		}
	}	
	public static void main(String [] args) {
		new k2();
	}
}