package com.hp.dao;

import java.util.List;

import com.hp.entity.Book;
import com.hp.entity.Category;



/*
 * 类别管理表m_category
 */
public interface CategoryDao {
	//后端实现
	//查询所有类别 || 点击类别管理展示所有类别
	List<Category> queryAll();
	//查询所有一级类别 || 添加二级类别时需要展示所有一级类别
	List<Category> queryOneCg();
	//添加类别
	void add(Category category);
	//删除类别
	void deleteCg(String id);
	//根据一级类别Id查找是否有二级类别 ||删除一级类别时需判断下面是否有二级类别
	List<Category> queryTwoCg(String id);
	//根据id查找类别 ||删除类别时需要通过id获取到类别（对象）
	Category selectById(String id);
	//根据类别id查询图书 ||删除二级类别时判断下面是否有图书
	List<Book> selectByCid(String cid);
	//查询所有二级类别 ||添加图书时需展示所有二级类别
	List<Category> queryTwoCgs();

	//前端实现
	//查询所有二级类别||里面包含对应的一级类别
	List<Category> queryAllC();
	//根据一级类别id查询所有一级类别及下面的所有二级类别
	Category queryByFid(String fid);
	//根据图书cate_id查找图书所属类别
	Category queryCate(String id);
}
