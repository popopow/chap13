import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class k42 extends JFrame {
	private JLabel la = new JLabel("진동 레이블"); //컴포넌트 생성
	runnable thread;
	Thread th;
	k42() {
		this.setTitle("진동하는 레이블 만들기");	//타이틀 명
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thread = new runnable();
		th = new Thread(thread);
		this.add(la);
		this.setVisible(true);
		this.setSize(500, 500);
		th.start(); //타이머 스레드 실행 시작
	}
	class runnable implements Runnable{
		public void run() {
			while(true) {
				try { //레이블 진동
					la.setLocation(20,10);
					Thread.sleep(1);
					la.setLocation(10,20);
					Thread.sleep(1);
					la.setLocation(10,10);
					Thread.sleep(1);
					la.setLocation(20,20);
					Thread.sleep(1);
				} 
				catch(InterruptedException e) {return;}
				}
			}
		}

	public static void main(String[] args) {
		
		new k42();
	}

}
