package ch04.hw.idcard;
import java.util.*;

import ch04.hw.framework.Factory;
import ch04.hw.framework.Product;

public class IDCardFactory extends Factory {
    private Hashtable database = new Hashtable();
    private int serial = 100;
    protected synchronized Product createProduct(String owner) {
        return new IDCard_HyoJeongShin(owner, serial++);
    }
    protected void registerProduct(Product product) {
        IDCard_HyoJeongShin card = (IDCard_HyoJeongShin)product;
        database.put(card.getOwner(), new Integer(card.getSerial()));
    }
    public Hashtable getDatabase() {
        return database;
    }
}
