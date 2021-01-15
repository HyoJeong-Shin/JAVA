package ch05.hw.idcard;

import ch05.hw.framework.*;

public class IDCard extends Product {
    private String owner;

    // private이나 public 으로 선언되어 있지 않으면, 
    // 같은 패키지에 속한 클래스들만이 이 생성자를 호출할 수 있다.
    IDCard(String owner) { //생성자 IDCard 
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }
    public void use() {
        System.out.println(owner + "의 카드를 사용합니다.");
    }
    public String getOwner() {
        return owner;
    }
	
}
