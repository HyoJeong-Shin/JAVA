package ch01.hw;

//책꽂이에 꽂힐 책을 나타내는 클래스
public class Book {
	// 책이름을 저장하는 변수
    private String name = ""; //책의 이름을 저장한다.
    private String author = ""; //신효정: 첵의 저자를 저장한다.
    
    public Book(String name,String author) {
        this.name = name;
        this.author = author;
    }
    // 책의 이름을 얻어올 때 호출하는 메소드
    public String getName() {
        return name;
    }
    //신효정: 자신의 저자를 반환하는 메소드
    public String getAuthor() {
        return author;
    }
}
