package ch11.hw;

public abstract class Entry {
	public abstract String getName(); // 이름을 얻는다. ///추상메소드, 자식들이 구현할 것임

	public abstract String getDate();	//과제: 추상메소드 작성
	
	public abstract String getAuthor();	//과제: 추상메소드 작성
	
	public abstract int getSize(); // 사이즈를 얻는다.
	
	public abstract int getCount(); //과제: 추상메소드 작성

	public Entry add(Entry entry) throws FileTreatmentException { ///내용물을 추가할때 호출하는 메소드, 부모 타입으로 선언 (Entry entry)
		// 이 클래스에 다른 엔트리를 추가하려고 하면, 예외를 발생시킨다.
		// "자신이 처리하지 않고, 이 메소드를 호출한 객체로 전파시킨다"라고 선언되어 있음.
		throw new FileTreatmentException(); ///예외발생시키는 메소드, Entry는 추상클래스로 뭘 더하지 못하게 함. ///directory에는 더할 수 있도록 자식이 구현해줌
	}

	//printList: 메소드 오버로딩
	public void printList() { // 일람을 표시한다. ///인자가 없는 printList
		printList(""); ///널문자열 ///인자 있는 printList 호출
	}

	protected abstract void printList(String prefix); // prefix를 앞에 붙여서 일람을  ///인자가 있는 printList (인자는 문자열)	///추상메소드로 자식들이 구현
														// 표시한다.	

	public String toString() { // 문자열 표현 	//과제:과제 출력 형식에 맞춰 getDate(), getCount(), getAuthor() 메소드 추가  
		return getName() + " (" + getSize() + ")" + " ["+getDate()+"]"+" ["+getCount()+"개]"+" ["+getAuthor()+"]";
	}
}
