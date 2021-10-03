package com.hp.action;

import java.util.List;

import com.hp.entity.Book;
import com.hp.entity.Category;
import com.hp.service.BookService;
import com.hp.service.CategoryService;
import com.hp.serviceImpl.BookServiceImpl;
import com.hp.serviceImpl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport{
	//前端
	//封装所有类别集合
	private List<Category> categories;
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	//封装所有图书集合
	private List<Book> books; //随机展示
	private List<Book> booksT; // 时间
	private List<Book> booksX; //销量
	private List<Book> booksTX; //时间销量

	public List<Book> getBooksT() {
		return booksT;
	}
	public void setBooksT(List<Book> booksT) {
		this.booksT = booksT;
	}
	public List<Book> getBooksX() {
		return booksX;
	}
	public void setBooksX(List<Book> booksX) {
		this.booksX = booksX;
	}
	public List<Book> getBooksTX() {
		return booksTX;
	}
	public void setBooksTX(List<Book> booksTX) {
		this.booksTX = booksTX;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String findAllC(){
		//查询所有类别
		CategoryService cs = new CategoryServiceImpl();
		categories = cs.findAllC();

		//查询所有图书 ||随机展示两本
		BookService bs = new BookServiceImpl();
		books = bs.findAllB();
		for(Book b:books){
			System.out.println(b);
		}

		//查询图书 || 根据时间排序降序
		booksT = bs.findByT();

		//查询图书 || 根据销量排序降序
		booksX = bs.findByX();

		//查询图书 || 根据时间销量降序
		booksTX = bs.findByTX();

		return "findAllC";
	}



	private String fid;//用户所点击的一级类别id
	private String sid;//用户所点击的二级类别id
	private Category category; //点击获取到的一级类别对象
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	//根据一级二级类别id查询图书||封装集合
	private List<Book> booksOT;
	public List<Book> getBooksOT() {
		return booksOT;
	}
	public void setBooksOT(List<Book> booksOT) {
		this.booksOT = booksOT;
	}
	private Integer currentPage;//当前页
	private Integer pageSize=2;//每一页展示多少条数据
	private Integer pageTotal;//展示总条数
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	//查询一级二级类别及对应图书
	public String findByFid(){
		CategoryService cs = new CategoryServiceImpl();
		System.out.println("===fid====="+fid);
		System.out.println("===sid====="+sid);
		//根据一级类别id查询所有一级类别及下面的对应的二级类别
		category = cs.findByFid(fid);
		System.out.println(category);

		//根据一级二级类别id查询图书
		BookService bs = new BookServiceImpl();
		if(currentPage==null){
			currentPage=1;
			booksOT = bs.findByOT(fid, sid, currentPage, pageSize);
			for(Book b:booksOT){
				System.out.println(b);
			}
			pageTotal = bs.findByBCount(fid, sid, pageSize);
		}else{
			booksOT = bs.findByOT(fid, sid, currentPage, pageSize);
			pageTotal = bs.findByBCount(fid, sid, pageSize);
		}
		return "findByFid";
	}

	//封装查询图书详细信息对象
	private Book book;
	private String id;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//根据图书id查询图书信息
	public String selectOneB(){
		BookService bs = new BookServiceImpl();
		book = bs.findOneB(id);
		
		//根据图书cate_id查询所属类别
		
		CategoryService cs = new CategoryServiceImpl();
		category = cs.findCate(id);
		
		return "selectOneB";
	}
	
}
