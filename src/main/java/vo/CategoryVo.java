package vo;

public class CategoryVo {

	private int no;
	private String cat_name;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	@Override
	public String toString() {
		return "Category [ 넘버링 = " + no + ", cat_name=" + cat_name + "]";
	}

}
