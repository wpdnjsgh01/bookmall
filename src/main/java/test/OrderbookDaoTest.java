package test;

import java.util.List;

import dao.OrderbookDao;
import dto.OrderbookDto;
import vo.OrderbookVo;


public class OrderbookDaoTest {

	public static void main(String[] args) {

		//select();
		//insert();

	}

	public static void select() {
		List<OrderbookDto> list = new OrderbookDao().select();

		for (OrderbookDto dto : list) {
			System.out.println(dto);
		}

	}
	
	public static void insert() {
		
		OrderbookVo vo = null;
		OrderbookDao dao = new OrderbookDao();
		
		vo = new OrderbookVo();
		vo.setQuantity(3);
		vo.setPrice(27000);
		vo.setBook_no(2);
		vo.setOrder_no(1);
		dao.insert(vo);
		
		vo = new OrderbookVo();
		vo.setQuantity(2);
		vo.setPrice(46002);
		vo.setBook_no(1);
		vo.setOrder_no(1);
		dao.insert(vo);
		
	}
		
}