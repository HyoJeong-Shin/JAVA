package ch03.hw;

// 추상 클래스 AbstractDisplay
public abstract class AbstractDisplay {
	// 하위 클래스에 구현을 맡기는 추상메소드(1)
	public abstract void open();

	// 하위 클래스에 구현을 맡기는 추상메소드(2)
	public abstract void print();

	// 하위 클래스에 구현을 맡기는 추상메소드(3)
	public abstract void close();

	// 추상 클래스에서 구현하고 있는 메소드 display
	// 전반적인 흐름(메시지 호출 순서)를 결정한다.
	public final void display(int times) {
		// 우선 open하고...
		open();

		//신효정: print()를 times 횟수 만큼 호출하도록 for 루프 수정
		for (int i = 0; i < times; i++) {
			print();
		}
		
		// 마지막으로 close한다. 
		close();
	}
}
