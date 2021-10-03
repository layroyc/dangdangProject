package com.hp.serviceImpl;

import java.util.List;
import java.util.UUID;

import com.hp.dao.CategoryDao;
import com.hp.entity.Book;
import com.hp.entity.Category;
import com.hp.service.CategoryService;
import com.hp.util.MybatisUtil;



public class CategoryServiceImpl implements CategoryService{
	//���
	//��ѯ�������
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
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
	//��ѯ����һ�������
	public List<Category> findOneCg() {
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			List<Category> categorys = dao.queryOneCg();
			return categorys;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
	//���һ�����������
	public void insert(Category category) {
		// TODO Auto-generated method stub
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
		    String parent_id=category.getParent_id();
		    //�жϱ����ݵĶ����Ƿ���һ�����id
		    if(parent_id==null){
		    	//��ӵ���һ�����
		    	category.setLevels(1);
		    	category.setParent_id("null");
		    	MybatisUtil.commit();
		    }else{
		    	//��Ӷ������
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
			throw new RuntimeException("���ʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
	//ɾ�����
	public void removeCg(String id) {
		// TODO Auto-generated method stub
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			Category category = dao.selectById(id);
		    Integer levels=category.getLevels(); //��ȡ�ȼ�
		    if(levels==1){//�������һ������ж������Ƿ��ж������
		    	List<Category> categorys = dao.queryTwoCg(category.getId()); //�õ���һ������µĶ������
		    	if(categorys.size()==0){
		    		dao.deleteCg(category.getId()); //����Ϊ����û�ж������ֱ��ɾ��
		    		System.out.println("ɾ���ɹ�");
		    	}else{
		    		//�ж�������׳���ʾ��Ϣ�޷�ɾ��
		    		System.out.println("�޷�ɾ���������ж������");
		    	}
		    }else{
		    	//�����Ϊ�������� || �ж������Ƿ���ͼ��
		    	List<Book> books = dao.selectByCid(id); //���ݶ������id��ѯ��ͼ��
		    	for(Book b:books){
		    		System.out.println("������������ͼ��"+b);
		    	}
		    	if(books.size()==0){//ͼ�鼯�ϳ���Ϊ0��˵������û��ͼ�飬��ֱ��ɾ��
		    		dao.deleteCg(id);
		    		System.out.println("ɾ���ɹ�");
		    	}else{
		    		System.out.println("�޷�ɾ��������ͼ��");
		    	}
		    }
		    MybatisUtil.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("ɾ��ʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
	//��ѯ���ж������
	public List<Category> findTwoCg() {
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			List<Category> categorys = dao.queryTwoCgs();
			return categorys;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
	
	//ǰ��
	//��ѯ�������
	public List<Category> findAllC() {
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			List<Category> categorys = dao.queryAllC();
			return categorys;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
	
	//����һ�����id��ѯ����һ����������Ӧ�Ķ���id
	public Category findByFid(String fid){
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			Category category = dao.queryByFid(fid);
			return category;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
	//����ͼ��cate_id����ͼ���������
	public Category findCate(String id){
		try {
			CategoryDao dao = (CategoryDao) MybatisUtil.getMapper(CategoryDao.class);
			Category category = dao.queryCate(id);
			return category;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
}
