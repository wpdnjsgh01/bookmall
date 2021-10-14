package main;

import test.BookDaoTest;
import test.CartDaoTest;
import test.CategoryDaoTest;
import test.MemberDaoTest;
import test.OrderDaoTest;
import test.OrderbookDaoTest;

public class Bookmall_main {

	public static void main(String[] args) {
	
		MemberDaoTest member = new MemberDaoTest();
		BookDaoTest book = new BookDaoTest();
		CategoryDaoTest category = new CategoryDaoTest();
		CartDaoTest cart = new CartDaoTest();
		OrderDaoTest order = new OrderDaoTest();
		OrderbookDaoTest orderbook = new OrderbookDaoTest();
		
		category.insert();
		System.out.println("category 데이터 생성");
		member.insert();
		System.out.println("member 데이터 생성");
		book.insert();
		System.out.println("book 데이터 생성");
		cart.insert();
		System.out.println("cart 데이터 생성");
		order.insert();
		System.out.println("order 데이터 생성");
		orderbook.insert();
		System.out.println("orderbook 데이터 생성");
		System.out.println("");
		System.out.println("");
		
		System.out.println("=========== CATEGORY ===========");
		category.select();
		System.out.println("=========== MEMBER ===========");
		member.select();
		System.out.println("=========== BOOK ===========");
		book.select();
		System.out.println("=========== CART ===========");
		cart.select();
		System.out.println("=========== ORDER ===========");
		order.select();
		System.out.println("=========== ORDER_BOOK ===========");
		orderbook.select();
		
	}

}
