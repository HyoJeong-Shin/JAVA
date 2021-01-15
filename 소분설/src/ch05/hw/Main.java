package ch05.hw;

import ch05.hw.idcard.IDCardFactoryHyoJeongShin2;
import ch05.hw.idcard.IDCardFactoryHyoJeongShin1;

public class Main extends Thread {
	public Main(String name) {
		super(name); 
	}

	public static void main(String[] args) {
		
		//1. IDCardFactoryHyoJeongShin1 테스트
		
		IDCardFactoryHyoJeongShin1 factory1 = IDCardFactoryHyoJeongShin1.getInstance();
        IDCardFactoryHyoJeongShin1 factory2 = IDCardFactoryHyoJeongShin1.getInstance();
        
        //System.out.println("factory1의 주소: "+ factory1);
		//System.out.println("factory2의 주소: "+ factory2);
        
        if(factory1==factory2){
        	System.out.println("factory1 과 factory2 는 같은 인스턴스입니다.");
        }else {
        	System.out.println("factory1 과 factory2 는 다른 인스턴스입니다.");
        }
		
		
        //2. IDCardFactoryHyoJeongShin2 테스트
		new Main("최승훈").start();  
		new Main("신효정").start(); 
		new Main("김홍주").start(); 
	}
	
	// Main 스레드 객체가 할 일
	public void run() {
		IDCardFactoryHyoJeongShin2 id= IDCardFactoryHyoJeongShin2.getInstance(); // Singleton 객체 얻음
		System.out.println(getName() + " IDCardFactoryHyoJeongShin2의 주소: =" + id);
		
	}

}
