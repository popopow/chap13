import java.util.Scanner;

public class k1 {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);	// ��ĳ�� ����
		System.out.print("�ƹ� Ű�� �Է�>> ");
		scanner.nextLine(); // �ƹ�Ű�� �Է�
		scanner.close();
		
		Thread a = new Thread(new CountingThread());	
		a.start();		//����
		
	}
}

class CountingThread implements Runnable {	//Runnable�������̽� �̿� �ۼ�
	@Override		//������
	public void run() {
		System.out.println("������ ���� ����");		
		for(int i=1; i<=10; i++)		// �������
			System.out.print(i + " ");
		System.out.println();
		System.out.println("������ ����");
	}
}
