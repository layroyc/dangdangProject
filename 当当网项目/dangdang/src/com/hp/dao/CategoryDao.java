package com.hp.dao;

import java.util.List;

import com.hp.entity.Book;
import com.hp.entity.Category;



/*
 * �������m_category
 */
public interface CategoryDao {
	//���ʵ��
	//��ѯ������� || ���������չʾ�������
	List<Category> queryAll();
	//��ѯ����һ����� || ��Ӷ������ʱ��Ҫչʾ����һ�����
	List<Category> queryOneCg();
	//������
	void add(Category category);
	//ɾ�����
	void deleteCg(String id);
	//����һ�����Id�����Ƿ��ж������ ||ɾ��һ�����ʱ���ж������Ƿ��ж������
	List<Category> queryTwoCg(String id);
	//����id������� ||ɾ�����ʱ��Ҫͨ��id��ȡ����𣨶���
	Category selectById(String id);
	//�������id��ѯͼ�� ||ɾ���������ʱ�ж������Ƿ���ͼ��
	List<Book> selectByCid(String cid);
	//��ѯ���ж������ ||���ͼ��ʱ��չʾ���ж������
	List<Category> queryTwoCgs();

	//ǰ��ʵ��
	//��ѯ���ж������||���������Ӧ��һ�����
	List<Category> queryAllC();
	//����һ�����id��ѯ����һ�������������ж������
	Category queryByFid(String fid);
	//����ͼ��cate_id����ͼ���������
	Category queryCate(String id);
}
