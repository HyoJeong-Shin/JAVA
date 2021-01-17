package ch10.hw;

public class SortAndPrint {
	// Comparable: 크기 비교 가능한 클래스들이 구현하는 인터페이스
	//             String 클래스도 이 인터페이스를 구현했음.
    Comparable[] data;
    Sorter sorter; // 부모 타입
    
    //public SortAndPrint(String[] data, Sorter sorter) {
    public SortAndPrint(Comparable[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }
    
    // Sorter의 종류를 새로 설정하는 메소드 
    public void setSorter(Sorter sorter) {
    	this.sorter=sorter;
    		
    }
    
    public void execute() {
        print(); // 정렬 전 출력 (자신이 함)
        long startTime = System.nanoTime(); 
        sorter.sort(data); // 현재 정렬 전략 객체에서 정렬을 위임함
        long endTime = System.nanoTime(); 

        print(); // 정렬 후 출력
        
        System.out.println("*execution time: "+(endTime-startTime)/10000+"(miliseconds)");
    }
    public void print() { //for문 이용해서 데이터 출력
        for (int i = 0 ; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("");
    }
}
