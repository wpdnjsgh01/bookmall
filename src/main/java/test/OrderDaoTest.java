package test;

import java.util.List;
import dao.OrderDao;
import dto.OrderDto;
import vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {

		//select();
		//insert();

	}

	public static void select() {
		List<OrderDto> list = new OrderDao().select();

		for (OrderDto dto : list) {
			System.out.println(dto);
		}

	}
	
	public static void insert() {
		
		OrderVo vo = null;
		OrderDao dao = new OrderDao();
		
		vo = new OrderVo();
		vo.setOrder_code(1);
		vo.setNo(1);
		vo.setPrice(73002);
		vo.setDestination("Busan");
		vo.setMember_no(1);
		dao.insert(vo);

	}
		
}