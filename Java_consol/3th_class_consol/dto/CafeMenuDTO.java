package dto;

public class CafeMenuDTO {
	private int no ; //번호
	private String menu; //메뉴
	private int price; //가격
	private int amount; // 수량
	private int kcal; //칼로리

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	@Override
	public String toString() {
		return "[ " + no + ". " + menu + "( " + kcal+ " )" + "          " + price + " ]";
	}
}
	
	

	