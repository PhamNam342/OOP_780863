
public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD= new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD= new DigitalVideoDisc("Cinderella");
		swap(jungleDVD,cinderellaDVD);
		System.out.println("jungleDVD title: "+ jungleDVD.getTitle());
		System.out.println("cinderellaDVD title: "+cinderellaDVD.getTitle());
		changetitle(jungleDVD,"cinderella");
		System.out.println("jungle DVD title: "+ jungleDVD.getTitle());
	}
	public static void swap(Object o1,Object o2) {
			Object tmp=o1;
			o1=o2;
			o2=tmp;
		}
	public static void changetitle(DigitalVideoDisc dvd, String title) {
		String oldtitle= dvd.getTitle();
		dvd.setTitle(title);
		dvd= new DigitalVideoDisc(oldtitle);
	}

}
