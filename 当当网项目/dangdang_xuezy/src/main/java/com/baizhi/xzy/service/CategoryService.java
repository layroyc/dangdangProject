package com.baizhi.xzy.service;

import java.util.List;

import com.baizhi.xzy.entity.Category;

public interface CategoryService {
	//后端
	//查询所有类别
	List<Category> findAll();
	//查询所有一级类别名
	List<Category> findOneCg();
	//添加类别
	void insert(Category category);
	//删除类别
	void removeCg(String id);
	//查询所有二级类别
	List<Category> findTwoCg();

	//前端
	//查询所有类别
	List<Category> findAllC();
	//根据一级类别id查询所有一级类别及下面对应的二级id
	Category findByFid(String fid);
	//根据图书cate_id查找图书所属类别
	Category findCate(String id);
}
