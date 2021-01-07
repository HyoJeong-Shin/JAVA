package ch01.hw;

// 책꽂이(BookShelf)에 있는 책들을 하나씩 끄집어내는 일을 하는 클래스
// Iterator 인터페이스를 구현하였다
public class BookShelfIteratorBackward implements Iterator {
	// BookShelfIterator가 검색할 책꽂이를 가리키는 변수
	// (생성자에서 넘겨받은 BookShelf의 인스턴스를 가지고 있음)
	private BookShelf bookShelf;
	// 책꽂이에서의 현재 책을 가리키는 변수
	private int index;

	public BookShelfIteratorBackward(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = bookShelf.getLength()-1; //신효정: 책꽂이 마지막으로 초기화한다.
	}

	// 다음 책이 있으면 true, 없으면 false를 반환함
	public boolean hasNext() {
		if (index >= 0) { //index가 0일 때는 책을 꺼내올 수 있다. 왜냐하면 책꽂이의 배열은 [0],[1],[2] 이런 식으로 되어있기 때문이다. (책의 수는 1,2,3 이런 식으로 진행됨)
			return true;
		} else {
			return false;
		}
	}

	// 현재 가리키고 있는 책을 반환하고, 다음 책을 가리키는 메소드
	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index--; //신효정: 현재 책번호를 1 감소시킨다.
		return book;
	}
}
