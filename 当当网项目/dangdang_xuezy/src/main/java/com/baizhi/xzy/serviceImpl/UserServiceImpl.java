package com.baizhi.xzy.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.baizhi.xzy.dao.BookDao;
import com.baizhi.xzy.dao.UserDao;
import com.baizhi.xzy.entity.Book;
import com.baizhi.xzy.entity.User;
import com.baizhi.xzy.service.UserService;
import com.baizhi.xzy.util.Md5Utils;
import com.baizhi.xzy.util.MybatisUtil;

public class UserServiceImpl implements UserService{
	//��½
	public String login(String email,String password) {
		try {
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			User user = dao.findByE(email);
			String message;
			
			//�ж��û��Ƿ����
			if(user==null){
				message="�û�������";
			}else{
				//�ж�״̬
				if(user.getStatus().equals("����")){
					//�жϼ�����
					String code = user.getCDK();
					if(code==null){
						message="200";//�û�δ��֤����
					}else{
						String salt = user.getSalt(); //���ݿ�ȡ����
						String md5Code = Md5Utils.getMd5Code(password+salt); //�����������ٴμ��μ���
						String psd = user.getPassword();//ȡ�����ݿ�����
						//�ж�����
						if(md5Code.equals(psd)){
							message="100";//��½�ɹ�
							ServletActionContext.getRequest().getSession().setAttribute("user", user);
						}else{
							message="�������";
						}
					}
				}else{
					message="�û��Ѷ���";
				}
			}
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��¼ʧ��");
		}finally{
			MybatisUtil.close();
		}
	}

	//ע��
	public void regist(User user) {
		try {
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			String salt = Md5Utils.getSalt(6); //�����
			user.setSalt(salt); //������֮�������ݿ�
			String md5Code = Md5Utils.getMd5Code(user.getPassword()+salt); //���û�ע��������������
			user.setPassword(md5Code); //�Ѽ��ܺ��������ȥ����ԭ��������
			String uuid =  UUID.randomUUID().toString();
			user.setId(uuid);
			user.setStatus("����");
			user.setRegdate(new Date());
			System.out.println(user.getPassword());
			dao.regist(user);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("ע��ʧ��");
		} finally {
			MybatisUtil.close();
		}

	}

	//��̨����ѯ�����û�
	public List<User> queryAllU() {
		try {
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			List<User> users = dao.selectAllU();
			return users;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��~");
		} finally {
			MybatisUtil.close();
		}
	}

	//�޸�CDK
	public void changeCDK(String code,String id) {
		// TODO Auto-generated method stub
		try{
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			dao.updateCDK(code, id);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("�޸�ʧ�ܣ�~");
		}finally{
			MybatisUtil.close();
		}
	}

	//�޸�״̬
	public void changeS(String status, String id) {
		// TODO Auto-generated method stub
		try{
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			User user = dao.selectById(id);
			
			if(user.getStatus().equals("����")){
				status="����";
			}else{
				status="����";
			}
			dao.updateS(status, id);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("�޸�ʧ�ܣ�~");
		}finally{
			MybatisUtil.close();
		}
	}
}
