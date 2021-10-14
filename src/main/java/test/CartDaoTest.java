package test;

import java.util.List;

import dao.BookDao;
import dao.CartDao;
import dto.BookDto;
import dto.CartDto;
import vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {

		//select();
		//insert();

	}

	public static void select() {
		
		List<CartDto> list = new CartDao().select();

		for (CartDto dto : list) {
			System.out.println(dto);
		}

	}
	
	public static void insert() {
		
		CartVo vo = null;
		CartDao dao = new CartDao();
		
		vo = new CartVo();
		vo.setQuantity(1);
		vo.setBook_no(1);
		vo.setMember_no(1);
		dao.insert(vo);
		
		vo = new CartVo();
		vo.setQuantity(2);
		vo.setBook_no(2);
		vo.setMember_no(2);
		dao.insert(vo);
		
		
		
	}
		
}