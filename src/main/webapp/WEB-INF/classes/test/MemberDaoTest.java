package test;

import java.util.List;
import dao.MemberDao;
import vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {

		//selectTest();

	}

	private static void select() {
		List<MemberVo> list = new MemberDao().select();

		for (MemberVo vo : list) {
			System.out.println(vo);
		}

	}
	
	private static void insert() {
		
		MemberVo vo = null;
		MemberDao dao = new MemberDao();
		
		vo = new MemberVo();
		vo.setName("ssun ja Park");
		vo.setEmail("ssunjaWorld@naver.com");
		vo.setPassword("ssunjajjang");
		dao.insert(vo);
		
		vo = new MemberVo();
		vo.setName("chul ja Kim");
		vo.setEmail("ironjaWorld@naver.com");
		vo.setPassword("ironsum");
		dao.insert(vo);
		
	}
		
}