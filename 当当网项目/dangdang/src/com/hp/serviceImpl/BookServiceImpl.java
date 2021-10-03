package com.hp.serviceImpl;

import java.util.List;

import com.hp.dao.BookDao;
import com.hp.entity.Book;
import com.hp.service.BookService;
import com.hp.util.MybatisUtil;



public class BookServiceImpl implements BookService{
	//��ѯ����ͼ����Ϣ
	public List<Book> findAll() {
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectAll();
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}

	//���ͼ��
	public void insertBook(Book book) {
		try {
			System.out.println(book);
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			dao.addBook(book);

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

	//ģ����ѯ �������� ���� ������
	public List<Book> findLikeB(String select, String name) {
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectLikeB(select,name);
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}

	//ɾ��ͼ��
	public void removeB(String id) {
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			dao.deleteB(id);
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

	//�޸�ͼ��
	public void changeB(Book book) {
		try{
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			//			book.setId(UUID.randomUUID().toString());
			//			book.setSales_volume(0);
			//			book.setCover("xxx.jpg");
			dao.updateB(book);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("�޸�ʧ�ܣ�~");
		}finally{
			MybatisUtil.close();
		}
	}

	//ͨ��id����ͼ��
	public Book selectB(String id) {
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			Book book = dao.findbyId(id);
			return book;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}


	//ǰ��
	//��ѯ����ͼ��||���չʾ����ͼ��
	public List<Book> findAllB() {
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectAllB();
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}

	//��ѯͼ�� ||����ͼ�鵹��
	public List<Book> findByT() {
		// TODO Auto-generated method stub
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectByT();
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}

	//��ѯͼ�� || ������������
	public List<Book> findByX() {
		// TODO Auto-generated method stub
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectByX();
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}

	//��ѯͼ�� || ����ʱ����������
	public List<Book> findByTX() {
		// TODO Auto-generated method stub
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectByTX();
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
	//����һ���������id��ѯͼ��
	public List<Book> findByOT(String fid,String sid,Integer currentPage,Integer pageSize){
		// TODO Auto-generated method stub
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			Integer begin=(currentPage-1)*pageSize+1;
			Integer end=currentPage*pageSize;
			List<Book> books = dao.selectByOT(fid, sid,begin,end);
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}

	//��������ѯͼ�������
	public Integer findByBCount(String fid,String sid,Integer pageSize){
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			Integer count = dao.selectByBCount(fid, sid);
			//����ͼ������������ҳ��
			Integer pageTotal=(count+pageSize-1)/pageSize;
			if(pageTotal==0){
				pageTotal=1;
			}
			return pageTotal;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}

	//����ͼ��id��ѯͼ�����ϸ��Ϣ
	public Book findOneB(String id){
		// TODO Auto-generated method stub
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			Book book = dao.selectOneB(id);
			return book;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}
}
