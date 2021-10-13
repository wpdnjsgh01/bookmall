package test;

import java.util.List;
import dao.OrderDao;
import vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {

		//selectTest();

	}

	private static void select() {
		List<OrderVo> list = new OrderDao().select();

		for (OrderVo vo : list) {
			System.out.println(vo);
		}

	}
	
	private static void insert() {
		
		OrderVo vo = null;
		OrderDao dao = new OrderDao();
		
		vo = new OrderVo();
		vo.setOrder_code(1);
		vo.setNo(1);
		vo.setPrice(33000);
		vo.setDestination("Busan");
		vo.setMember_no(1);
		dao.insert(vo);
		
		vo = new OrderVo();
		vo.setOrder_code(2);
		vo.setNo(2);
		vo.setPrice(52000);
		vo.setDestination("Ulsan");
		vo.setMember_no(2);
		dao.insert(vo);
		
	}
		
}