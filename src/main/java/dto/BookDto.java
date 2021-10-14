package dto;

public class BookDto {

	private int no;
	private String title;
	private int price;
	private String cat_name;

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

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	@Override
	public String toString() {
		return "BookDto [no=" + no + ", title=" + title + ", price=" + price + ", cat_name='" + cat_name + "']";
	}

}
