package test;

import java.util.List;
import dao.MemberDao;
import vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {

		//select();
		//insert();

	}

	public static void select() {
		List<MemberVo> list = new MemberDao().select();

		for (MemberVo vo : list) {
			System.out.println(vo);
		}

	}
	
	public static void insert() {
		
		MemberVo vo = null;
		MemberDao dao = new MemberDao();
		
		vo = new MemberVo();
		vo.setName("제임스");
		vo.setEmail("james@naver.com");
		vo.setPassword("ssunjajjang");
		vo.setPhone_number("010-3478-7932");
		dao.insert(vo);
		
		vo = new MemberVo();
		vo.setName("알라딘");
		vo.setEmail("ironjaWorld@naver.com");
		vo.setPassword("ironsum");
		vo.setPhone_number("010-3478-7932");
		dao.insert(vo);
		
	}
		
}