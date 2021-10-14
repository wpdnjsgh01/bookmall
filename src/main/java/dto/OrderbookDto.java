package dto;

public class OrderbookDto {

	private int quantity;
	private int price;
	private String order_code;
	private String title;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrder_code() {
		return order_code;
	}

	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "OrderbookVo [quantity=" + quantity + ", price=" + price + ", order_code=" + order_code + ", title="
				+ title + "]";
	}

}
