import java.util.Scanner;

public class k1 {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);	// 스캐너 생성
		System.out.print("아무 키나 입력>> ");
		scanner.nextLine(); // 아무키나 입력
		scanner.close();
		
		Thread a = new Thread(new CountingThread());	
		a.start();		//시작
		
	}
}

class CountingThread implements Runnable {	//Runnable인터페이스 이용 작성
	@Override		//재정의
	public void run() {
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++)		// 숫자출력
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}
