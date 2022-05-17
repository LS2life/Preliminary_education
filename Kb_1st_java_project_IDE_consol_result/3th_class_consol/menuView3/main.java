package menuView3;
//테스트

public class main extends Menu {
	public static void main(String[] args) {
		
		Menu_List menulist = new Menu_List();
		menulist.menubar();
		for(CoffeemenuDTO coffeemenuDTO : list) {
			System.out.println(coffeemenuDTO.toString());
		}
		Orderbar o = new Orderbar();
		o.choice();
		o.coffee();
		o.Dessert();
	}
}
