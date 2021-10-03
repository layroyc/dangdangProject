package com.baizhi.xzy.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.xzy.dao.ItemDao;
import com.baizhi.xzy.dao.OrderDao;
import com.baizhi.xzy.entity.Item;
import com.baizhi.xzy.entity.Order;
import com.baizhi.xzy.entity.ShopCar;
import com.baizhi.xzy.service.ItemService;
import com.baizhi.xzy.util.MybatisUtil;

public class ItemServiceImpl implements ItemService{

	//��ӹ�����
	public void addI(Item item) {
		// TODO Auto-generated method stub
		try {
			ItemDao dao = (ItemDao) MybatisUtil.getMapper(ItemDao.class);
			dao.insertI(item);
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

	////��̨�����ݶ���id��ѯÿһ��������||order_id
	public List<Item> queryAllI(String oid) {
		try {
			ItemDao dao = (ItemDao) MybatisUtil.getMapper(ItemDao.class);
			List<Item> items = dao.selectAllI(oid);
			for(Item i:items){
				System.out.println("==service��items��"+i);
			}
			return items;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
}
