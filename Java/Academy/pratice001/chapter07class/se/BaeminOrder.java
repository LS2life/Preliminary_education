package task.chapter07class.se;

public class BaeminOrder {
	private String orderNum;
	public String customerID;
	public String orderDate;
	public String customerName;
	public String productName;
	public String shippingAddress;
	public void orderInfo() {
		System.out.println("주문 번호 :"+orderNum);
		System.out.println("주문자 아이디 :"+customerID);
		System.out.println("주문 날짜 :"+orderDate);
		System.out.println("주문자 이름 :"+customerName);
		System.out.println("주문 상품 번호 :"+productName);
		System.out.println("배송 주소:"+shippingAddress);
	}
	public static void main(String[] args) {
		BaeminOrder order0001 = new BaeminOrder();
		order0001.orderNum = "B17C01EP2P"; 
		order0001.customerID = "Namildong1";
		order0001.orderDate = "2022년 4월 10일"; 
		order0001.customerName = "김세환";
		order0001.productName = "황금올리브반반+콜라1.25L 1개"; 
		order0001.shippingAddress = "대구 수성구 청호로 370";
		order0001.orderInfo();
	}
}