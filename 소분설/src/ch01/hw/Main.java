package ch01.hw;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번:20181030, 이름:신효정");
        // 책꽂이를 만든다.
        BookShelf bookShelf = new BookShelf(5);
        
        // 책을 만들어서 책꽂이에 넣는다
        bookShelf.appendBook(new Book("자료구조론", "박우창"));
        bookShelf.appendBook(new Book("소프트웨어분석설계", "최승훈"));
        bookShelf.appendBook(new Book("프로그래머수학", "이주영"));
        bookShelf.appendBook(new Book("컴퓨터동작원리", "유견아"));
        bookShelf.appendBook(new Book("컴퓨터그래픽스", "이경미"));
        
        // 책꽂이의 책을 하나씩 끄집어낼 Iterator를 얻는다.
        Iterator it = bookShelf.iterator();
        
        // Iterator의 hasNext( )와 next( ) 메소드를 이용하여 
        // 책을 하나씩 끄집어내서 책의 이름을 출력한다.
        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println("" + book.getName()+":"+book.getAuthor()); // 책의 이름을 얻어옴
        }
    }
}
//책이 꽂은 거 역순으로 출력되면 잘 출력이 된 것.