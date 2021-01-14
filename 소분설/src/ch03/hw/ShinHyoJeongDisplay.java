package ch03.hw;

public class ShinHyoJeongDisplay extends AbstractDisplay{

	private String name;
	private String studentId;
	private int grade;

	public ShinHyoJeongDisplay(String name, String studentId, int grade) { //신효정: 생성자에서 넘어온 문자 name,studentId,grade를
		this.name = name; // 필드(속성)에 기억해 둔다.
		this.studentId=studentId;
		this.grade=grade;
	}

	// 상위 클래스에서는 추상메소드였다. 여기서 오버라이드 해서 구현.
	public void open() {
		
		for (int i = 0; i < 30; i++) { //신효정: 30개의 "="표시해서
			System.out.print("="); // 내용틀로서 이용한다.
		}
		
		System.out.println("\n덕성여대 컴퓨터공학과"); //신효정: 본인의 대학과 학과 출력
	}

	//신효정: print메소드로 여기서 구현한다. 이것이 display에서 times번 반복해서 호출된다.
	public void print() {
		System.out.printf("학번 "+studentId+" / "+grade+"학년 / "+name+"\n"); // 필드에 기억해둔 문자를 표시
	}

	// close메소드도 여기서 구현
	public void close() {
		System.out.println("템플릿 메소드 패턴 숙제입니다."); //신효정: 과제임을 출력해줌
		
		for (int i = 0; i < 30; i++) { //신효정: 30개의 "="표시해서
			System.out.print("="); // 내용틀로서 이용한다.
		}
		
		
	}
}
