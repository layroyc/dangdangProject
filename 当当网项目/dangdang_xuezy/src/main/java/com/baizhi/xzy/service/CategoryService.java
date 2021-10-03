package com.baizhi.xzy.service;

import java.util.List;

import com.baizhi.xzy.entity.Category;

public interface CategoryService {
	//���
	//��ѯ�������
	List<Category> findAll();
	//��ѯ����һ�������
	List<Category> findOneCg();
	//������
	void insert(Category category);
	//ɾ�����
	void removeCg(String id);
	//��ѯ���ж������
	List<Category> findTwoCg();

	//ǰ��
	//��ѯ�������
	List<Category> findAllC();
	//����һ�����id��ѯ����һ����������Ӧ�Ķ���id
	Category findByFid(String fid);
	//����ͼ��cate_id����ͼ���������
	Category findCate(String id);
}
