
public class Cart {
	public static final int MAX_NUMBERS_ORDERED=20;
	private DigitalVideoDisc[] itemsOrdered= new DigitalVideoDisc [MAX_NUMBERS_ORDERED];
	private int qtyOrdered=0;
	public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
		if(qtyOrdered<MAX_NUMBERS_ORDERED) {
			qtyOrdered++;
			itemsOrdered[qtyOrdered]=dvd;
			System.out.println(dvd.getTitle()+" has been added to your cart!");
		}
		else {
			System.out.println("Your cart is already full!");
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc [] disclist) {
		if(qtyOrdered+ disclist.length<=MAX_NUMBERS_ORDERED) {
			for(DigitalVideoDisc dvd: disclist) {
				qtyOrdered++;
				itemsOrdered[qtyOrdered]=dvd;
				System.out.println(dvd.getTitle()+" has been added to your cart!");
			}
		}
			else {
				System.out.println("Your cart is already full!");
			}
		}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(qtyOrdered+ 2<=MAX_NUMBERS_ORDERED) {
			qtyOrdered++;
			itemsOrdered[qtyOrdered]=dvd1;
			System.out.println(dvd1.getTitle()+" has been added to your cart!");
			qtyOrdered++;
			itemsOrdered[qtyOrdered]=dvd2;
			System.out.println(dvd2.getTitle()+" has been added to your cart!");
		}
		else {
			System.out.println("Your cart is already full!");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
		if(qtyOrdered==0) {
			System.out.println("Your cart is empty!");
		}
		else {
			for(int i=1;i<=qtyOrdered;i++) {
				if(itemsOrdered[i].equals(dvd)) {
					for(int j=i;j<=qtyOrdered;j++) {
						itemsOrdered[j]=itemsOrdered[j+1];
						}
					qtyOrdered--;
					System.out.println(dvd.getTitle()+" has been removed from your cart!");
					break;
					}
			}
		}
	}
		public float total() {
			if(qtyOrdered==0) {
				return 0;
			}
			else {
				float revenue=0;
				for(int i=1;i<=qtyOrdered;i++) {
					revenue+=itemsOrdered[i].getCost();
				}
				return revenue;
			}
		}
		public void display() {
			if(qtyOrdered==0) {
				System.out.println("Your cart is empty!");
			}
			else {
				for(int i=1;i<=qtyOrdered;i++) {
					System.out.printf("%-3d %-20s %-4.2f ",i,itemsOrdered[i].getTitle(),itemsOrdered[i].getCost());
				}
				System.out.println("Total cost: "+ total());
			}
		}
	}
