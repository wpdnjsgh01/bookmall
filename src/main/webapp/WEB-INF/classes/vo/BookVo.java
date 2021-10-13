package vo;

public class BookVo {

	private int no;
	private String title;
	private int price;
	private int cat_no;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCat_no() {
		return cat_no;
	}

	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", price=" + price + ", cat_no=" + cat_no + "]";
	}

}
