package com.hp.serviceImpl;

import java.util.List;
import java.util.UUID;

import com.hp.dao.CategoryDao;
import com.hp.entity.Book;
import com.hp.entity.Category;
import com.hp.service.CategoryService;
import com.hp.util.MybatisUtil;



public class CategoryServiceImpl implements CategoryService{
	//后端
	//查询所有类别
	public List<Category> findAll() {
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			List<Category> categorys = dao.queryAll();
			for(Category c:categorys){
				System.out.println("====service===:"+c);
			}
			return categorys;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}
	//查询所有一级类别名
	public List<Category> findOneCg() {
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			List<Category> categorys = dao.queryOneCg();
			return categorys;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}
	//添加一级二级类别名
	public void insert(Category category) {
		// TODO Auto-generated method stub
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
		    String parent_id=category.getParent_id();
		    //判断表单传递的对象是否有一级类别id
		    if(parent_id==null){
		    	//添加的是一级类别
		    	category.setLevels(1);
		    	category.setParent_id("null");
		    	MybatisUtil.commit();
		    }else{
		    	//添加二级类别
		    	category.setLevels(2);
		    }
		   String uuid =  UUID.randomUUID().toString();
		   category.setId(uuid);
		   System.out.println("category:"+category);
		   dao.add(category);
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
	//删除类别
	public void removeCg(String id) {
		// TODO Auto-generated method stub
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			Category category = dao.selectById(id);
		    Integer levels=category.getLevels(); //获取等级
		    if(levels==1){//如果它是一级类别，判断下面是否有二级类别
		    	List<Category> categorys = dao.queryTwoCg(category.getId()); //拿到该一级类别下的二级类别
		    	if(categorys.size()==0){
		    		dao.deleteCg(category.getId()); //集合为空则没有二级类别，直接删除
		    		System.out.println("删除成功");
		    	}else{
		    		//有二级类别，抛出提示信息无法删除
		    		System.out.println("无法删除，下面有二级类别");
		    	}
		    }else{
		    	//该类别为二级标题 || 判断下面是否有图书
		    	List<Book> books = dao.selectByCid(id); //根据二级类别id查询到图书
		    	for(Book b:books){
		    		System.out.println("二级类别下面的图书"+b);
		    	}
		    	if(books.size()==0){//图书集合长度为0，说明下面没有图书，可直接删除
		    		dao.deleteCg(id);
		    		System.out.println("删除成功");
		    	}else{
		    		System.out.println("无法删除，含有图书");
		    	}
		    }
		    MybatisUtil.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("删除失败~");
		} finally {
			MybatisUtil.close();
		}
	}
	//查询所有二级类别
	public List<Category> findTwoCg() {
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			List<Category> categorys = dao.queryTwoCgs();
			return categorys;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}
	
	//前端
	//查询所有类别
	public List<Category> findAllC() {
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			List<Category> categorys = dao.queryAllC();
			return categorys;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}
	
	//根据一级类别id查询所有一级类别及下面对应的二级id
	public Category findByFid(String fid){
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			Category category = dao.queryByFid(fid);
			return category;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}
	//根据图书cate_id查找图书所属类别
	public Category findCate(String id){
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			Category category = dao.queryCate(id);
			return category;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}
}
