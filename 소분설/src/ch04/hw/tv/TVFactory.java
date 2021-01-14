package ch04.hw.tv;

import java.util.Iterator;
import java.util.Vector;

import ch04.hw.framework.Factory;
import ch04.hw.framework.Product;

public class TVFactory extends Factory {
	
	    private Vector<String> modelNos= new Vector<>(); //신효정: 속성, 생산된 제품들의 "모델번호"를 저장하는 변수
	    
	    protected synchronized Product createProduct(String modelNos) { //신효정: 입력된 모델 번호의 TV를 생성해서 반환
	        return new TV_HyoJeongShin(modelNos);
	    }
	    
	    protected void registerProduct(Product product) { 
	        TV_HyoJeongShin tv = (TV_HyoJeongShin)product;
	        modelNos.add(tv.getmodelNo()); //신효정: 입력인자인 product의 (모델번호)를 modelNos에 추가함
	    }
	    
	   
	    public void printAllModelNumbers() { //신효정: modelNos에 저장되어 있는 모델 번호들을 하나씩 끄집어내 와서 출력함
	    	Iterator<String> it = modelNos.iterator(); //신효정: iterator를 얻어옴
	
			while(it.hasNext()) { //신효정: iterator의 hasNext()메소드 이용
				String mn = it.next(); //신효정: iterator의 next()메소드를 이용
				System.out.println(mn); 
			}
	    }
}
