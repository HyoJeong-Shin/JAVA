package ch04.hw;

import ch04.hw.framework.*;
import ch04.hw.idcard.*;
import ch04.hw.tv.*;

public class Main {
    public static void main(String[] args) {
    	
    	System.out.println("<<20181030, 신효정>>");
    	
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("김하나"); //신효정: IDCard_New 제품 생성
        Product card2 = factory.create("신효정");
        
        card1.use();
        card2.use();
        
        Factory factory2 = new TVFactory();
        Product tv1 = factory2.create("20181030"); //신효정: TV생성
        Product tv2 = factory2.create("111");
        Product tv3 = factory2.create("222");
        Product tv4 = factory2.create("333");
        
        tv1.use();
        tv2.use();
        tv3.use();
        tv4.use();
        
        ((TVFactory) factory2).printAllModelNumbers(); //신효정: 모든 TV의 모델 번호 출력

    }
}
