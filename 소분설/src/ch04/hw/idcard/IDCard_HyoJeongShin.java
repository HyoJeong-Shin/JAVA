package ch04.hw.idcard;

import ch04.hw.framework.*;

public class IDCard_HyoJeongShin extends Product {
    private String owner;
    private int serial;
    IDCard_HyoJeongShin(String owner, int serial) {
        System.out.println(owner + "(" + serial + ")" + "의 카드를 만듭니다.");
        this.owner = owner;
        this.serial = serial;
    }
    public void use() {
        System.out.println(owner + "(" + serial + ")" + "의 카드를 사용합니다.");
    }
    public String getOwner() {
        return owner;
    }
    public int getSerial() {
        return serial;
    }
}
