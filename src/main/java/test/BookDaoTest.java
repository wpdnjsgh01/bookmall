package test;

import java.util.List;
import dao.BookDao;
import vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {

		//insert();
		select();

	}

	private static void select() {
		List<BookVo> list = new BookDao().select();

		for (BookVo vo : list) {
			System.out.println(vo);
		}

	}
	
	private static void insert() {
		
		BookVo vo = null;
		BookDao dao = new BookDao();
		
		vo = new BookVo();
		vo.setTitle("아프면 청춘이 아니다");
		vo.setPrice(23001);
		vo.setCat_no(1);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("밥이 보약이다");
		vo.setPrice(9000);
		vo.setCat_no(2);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("고기의 축재");
		vo.setPrice(19000);
		vo.setCat_no(3);
		dao.insert(vo);
		
	}
		
}
