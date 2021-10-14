package test;

import java.util.List;

import dao.CategoryDao;
import vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		
		select();
		//insert();
	}
	
	public static void select() {
		List<CategoryVo> list = new CategoryDao().select();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void insert() {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();
		
		vo = new CategoryVo();
		vo.setCat_name("tech");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setCat_name("essay");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setCat_name("novel");
		dao.insert(vo);
	}
}