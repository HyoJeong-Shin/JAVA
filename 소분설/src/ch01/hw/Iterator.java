package ch01.hw;

// 집합체의 원소를 하나하나 끄집어내는 루프 변수와 같은 역할을 한다.
public interface Iterator {
	// 다음 원소가 존재하는지 조사할 때 사용하는 메소드
	// 반환형은 boolean (마지막 원소에 도달하면 false를 반환함)
    public abstract boolean hasNext();
    // 다음 원소를 얻어올 때 사용하는 메소드
    // 반환형은 Object
    public abstract Object next();
}