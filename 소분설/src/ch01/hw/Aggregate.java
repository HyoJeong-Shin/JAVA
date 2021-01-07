package ch01.hw;

// 집합체를 나타냄
public interface Aggregate {
	// 집합체에 대응하는 Iterator 한 개를 생성하는데 사용될 메소드
	// 어떤 집합체의 원소를 하나씩 열거하거나 조사하고자 할 때 
	// 이 메소드를 사용해서 Iterator 인터페이스를 구현한 
	// 클래스의 인스턴스를 한 개 얻어온다.
    public abstract Iterator iterator();
}
