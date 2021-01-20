package ch11.hw;


public class Main {

	public static void main(String[] args) throws FileTreatmentException {
		try {
		Entry f0=new File("신효정0.doc","20191001",1000,"SeungHoonChoi"); //과제: 파일 객체 생성
		Entry f1=new File("신효정1.doc","20191001",1500,"SeungHoonChoi");
		Entry f2=new File("신효정2.java","2019101",2000,"SeungHoonChoi");
		Entry f3=new File("신효정3.gif","20191101",2500,"SeungHoonChoi");
		Entry f4=new File("신효정4.jpg","20191101",3000,"SeungHoonChoi");
		Entry f5=new File("신효정5.png","20191101",3500,"SeungHoonChoi");
	
		System.out.println("c:> java Main");
		System.out.println("20181030, 신효정"); //과제: 학번, 이름 
		
		
		Entry d1= new Directory("MyDocuments","20190901","SeungHoonChoi"); //과제: 디렉토리 객체 생성
		Entry d1_1= new Directory("MyData","20190901","SeungHoonChoi");
		Entry d1_2 = new Directory("MyDataPictures","20190901","SeungHoonChoi");
		
		d1.add(f0);  //과제: 디렉토리 d1에다가 아까 만들었던 파일 f0을 더함
		d1.add(d1_1);	//과제: 디렉토리 d1에다가 아까 만들었던 디렉토리 d1_1을 더함
		
		d1_1.add(f1);	//과제: 디렉토리 d1_1에다가 아까 만들었던 파일 f1을 더함
		d1_1.add(f2);	//과제: 디렉토리 d1_1에다가 아까 만들었던 파일 f2을 더함
		d1_1.add(d1_2); //과제: 디렉토리 d1_1에다가 아까 만들었던 디렉토리 d1_2을 더함
		
		d1_2.add(f3);	//과제: 디렉토리 d1_3에다가 아까 만들었던 파일 f3을 더함
		d1_2.add(f4);	//과제: 디렉토리 d1_3에다가 아까 만들었던 파일 f4을 더함
		d1_2.add(f5);	//과제: 디렉토리 d1_3에다가 아까 만들었던 파일 f5을 더함
		
		d1.printList();	//과제: 디렉토리 d1 아래에 속한 내용들 출력 
	
		} catch (FileTreatmentException e) {
		e.printStackTrace();
		}
	}

}
