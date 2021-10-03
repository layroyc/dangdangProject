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

	//��Ӷ���
	public void addO() {
		// TODO Auto-generated method stub
		try {
			OrderDao dao = (OrderDao) MybatisUtil.getMapper(OrderDao.class);
			Order order = new Order();
			String uuid =  UUID.randomUUID().toString();
			System.out.println("===service"+uuid);
			order.setId(uuid); //�������id
			
			
			SnowFlake idWorker = new SnowFlake();
			String id = idWorker.getId(); //ѩ���㷨���ɶ������
			order.setOrder_number(id);
			System.out.println("====service:id"+id);
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("order_number", id); //��������Ŵ���session
			
			order.setOrder_times(new Date());//����ʱ��
			
			
			Double  totalprice= (Double) session.getAttribute("totalprice");
			order.setTotal_price(totalprice); //��session��ȡ���ܼ�
			
			order.setStatus("δ֧��"); //��ǰ����״̬��Ϊδ֧��
			
			Address address = (Address) session.getAttribute("addressss");
			String name = address.getName();
			order.setName(name); //�ӵ�ַsessionȡ����ַ���󣬸�ֵ�ջ���
			
			String address2 = address.getAddress();
			order.setAddress(address2); //��ֵ��ַ
			
			String addrid = address.getId();
			order.setAddr_id(addrid);//��ֵ��ַid
			
			User user = (User) session.getAttribute("user");
			String uid = user.getId();
			order.setUser_id(uid);//ȡ��user���󣬸�ֵ�û�id
			
			System.out.println("====service===="+order);
			dao.insertO(order);//��Ӷ���
			session.setAttribute("order", order);
			MybatisUtil.commit();
			
			//��Ӷ�����
			Map<String, ShopCar> map=(Map<String, ShopCar>) session.getAttribute("map");
			//�������ﳵ�õ���Ʒ
			Set<String> keys = map.keySet();
//			System.err.println(map.size());
			for (String key : keys) {
				ShopCar shopcar = map.get(key);
				
				Item item = new Item();
				String uuid2 =  UUID.randomUUID().toString();
				item.setId(uuid2); //��������id
				String book_name = shopcar.getBook_name();
				item.setBook_name(book_name);//��ֵ��Ʒ��
				
				Double discount_price = shopcar.getDiscount_price();
				item.setDiscount_price(discount_price);//��ֵ��Ʒ�۸�
				
				Integer count = shopcar.getCount();
				item.setCount(count);//��ֵ��Ʒ����
				
				Double priceTotal = shopcar.getPriceTotal();
				item.setPriceTotal(priceTotal);//��ֵ��ƷС��
				
				BookService bs = new BookServiceImpl();
				Book book = bs.findOneB(key); //������ļ�Ϊbook��id
				System.out.println("service:book:"+book);
				String bid = book.getId();
				item.setBook_id(bid);//��ֵͼ��id
				
				Integer sales_volume = book.getSales_volume(); //ԭ������
				book.setSales_volume(sales_volume+count);
				bs.changeB(book);
				
				item.setOrder_id(uuid);//��ֵ������id
				
				String cover = book.getCover();
				item.setCover(cover); //��ֵ����
				
				Double original_price = book.getOriginal_price();
				item.setOriginal_price(original_price);//��ֵԭ��
				
				
				item.setStatus("δ֧��"); //��ֵ״̬
				
				
				item.setPriceTotal(count*discount_price);
				
				ItemService is = new ItemServiceImpl();
				System.out.println("service==item:"+item);
				is.addI(item);
			}
			
			session.removeAttribute("map"); //��չ��ﳵ
			
			MybatisUtil.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("���ʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}

	//��̨����ѯ���ж���
	public List<Order> queryAll() {
		try {
			OrderDao dao = (OrderDao) MybatisUtil.getMapper(OrderDao.class);
			List<Order> orders = dao.selectALLO();
			for(Order o:orders){
				System.out.println("==service��orders��"+o);
			}
			return orders;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
}
