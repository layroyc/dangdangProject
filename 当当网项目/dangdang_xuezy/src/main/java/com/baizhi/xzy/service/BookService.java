package com.baizhi.xzy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.xzy.entity.Book;

public interface BookService {
	//���
	//��ѯ����ͼ��
	List<Book> findAll();
	//���ͼ��
	void insertBook(Book book);
	//ģ����ѯ �������� ���� ������
	List<Book> findLikeB(String select,String name);
	//ɾ��ͼ��
	void removeB(String id);
	//�޸�ͼ��
	void changeB(Book book);
	//����id����ͼ��
	Book selectB(String id);

	//ǰ��
	//��ѯ����ͼ�� ||���չʾ����
	List<Book> findAllB();
	//��ѯͼ�� || ����ʱ�䵹��
	List<Book> findByT();
	//��ѯͼ�� || ������������
	List<Book> findByX();
	//��ѯͼ�� || ����ʱ����������
	List<Book> findByTX();
	//����һ���������id��ѯͼ��
	List<Book> findByOT(String fid,String sid,
			Integer currentPage,Integer pageSize);
	//��������ѯͼ�������
	Integer findByBCount(String fid,String sid,
							Integer pageSize);
	//����ͼ��id��ѯͼ�����ϸ��Ϣ
	Book findOneB(String id);
}
