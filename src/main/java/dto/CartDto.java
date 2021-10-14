package dto;

public class CartDto {

	private int quantity;
	private String book_title;
	private String member_name;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	@Override
	public String toString() {
		return "CartDto [quantity=" + quantity + ", book_title=" + book_title + ", member_name=" + member_name + "]";
	}

}
