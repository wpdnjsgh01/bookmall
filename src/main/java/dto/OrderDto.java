package dto;

public class OrderDto {

	private int order_code;
	private int no;
	private int price;
	private String destination;
	private String member_name;

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	@Override
	public String toString() {
		return "OrderDto [order_code=" + order_code + ", no=" + no + ", price=" + price + ", destination=" + destination
				+ ", member_name=" + member_name + "]";
	}

}
