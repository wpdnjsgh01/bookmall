package test;

import java.util.List;
import dao.CartDao;
import vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {

		//selectTest();

	}

	private static void select() {
		List<CartVo> list = new CartDao().select();

		for (CartVo vo : list) {
			System.out.println(vo);
		}

	}
	
	private static void insert() {
		
		CartVo vo = null;
		CartDao dao = new CartDao();
		
		vo = new CartVo();
		vo.setQuantity(1);
		vo.setBook_no(1);
		vo.setMember_no(2);
		dao.insert(vo);
		
		vo = new CartVo();
		vo.setQuantity(4);
		vo.setBook_no(2);
		vo.setMember_no(2);
		dao.insert(vo);
		
	}
		
}