package ch05.hw.idcard;

import java.util.Vector;

import ch05.hw.idcard.IDCard;
import ch05.hw.framework.Factory;
import ch05.hw.framework.Product;

public class IDCardFactoryHyoJeongShin2 extends Factory {

	 	private static IDCardFactoryHyoJeongShin2 idcardfactoryhyojeongshin2 = null; 
		
		private IDCardFactoryHyoJeongShin2() {
			System.out.println("인스턴스를 생성합니다.");
			slowdown(); 
			
		}
		
		public static synchronized IDCardFactoryHyoJeongShin2 getInstance() {
			if (idcardfactoryhyojeongshin2 == null) {
				idcardfactoryhyojeongshin2 = new IDCardFactoryHyoJeongShin2();
			}
			return idcardfactoryhyojeongshin2; 
		}

		private void slowdown() {
			
			try {
				Thread.sleep(3000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
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
