package com.hp.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hp.entity.Book;
import com.hp.entity.ShopCar;
import com.hp.service.BookService;
import com.hp.serviceImpl.BookServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ShopAction extends ActionSupport {
	private String id; // ����ͼ��id
	private Book book; // ��װͼ�����

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	// ���ﳵ�����Ʒ
	public String add() {
		// ����ͼ��id��ѯͼ����ϸ��Ϣ
		System.out.println("======id" + id);
		BookService bs = new BookServiceImpl();
		book = bs.findOneB(id);
		System.out.println("====book" + book);
		// ��ȡ���ﳵ
		HttpServletRequest request = ServletActionContext.getRequest();// ��ȡrequest
		HttpSession session = request.getSession();// ��ȡsession
		Map<String, ShopCar> map = (Map<String, ShopCar>) session.getAttribute("map");
		// �жϹ��ﳵ�Ƿ����
		if (map == null) {// ���ﳵΪ�գ�����һ��Map
//			System.out.println("���ﳵΪ��");
			map = new HashMap<String, ShopCar>();
			// ���ﳵ�������������
			ShopCar shopcar = new ShopCar(book.getBook_name(),
					book.getOriginal_price(), book.getDiscount_price(), 1, 1,
					book.getDiscount_price());
			map.put(id, shopcar);
			session.setAttribute("map", map);
			// ���ü���۸�ķ���
			countPrice(map);
		} else {// ���ﳵ��Ϊ��
//			System.out.println("���ﳵ��Ϊ��");
			ShopCar shopcar = map.get(id);
				// �ж���ӵ���Ʒ�Ƿ��Ѿ����ڹ��ﳵ
			if (shopcar!=null) { // ��ӵ�����ͬ����Ʒ
				// ������1������С��
				System.out.println("ͼ���Ѵ���");
				shopcar = map.get(book.getId());
				Integer newcount = shopcar.getCount() + 1; 
				System.out.println("newcount:"+newcount);
				shopcar.setCount(newcount);
				// ���ü���۸�ķ���
				countPrice(map);
				session.setAttribute("map", map);
			} else {// ��ӵ��ǲ�ͬ����Ʒ
					// ���ﳵ����������µ�һ������
				System.out.println("��ͼ��");
				ShopCar shopcar2 = new ShopCar(book.getBook_name(),
						book.getOriginal_price(), book.getDiscount_price(), 1,
						1, book.getDiscount_price());
				map.put(id, shopcar2);
				
				// ���ü���۸�ķ���
				countPrice(map);
				session.setAttribute("map", map);

			}
		}
		return "add";
	}

	private Integer count;// �����޸ĵ�����

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	// ���ﳵ�޸���Ʒ����
	public String update() {
		System.out.println("====��ȡid"+id);
		System.out.println("====��ȡ����"+count);
		HttpServletRequest request = ServletActionContext.getRequest();// ��ȡrequest
		HttpSession session = request.getSession();// ��ȡsession
		// ��session�л�ȡ���ﳵ
		Map<String, ShopCar> map = (Map<String, ShopCar>) session.getAttribute("map");
		//��ù�����
		ShopCar shopcar = map.get(id);
		shopcar.setCount(count);//�޸�����
		
		// ����С��
		Double discount_price = shopcar.getDiscount_price();//��ȡ������
		shopcar.setPriceTotal(count*discount_price);
		map.put(id, shopcar); //���빺�ﳵ
		session.setAttribute("map", map);
		// ���ü���۸�ķ���
		countPrice(map);
		return "update";
	}

	// ���ﳵɾ����Ʒ
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();// ��ȡrequest
		HttpSession session = request.getSession();// ��ȡsession
		// ��session�л�ȡ���ﳵ
		Map<String, ShopCar> map = (Map<String, ShopCar>) session.getAttribute("map");
		System.out.println("id:"+id);
		ShopCar shopcar = map.get(id);
		System.out.println("shopcar:"+shopcar);
		shopcar.setStutas(0);
		// ���ü���۸�ķ���
		countPrice(map);
		session.setAttribute("map", map);
		return "delete";
	}

	// ���ﳵ��Ʒ�ָ�
	public String recover() {
		HttpServletRequest request = ServletActionContext.getRequest();// ��ȡrequest
		HttpSession session = request.getSession();// ��ȡsession
		// ��session�л�ȡ���ﳵ
		Map<String, ShopCar> map = (Map<String, ShopCar>) session.getAttribute("map");
		ShopCar shopcar = map.get(id);
		shopcar.setStutas(1);
		// ���ü���۸�ķ���
		countPrice(map);
		return "recover";
	}

	// ���ü����ʡ���ܼ�
	public void countPrice(Map<String, ShopCar> map) {
		double saveprice = 0; // ��ʡ
		double totalprice = 0; // �ܼ�
		// ����map�����ʡ���ܼ�
		Set<String> keys = map.keySet();
		System.err.println(map.size());
		for (String key : keys) {
			ShopCar shopcar = map.get(key);
			if (shopcar.getStutas() == 1) {
				// ��ʡ (save)+=(�۸�-������)*����
				System.out.println("count��"+shopcar.getCount());
				saveprice += (shopcar.getOriginal_price() - shopcar
						.getDiscount_price()) * shopcar.getCount();
				// �ܼ�(total)+=������*����
				totalprice += shopcar.getDiscount_price() * shopcar.getCount();
			}
			HttpServletRequest request = ServletActionContext.getRequest();// ��ȡrequest
			HttpSession session = request.getSession();// ��ȡsession
			System.out.println(saveprice);
			System.out.println(totalprice);
			session.setAttribute("saveprice", saveprice);
			session.setAttribute("totalprice", totalprice);
		}
	}
}
