package vo;

public class OrderbookVo {

	private int quantity;
	private int price;
	private int order_no;
	private int book_no;

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

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	@Override
	public String toString() {
		return "OrderbookVo [quantity=" + quantity + ", price=" + price + ", order_no=" + order_no + ", book_no="
				+ book_no + "]";
	}

}
