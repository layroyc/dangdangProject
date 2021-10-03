package com.baizhi.xzy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.xzy.entity.Book;
import com.baizhi.xzy.entity.Category;

public interface BookDao {
	//后端
	//查询所有图书
	List<Book> selectAll();
	//添加图书
	void addBook(Book book);
	//模糊查询 根据书名 作者 出版社
	List<Book> selectLikeB(
			@Param(value="select")String select,
			@Param(value="name")String name);
	//删除图书
	void deleteB(String id);
	//修改图书信息
	void updateB(Book book);
	//根据id查询图书
	Book findbyId(String id);
	
	//前端
	//查询所有图书 ||随机展示两本
	List<Book> selectAllB();
	//查询图书 || 根据时间排序
	List<Book> selectByT();
	//查询图书 || 根据销量排序
	List<Book> selectByX();
	//查询图书 || 根据时间销量排序
	List<Book> selectByTX();
	//根据一级二级类别id查询图书 ||分页
	List<Book> selectByOT(
			@Param(value="fid")String fid,
			@Param(value="sid")String sid,
			@Param(value="begin")Integer begin,
			@Param(value="end")Integer end);
	//根据类别查询图书的数量
	Integer selectByBCount(
			@Param(value="fid")String fid,
			@Param(value="sid")String sid);
	//根据图书id查询图书的详细信息
	Book selectOneB(String id);
	
}
