package ch11.hw;

public class File extends Entry { ///부모를 Entry로 둠
	private String name;
	private String date;
	private String author;
	
	private int size;

	public File(String name, String date, int size, String author) { //과제: 메소드 추가 
		this.name = name;
		this.date=date;
		this.size = size;
		this.author=author;
	}

	public String getName() {
		return name;
	}
	
	public String getDate() { //과제: 메소드 추가
		return date;
	}
	
	public String getAuthor() { //과제: 메소드 추가
		return author;
	}

	public int getSize() {
		return size;
	}
	
	public int getCount() { //과제: 메소드 추가, 파일이므로 1을 반환
		return 1;
	}

	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this); ///this는 this.toString()과 같음 (생략 가능. 있으나 없으나 같음)
	}
}
