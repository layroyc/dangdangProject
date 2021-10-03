package com.baizhi.xzy.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.xzy.dao.BookDao;
import com.baizhi.xzy.dao.OrderDao;
import com.baizhi.xzy.entity.Address;
import com.baizhi.xzy.entity.Book;
import com.baizhi.xzy.entity.Item;
import com.baizhi.xzy.entity.Order;
import com.baizhi.xzy.entity.ShopCar;
import com.baizhi.xzy.entity.User;
import com.baizhi.xzy.service.BookService;
import com.baizhi.xzy.service.ItemService;
import com.baizhi.xzy.service.OrderService;
import com.baizhi.xzy.util.MybatisUtil;
import com.baizhi.xzy.util.SnowFlake;

public class OrderServiceImpl implements OrderService{

	//添加订单
	public void addO() {
		// TODO Auto-generated method stub
		try {
			OrderDao dao = (OrderDao) MybatisUtil.getMapper(OrderDao.class);
			Order order = new Order();
			String uuid =  UUID.randomUUID().toString();
			System.out.println("===service"+uuid);
			order.setId(uuid); //订单表的id
			
			
			SnowFlake idWorker = new SnowFlake();
			String id = idWorker.getId(); //雪花算法生成订单编号
			order.setOrder_number(id);
			System.out.println("====service:id"+id);
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("order_number", id); //将订单编号存入session
			
			order.setOrder_times(new Date());//订单时间
			
			
			Double  totalprice= (Double) session.getAttribute("totalprice");
			order.setTotal_price(totalprice); //从session中取出总价
			
			order.setStatus("未支付"); //当前订单状态均为未支付
			
			Address address = (Address) session.getAttribute("addressss");
			String name = address.getName();
			order.setName(name); //从地址session取出地址对象，赋值收货人
			
			String address2 = address.getAddress();
			order.setAddress(address2); //赋值地址
			
			String addrid = address.getId();
			order.setAddr_id(addrid);//赋值地址id
			
			User user = (User) session.getAttribute("user");
			String uid = user.getId();
			order.setUser_id(uid);//取出user对象，赋值用户id
			
			System.out.println("====service===="+order);
			dao.insertO(order);//添加订单
			session.setAttribute("order", order);
			MybatisUtil.commit();
			
			//添加订单项
			Map<String, ShopCar> map=(Map<String, ShopCar>) session.getAttribute("map");
			//遍历购物车拿到商品
			Set<String> keys = map.keySet();
//			System.err.println(map.size());
			for (String key : keys) {
				ShopCar shopcar = map.get(key);
				
				Item item = new Item();
				String uuid2 =  UUID.randomUUID().toString();
				item.setId(uuid2); //订单项表的id
				String book_name = shopcar.getBook_name();
				item.setBook_name(book_name);//赋值商品名
				
				Double discount_price = shopcar.getDiscount_price();
				item.setDiscount_price(discount_price);//赋值商品价格
				
				Integer count = shopcar.getCount();
				item.setCount(count);//赋值商品数量
				
				Double priceTotal = shopcar.getPriceTotal();
				item.setPriceTotal(priceTotal);//赋值商品小计
				
				BookService bs = new BookServiceImpl();
				Book book = bs.findOneB(key); //购物项的键为book的id
				System.out.println("service:book:"+book);
				String bid = book.getId();
				item.setBook_id(bid);//赋值图书id
				
				Integer sales_volume = book.getSales_volume(); //原有销量
				book.setSales_volume(sales_volume+count);
				bs.changeB(book);
				
				item.setOrder_id(uuid);//赋值订单表id
				
				String cover = book.getCover();
				item.setCover(cover); //赋值封面
				
				Double original_price = book.getOriginal_price();
				item.setOriginal_price(original_price);//赋值原价
				
				
				item.setStatus("未支付"); //赋值状态
				
				
				item.setPriceTotal(count*discount_price);
				
				ItemService is = new ItemServiceImpl();
				System.out.println("service==item:"+item);
				is.addI(item);
			}
			
			session.removeAttribute("map"); //清空购物车
			
			MybatisUtil.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("添加失败~");
		} finally {
			MybatisUtil.close();
		}
	}

	//后台：查询所有订单
	public List<Order> queryAll() {
		try {
			OrderDao dao = (OrderDao) MybatisUtil.getMapper(OrderDao.class);
			List<Order> orders = dao.selectALLO();
			for(Order o:orders){
				System.out.println("==service：orders："+o);
			}
			return orders;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}
}
