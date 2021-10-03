package com.baizhi.xzy.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.xzy.entity.Book;
import com.baizhi.xzy.entity.Category;
import com.baizhi.xzy.service.BookService;
import com.baizhi.xzy.service.CategoryService;
import com.baizhi.xzy.serviceImpl.BookServiceImpl;
import com.baizhi.xzy.serviceImpl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	// ��ѯ����ͼ��
	public String findAllB() {
		BookService bs = new BookServiceImpl();
		books = bs.findAll();
		return "findAllB";
	}

	// ���ͼ��
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	private File cover; // ͼƬ�ֶ��� ��̨���ʱ�ļ�
	private String coverFileName; // ͼƬ�ֶ��� ��̨���ʱ�ļ�

	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public String AddBook() {
		System.out.println("���ͼ��");
		BookService bs = new BookServiceImpl();
		// System.out.println(book.getPrint_time());
		book.setId(UUID.randomUUID().toString());
		book.setSales_volume(0);
		// book.setCover("xxx.jpg");

		System.out.println("======" + cover);
		// �������·����þݶ�·��
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/back/img");
		File file = new File(realPath);
		// �ж�����ļ����Ƿ����
		if (!file.exists()) {
			// ��������ļ���
			file.mkdir();
		}
		String newName = new Date().getTime() + coverFileName; // ��һ�������֣����ظ���ͼƬ������
		try {
			// �ļ��ϴ�
			FileUtils.copyFile(cover, new File(realPath, newName));
			book.setCover(newName);
			// ͼ�����
			bs.insertBook(book);
			return "findAllB";
		} catch (IOException e) {
			e.printStackTrace();

			return "saveError";
		}
	}

	// ģ����ѯ �������� ���� ������
	private String select; // ��ȡ����ѡ��
	private String name; // ��ȡinput���û���������
	private String book_name; // ��ȡ����ѡ��
	private String author; // ��ȡinput���û���������
	private String publish_company; // ��ȡ����ѡ��

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish_company() {
		return publish_company;
	}

	public void setPublish_company(String publish_company) {
		this.publish_company = publish_company;
	}

	public String selectLikeB() {
		System.out.println("111");
		BookService bs = new BookServiceImpl();
		books = bs.findLikeB(select, name);
		// System.out.println(books);
		return "findAllB";
	}

	// ɾ��ͼ��
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String deleteB() {
		BookService bs = new BookServiceImpl();
		bs.removeB(id);
		return "findAllB";
	}

	// �޸�ͼ��
	public String updateB() throws IOException {
		BookService bs = new BookServiceImpl();
		if (cover != null) {
			System.out.println("========UPDATE" + book);
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/back/img");
			File file = new File(realPath);
			String newName = new Date().getTime() + coverFileName;
			FileUtils.copyFile(cover, new File(realPath, newName));
			book.setCover(newName);
		}
		bs.changeB(book);
		return "findAllB";
	}

	// ����id����ͼ��
	private List<Category> categorys;

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public String findbyId() {
		BookService bs = new BookServiceImpl();
		book = bs.selectB(id);
		System.out.println(book);
		// ��ѯ��һ�����ͬʱ��ѯ���ж������
		CategoryService cs = new CategoryServiceImpl();
		categorys = cs.findTwoCg();
		System.out.println("��ѯ���еĶ������");
		// for (Category c : categorys) {
		// System.out.println(c.getCategory());
		// }
		
		return "updateB";
	}
}
