package com.baizhi.xzy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.xzy.entity.Book;
import com.baizhi.xzy.entity.Category;

public interface BookDao {
	//���
	//��ѯ����ͼ��
	List<Book> selectAll();
	//���ͼ��
	void addBook(Book book);
	//ģ����ѯ �������� ���� ������
	List<Book> selectLikeB(
			@Param(value="select")String select,
			@Param(value="name")String name);
	//ɾ��ͼ��
	void deleteB(String id);
	//�޸�ͼ����Ϣ
	void updateB(Book book);
	//����id��ѯͼ��
	Book findbyId(String id);
	
	//ǰ��
	//��ѯ����ͼ�� ||���չʾ����
	List<Book> selectAllB();
	//��ѯͼ�� || ����ʱ������
	List<Book> selectByT();
	//��ѯͼ�� || ������������
	List<Book> selectByX();
	//��ѯͼ�� || ����ʱ����������
	List<Book> selectByTX();
	//����һ���������id��ѯͼ�� ||��ҳ
	List<Book> selectByOT(
			@Param(value="fid")String fid,
			@Param(value="sid")String sid,
			@Param(value="begin")Integer begin,
			@Param(value="end")Integer end);
	//��������ѯͼ�������
	Integer selectByBCount(
			@Param(value="fid")String fid,
			@Param(value="sid")String sid);
	//����ͼ��id��ѯͼ�����ϸ��Ϣ
	Book selectOneB(String id);
	
}
