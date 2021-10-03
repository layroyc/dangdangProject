package com.hp.serviceImpl;

import java.util.List;

import com.hp.dao.BookDao;
import com.hp.entity.Book;
import com.hp.service.BookService;
import com.hp.util.MybatisUtil;



public class BookServiceImpl implements BookService{
	//查询所有图书信息
	public List<Book> findAll() {
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectAll();
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}

	//添加图书
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
			throw new RuntimeException("添加失败~");
		} finally {
			MybatisUtil.close();
		}

	}

	//模糊查询 根据书名 作者 出版社
	public List<Book> findLikeB(String select, String name) {
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectLikeB(select,name);
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}

	//删除图书
	public void removeB(String id) {
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			dao.deleteB(id);
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

	//修改图书
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
			throw new RuntimeException("修改失败！~");
		}finally{
			MybatisUtil.close();
		}
	}

	//通过id查找图书
	public Book selectB(String id) {
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			Book book = dao.findbyId(id);
			return book;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}


	//前端
	//查询所有图书||随机展示两本图书
	public List<Book> findAllB() {
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectAllB();
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}

	//查询图书 ||根据图书倒序
	public List<Book> findByT() {
		// TODO Auto-generated method stub
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectByT();
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}

	//查询图书 || 根据销量降序
	public List<Book> findByX() {
		// TODO Auto-generated method stub
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectByX();
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}

	//查询图书 || 根据时间销量降序
	public List<Book> findByTX() {
		// TODO Auto-generated method stub
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			List<Book> books = dao.selectByTX();
			return books;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}
	//根据一级二级类别id查询图书
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
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}

	//根据类别查询图书的数量
	public Integer findByBCount(String fid,String sid,Integer pageSize){
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			Integer count = dao.selectByBCount(fid, sid);
			//根据图书数量计算总页数
			Integer pageTotal=(count+pageSize-1)/pageSize;
			if(pageTotal==0){
				pageTotal=1;
			}
			return pageTotal;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}

	//根据图书id查询图书的详细信息
	public Book findOneB(String id){
		// TODO Auto-generated method stub
		try {
			BookDao dao = (BookDao) MybatisUtil.getMapper(BookDao.class);
			Book book = dao.selectOneB(id);
			return book;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}
}
