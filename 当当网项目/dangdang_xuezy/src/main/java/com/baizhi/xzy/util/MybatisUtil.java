package com.baizhi.xzy.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory = null;
	static {
		// 1.��ȡ�����ļ�
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream("com/baizhi/xzy/conf/mybatis-config.xml");
			// 2.����SqlSessionFactory
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	// �����̰߳󶨶��� ThreadLocal
	private static ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();

	// ����SqlSession
	public static SqlSession openSession() {
		// �ȴӵ�ǰ�̻߳�ȡ
		SqlSession sqlSession = tol.get();
		if (sqlSession == null) {
			// ����SqlSession
			sqlSession = factory.openSession();
			// ͬʱ���뵱ǰ�߳�
			tol.set(sqlSession);
		}
		return sqlSession;
	}

	// ��ȡDao�ӿ�ʵ����Ķ���
	public  static <T>T getMapper(Class<T> c) {
		// ��ȡSqlSession
		SqlSession sqlSession = openSession();
		return sqlSession.getMapper(c);
	}

	// �ύ����
	public static void commit() {
		// ��ȡSqlSession
		SqlSession sqlSession = openSession();
		sqlSession.commit();
	}

	// ����ع�
	public static void rollback() {
		// ��ȡSqlSession
		SqlSession sqlSession = openSession();
		sqlSession.rollback();
	}

	// �ͷ���Դ
	public static void close() {
		// ��ȡSqlSession
		SqlSession sqlSession = openSession();
		if (sqlSession != null) {
			sqlSession.close();
			tol.remove();//�ӵ�ǰ�߳��Ƴ�
		}
	}

}
