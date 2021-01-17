package ch10.hw;

public class Main {
    public static void main(String[] args) {
    	
    	Student s1= new Student("신효정","20181030",160);
        Student s2= new Student("홍길동","20181001",155);
        Student s3= new Student("일지매","20181015",180);
        Student s4= new Student("임꺽정","20181020",170);
        Student s5= new Student("이순신","20181040",175);     
        
        Student[] data={
        		s1,s2,s3,s4,s5
        };
        
        Student[] data2={
        		s1,s2,s3,s4,s5
        };
        
        Student[] data3={
        		s1,s2,s3,s4,s5
        };

        System.out.println("20181030, 신효정");
        System.out.println("<정렬 결과>");
        
        SortAndPrint sap = new SortAndPrint(data, new InsertSorter()); // 정렬할 데이터 data, 정렬할 때 사용할 Sorter의 종류를 넘겨줌
        System.out.println("(1) by InsertSorter:");

        sap.execute();       

        
        // Sorter를 QuickSorter로 교체
        sap = new SortAndPrint(data2, new QuickSorter());
        sap.setSorter(new QuickSorter());
        System.out.println("(2) by QuickSorter:");
        
        sap.execute();        
    
        // 숙제: Sorter를 BubbleSorter로 설정
        sap = new SortAndPrint(data3, new BubbleSorter());
        System.out.println("(3) by BubbleSorter:");
               
        sap.execute();        
        
    }
}
