package ch11.hw;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {
	private String name; // 디렉토리의 이름
	private String date; //과제: 디렉토리가 작성된 날짜 
	private String author;//과제: 디렉토리 작성자 이름 
	///내용물 담고 있는 변수 
	private Vector directory = new Vector(); // 디렉토리 엔트리의 집합  ///하나씩 추가 가능. 배열과 다른 점: 크기가 자동으로 늘어남

	public Directory(String name,String date, String author) { // 생성자
		this.name = name;
		this.date = date;
		this.author=author;
	}

	public String getName() { // 이름을 얻는다.
		return name;
	}
	
	public String getDate() { //과제: 날짜를 얻음
		return date;
	}
	
	public String getAuthor() { //과제: 작가 이름을 얻음 
		return author;
	}

	///자기 내용물의 사이즈를 모두 합쳐서 리턴하는 메소드 
	public int getSize() { // 사이즈를 얻는다.
		int size = 0;
		// 자신이 가지고 있는 모든 엔트리에 대해서, getSize( )호출하여 더한다.
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			// entry는 Entry 타입으로 선언되어 있고,
			// Entry는 File이나 Directory의 부모 클래스이기 때문에 둘 다 참조할 수 있다.
			Entry entry = (Entry) it.next(); ///Entry로 타입캐스트 해줘야함
			// entry가 디렉토리인 경우에는, 다시 이 디렉토리의 getSize( )가 재귀적으로 호출된다. 
			size += entry.getSize(); ///getSize 값 size에 저장 
			// => 그릇과 내용물이 동일시 된다.
		}
		return size;
	}
	
	public int getCount() { //과제: 자기 아래에 포함된 모든 파일의 개수를 얻어 반환하는 getCount()메소드 작성 
		int count = 0;
		// 자신이 가지고 있는 모든 엔트리에 대해서, getCount( )호출하여 더한다.
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			// entry는 Entry 타입으로 선언되어 있고,
			// Entry는 File이나 Directory의 부모 클래스이기 때문에 둘 다 참조할 수 있다.
			Entry entry = (Entry) it.next(); ///Entry로 타입캐스트 해줘야함
			// entry가 디렉토리인 경우에는, 다시 이 디렉토리의 getCount()가 재귀적으로 호출된다. 
			count += entry.getCount(); ///getCount 값 count에 저장 
			// => 그릇과 내용물이 동일시 된다.
		}
		return count;
		
	}

	public Entry add(Entry entry) { // 엔트리의 추가
		// 입력인자로 들어온 Entry(File 또는 Directory 객체)를 벡터에 저장한다.
		directory.add(entry);
		return this;	///현재 객체, 즉, 디렉토리를 리턴함 
	}

	///prefix: 자기 앞까지의 경로 
	protected void printList(String prefix) { // 엔트리의 일람
		System.out.println(prefix + "/" + this);
		// 자신이 가지고 있는 모든 엔트리에 대해서, printList( )호출한다.
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next(); ///내용물을 얻어서
			/// 자기까지 포함한 경로를 prefix로 만들어서 내용물에 전달함  
			entry.printList(prefix + "/" + name); ///printList() 호출 
		}
	}
}
