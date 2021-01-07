package ch01.hw;

// 책들을 보관하기 위해서 Vector를 사용한다.
import java.util.Vector;

// 책꽂이를 나타내는 클래스 = 집합체(aggregate)
public class BookShelf implements Aggregate {
	// Book의 배열
	// 이 배열의 크기는, 생성자(BookShelf( )) 호출 시 지정된다.
	private Vector books;

	public BookShelf(int initialsize) {
		this.books = new Vector(initialsize);
	}

	public Book getBookAt(int index) {
		return (Book) books.get(index);
	}

	// 책 한 권을 서가에 추가하는 메소드
	public void appendBook(Book book) {
		books.add(book);
	}

	// 현재 책꽂이에 있는 책의 개수를 반환하는 메소드
	public int getLength() {
		return books.size();
	}

	// 책꽂이의 책 하나하나를 끄집어내는 일을 하는
	// BookShelfIterator를 생성하는 메소드
	public Iterator iterator() {
		return new BookShelfIteratorBackward(this);
	}
}
