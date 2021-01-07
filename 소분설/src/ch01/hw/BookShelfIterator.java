package ch01.hw;

// 책꽂이(BookShelf)에 있는 책들을 하나씩 끄집어내는 일을 하는 클래스
// Iterator 인터페이스를 구현하였다
public class BookShelfIterator implements Iterator {
	// BookShelfIterator가 검색할 책꽂이를 가리키는 변수
	// (생성자에서 넘겨받은 BookShelf의 인스턴스를 가지고 있음)
	private BookShelf bookShelf;
	// 책꽂이에서의 현재 책을 가리키는 변수
	private int index;

	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	// 다음 책이 있으면 true, 없으면 false를 반환함
	public boolean hasNext() {
		if (index < bookShelf.getLength()) {
			return true;
		} else {
			return false;
		}
	}

	// 현재 가리키고 있는 책을 반환하고, 다음 책을 가리키는 메소드
	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}
}
