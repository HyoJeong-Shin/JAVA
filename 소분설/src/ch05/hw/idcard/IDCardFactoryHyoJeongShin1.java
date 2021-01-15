package ch05.hw.idcard;


import ch05.hw.framework.*;
import ch05.hw.idcard.IDCard;
import java.util.*;


public class IDCardFactoryHyoJeongShin1 extends Factory{

	
		private static IDCardFactoryHyoJeongShin1 idcardfactoryhyojeongshin1 = new IDCardFactoryHyoJeongShin1();
	
		private IDCardFactoryHyoJeongShin1() {
			System.out.println("인스턴스를 생성합니다.");
		}
	
		public static IDCardFactoryHyoJeongShin1 getInstance() {
			return idcardfactoryhyojeongshin1;
		}
		
		
		private Vector owners = new Vector();
		
	    protected Product createProduct(String owner) { 
	        return new IDCard(owner);
	    }
	
	    protected void registerProduct(Product product) { 
			owners.add(((IDCard)product).getOwner()); 
	    }
	    public Vector getOwners() {
	        return owners;
	    }
	  	
		
		
}
