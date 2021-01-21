package ch16.hw;

//‘카운셀러’에게 상담하러 오는 멤버를 나타내는 인터페이스
public interface Colleague {
	//private Mediator mediator; ///연습문제 16-2 답: 인터페이스 안에는 변수를 선언할 수 없고 상수만 선언 가능(변하는 값을 선언 할 수 없음) 즉, 속성값을 바꿀 수 없기 때문에 부모에다가 mediator를 선언해주지 않은 이유이다. 
	// 중재자 설정 메소드
	// Mediator 인터페이스를 구현한 LoginFrame 클래스가 첫번째로 호출하는 메소드
	// “내가 카운셀러니까 기억해두세요”라는 의미
	public abstract void setMediator(Mediator mediator);

	// “카운셀러가 내리는 지시”에 해당함
	// 멤버의 상태를 “유효” 또는 “무효”로 바꾸는 일을 수행한다. //true이면 유효, false이면 무효
	public abstract void setColleagueEnabled(boolean enabled);
}
