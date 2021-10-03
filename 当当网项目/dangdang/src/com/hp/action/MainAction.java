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
	//ǰ��
	//��װ������𼯺�
	private List<Category> categories;
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	//��װ����ͼ�鼯��
	private List<Book> books; //���չʾ
	private List<Book> booksT; // ʱ��
	private List<Book> booksX; //����
	private List<Book> booksTX; //ʱ������

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
		//��ѯ�������
		CategoryService cs = new CategoryServiceImpl();
		categories = cs.findAllC();

		//��ѯ����ͼ�� ||���չʾ����
		BookService bs = new BookServiceImpl();
		books = bs.findAllB();
		for(Book b:books){
			System.out.println(b);
		}

		//��ѯͼ�� || ����ʱ��������
		booksT = bs.findByT();

		//��ѯͼ�� || ��������������
		booksX = bs.findByX();

		//��ѯͼ�� || ����ʱ����������
		booksTX = bs.findByTX();

		return "findAllC";
	}



	private String fid;//�û��������һ�����id
	private String sid;//�û�������Ķ������id
	private Category category; //�����ȡ����һ��������
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
	//����һ���������id��ѯͼ��||��װ����
	private List<Book> booksOT;
	public List<Book> getBooksOT() {
		return booksOT;
	}
	public void setBooksOT(List<Book> booksOT) {
		this.booksOT = booksOT;
	}
	private Integer currentPage;//��ǰҳ
	private Integer pageSize=2;//ÿһҳչʾ����������
	private Integer pageTotal;//չʾ������
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
	//��ѯһ��������𼰶�Ӧͼ��
	public String findByFid(){
		CategoryService cs = new CategoryServiceImpl();
		System.out.println("===fid====="+fid);
		System.out.println("===sid====="+sid);
		//����һ�����id��ѯ����һ���������Ķ�Ӧ�Ķ������
		category = cs.findByFid(fid);
		System.out.println(category);

		//����һ���������id��ѯͼ��
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

	//��װ��ѯͼ����ϸ��Ϣ����
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
	//����ͼ��id��ѯͼ����Ϣ
	public String selectOneB(){
		BookService bs = new BookServiceImpl();
		book = bs.findOneB(id);
		
		//����ͼ��cate_id��ѯ�������
		
		CategoryService cs = new CategoryServiceImpl();
		category = cs.findCate(id);
		
		return "selectOneB";
	}
	
}
