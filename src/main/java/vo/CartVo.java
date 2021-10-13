package vo;

public class CartVo {

	private int quantity;
	private int book_no;
	private int member_no;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	@Override
	public String toString() {
		return "CartVo [quantity=" + quantity + ", book_no=" + book_no + ", member_no=" + member_no + "]";
	}

}
