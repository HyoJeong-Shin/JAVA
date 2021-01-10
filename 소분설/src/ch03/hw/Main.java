package ch03.hw;

public class Main {

	public static void main(String[] args) {
		System.out.println("학번:20181030, 이름:신효정");
		
		AbstractDisplay d1=new ShinHyoJeongDisplay("신효정","20181030",2); //신효정: ShingHyoJeongDisplay 객체 생성
		d1.display(10);//신효정: times 값을 넣어주고 display메소드 호출 -> display메소드의 print를 10번 반복한다는 의미
	}

}
