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
		// 1.读取配置文件
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream("com/baizhi/xzy/conf/mybatis-config.xml");
			// 2.创建SqlSessionFactory
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
	// 创建线程绑定对象 ThreadLocal
	private static ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();

	// 创建SqlSession
	public static SqlSession openSession() {
		// 先从当前线程获取
		SqlSession sqlSession = tol.get();
		if (sqlSession == null) {
			// 创建SqlSession
			sqlSession = factory.openSession();
			// 同时存入当前线程
			tol.set(sqlSession);
		}
		return sqlSession;
	}

	// 获取Dao接口实现类的对象
	public  static <T>T getMapper(Class<T> c) {
		// 获取SqlSession
		SqlSession sqlSession = openSession();
		return sqlSession.getMapper(c);
	}

	// 提交事务
	public static void commit() {
		// 获取SqlSession
		SqlSession sqlSession = openSession();
		sqlSession.commit();
	}

	// 事务回滚
	public static void rollback() {
		// 获取SqlSession
		SqlSession sqlSession = openSession();
		sqlSession.rollback();
	}

	// 释放资源
	public static void close() {
		// 获取SqlSession
		SqlSession sqlSession = openSession();
		if (sqlSession != null) {
			sqlSession.close();
			tol.remove();//从当前线程移除
		}
	}

}
