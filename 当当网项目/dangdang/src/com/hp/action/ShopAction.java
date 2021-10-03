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
	private String id; // 接收图书id
	private Book book; // 封装图书对象

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

	// 购物车添加商品
	public String add() {
		// 根据图书id查询图书详细信息
		System.out.println("======id" + id);
		BookService bs = new BookServiceImpl();
		book = bs.findOneB(id);
		System.out.println("====book" + book);
		// 获取购物车
		HttpServletRequest request = ServletActionContext.getRequest();// 获取request
		HttpSession session = request.getSession();// 获取session
		Map<String, ShopCar> map = (Map<String, ShopCar>) session.getAttribute("map");
		// 判断购物车是否存在
		if (map == null) {// 购物车为空，创建一个Map
//			System.out.println("购物车为空");
			map = new HashMap<String, ShopCar>();
			// 向购物车项里面插入数据
			ShopCar shopcar = new ShopCar(book.getBook_name(),
					book.getOriginal_price(), book.getDiscount_price(), 1, 1,
					book.getDiscount_price());
			map.put(id, shopcar);
			session.setAttribute("map", map);
			// 调用计算价格的方法
			countPrice(map);
		} else {// 购物车不为空
//			System.out.println("购物车不为空");
			ShopCar shopcar = map.get(id);
				// 判断添加的商品是否已经存在购物车
			if (shopcar!=null) { // 添加的是相同的商品
				// 数量加1，计算小计
				System.out.println("图书已存在");
				shopcar = map.get(book.getId());
				Integer newcount = shopcar.getCount() + 1; 
				System.out.println("newcount:"+newcount);
				shopcar.setCount(newcount);
				// 调用计算价格的方法
				countPrice(map);
				session.setAttribute("map", map);
			} else {// 添加的是不同的商品
					// 向购物车项里面插入新的一条数据
				System.out.println("新图书");
				ShopCar shopcar2 = new ShopCar(book.getBook_name(),
						book.getOriginal_price(), book.getDiscount_price(), 1,
						1, book.getDiscount_price());
				map.put(id, shopcar2);
				
				// 调用计算价格的方法
				countPrice(map);
				session.setAttribute("map", map);

			}
		}
		return "add";
	}

	private Integer count;// 接收修改的数量

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	// 购物车修改商品数量
	public String update() {
		System.out.println("====获取id"+id);
		System.out.println("====获取数量"+count);
		HttpServletRequest request = ServletActionContext.getRequest();// 获取request
		HttpSession session = request.getSession();// 获取session
		// 从session中获取购物车
		Map<String, ShopCar> map = (Map<String, ShopCar>) session.getAttribute("map");
		//获得购物项
		ShopCar shopcar = map.get(id);
		shopcar.setCount(count);//修改数量
		
		// 计算小计
		Double discount_price = shopcar.getDiscount_price();//获取当当价
		shopcar.setPriceTotal(count*discount_price);
		map.put(id, shopcar); //放入购物车
		session.setAttribute("map", map);
		// 调用计算价格的方法
		countPrice(map);
		return "update";
	}

	// 购物车删除商品
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();// 获取request
		HttpSession session = request.getSession();// 获取session
		// 从session中获取购物车
		Map<String, ShopCar> map = (Map<String, ShopCar>) session.getAttribute("map");
		System.out.println("id:"+id);
		ShopCar shopcar = map.get(id);
		System.out.println("shopcar:"+shopcar);
		shopcar.setStutas(0);
		// 调用计算价格的方法
		countPrice(map);
		session.setAttribute("map", map);
		return "delete";
	}

	// 购物车商品恢复
	public String recover() {
		HttpServletRequest request = ServletActionContext.getRequest();// 获取request
		HttpSession session = request.getSession();// 获取session
		// 从session中获取购物车
		Map<String, ShopCar> map = (Map<String, ShopCar>) session.getAttribute("map");
		ShopCar shopcar = map.get(id);
		shopcar.setStutas(1);
		// 调用计算价格的方法
		countPrice(map);
		return "recover";
	}

	// 调用计算节省、总价
	public void countPrice(Map<String, ShopCar> map) {
		double saveprice = 0; // 节省
		double totalprice = 0; // 总价
		// 遍历map计算节省，总价
		Set<String> keys = map.keySet();
		System.err.println(map.size());
		for (String key : keys) {
			ShopCar shopcar = map.get(key);
			if (shopcar.getStutas() == 1) {
				// 节省 (save)+=(价格-当当价)*数量
				System.out.println("count："+shopcar.getCount());
				saveprice += (shopcar.getOriginal_price() - shopcar
						.getDiscount_price()) * shopcar.getCount();
				// 总价(total)+=当当价*数量
				totalprice += shopcar.getDiscount_price() * shopcar.getCount();
			}
			HttpServletRequest request = ServletActionContext.getRequest();// 获取request
			HttpSession session = request.getSession();// 获取session
			System.out.println(saveprice);
			System.out.println(totalprice);
			session.setAttribute("saveprice", saveprice);
			session.setAttribute("totalprice", totalprice);
		}
	}
}
