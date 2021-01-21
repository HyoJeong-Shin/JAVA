package ch16.hw;

// ‘카운셀러’를 표현하는 인터페이스
public interface Mediator {
	// mediator가 관리하는 멤버를 생성하는 메소드
	public abstract void createColleagues();

	// 각 멤버가 ‘상담’을 요청할 때 호출하는 메소드
	// 라디오 버튼이나 텍스트 필드의 상태가 변화했을 때, 이 메소드가 호출된다.
	public abstract void colleagueChanged(Colleague colleague);
}
