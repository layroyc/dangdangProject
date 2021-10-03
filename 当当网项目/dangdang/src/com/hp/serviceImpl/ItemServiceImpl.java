package com.hp.serviceImpl;

import java.util.List;

import com.hp.dao.ItemDao;
import com.hp.entity.Item;
import com.hp.service.ItemService;
import com.hp.util.MybatisUtil;


public class ItemServiceImpl implements ItemService{

	//添加购物项
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
			throw new RuntimeException("添加失败~");
		} finally {
			MybatisUtil.close();
		}

	}

	////后台：根据订单id查询每一个购物项||order_id
	public List<Item> queryAllI(String oid) {
		try {
			ItemDao dao = (ItemDao) MybatisUtil.getMapper(ItemDao.class);
			List<Item> items = dao.selectAllI(oid);
			for(Item i:items){
				System.out.println("==service：items："+i);
			}
			return items;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}
}
