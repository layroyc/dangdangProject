package com.baizhi.xzy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.xzy.entity.Book;

public interface BookService {
	//后端
	//查询所有图书
	List<Book> findAll();
	//添加图书
	void insertBook(Book book);
	//模糊查询 根据书名 作者 出版社
	List<Book> findLikeB(String select,String name);
	//删除图书
	void removeB(String id);
	//修改图书
	void changeB(Book book);
	//根据id查找图书
	Book selectB(String id);

	//前端
	//查询所有图书 ||随机展示两本
	List<Book> findAllB();
	//查询图书 || 根据时间倒序
	List<Book> findByT();
	//查询图书 || 根据销量倒序
	List<Book> findByX();
	//查询图书 || 根据时间销量倒序
	List<Book> findByTX();
	//根据一级二级类别id查询图书
	List<Book> findByOT(String fid,String sid,
			Integer currentPage,Integer pageSize);
	//根据类别查询图书的数量
	Integer findByBCount(String fid,String sid,
							Integer pageSize);
	//根据图书id查询图书的详细信息
	Book findOneB(String id);
}
