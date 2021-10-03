package com.baizhi.xzy.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.xzy.entity.Category;
import com.baizhi.xzy.service.CategoryService;
import com.baizhi.xzy.serviceImpl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport{
	//���
	private List<Category> categorys;

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	//��ѯ�������
	public String queryAll(){
		CategoryService cs = new CategoryServiceImpl();
		categorys = cs.findAll();
		//		for(Category c:categorys){
		//			System.out.println(c);
		//		}
		return "queryAll";
	}

	//��ѯ����һ�����
	public String queryOneCg(){
		CategoryService cs = new CategoryServiceImpl();
		categorys = cs.findOneCg();
		System.out.println(categorys);
		for(Category c:categorys){
			System.out.println(c);
		}
		return "queryOneCg";
	}

	private Category category;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	//������
	public String addcategory(){
		CategoryService cs = new CategoryServiceImpl();
		System.out.println("action"+category);
		cs.insert(category);
		return "addcategory";
	}

	//ɾ�����
	public String removeCg(){
		CategoryService cs = new CategoryServiceImpl();
		System.out.println(category.getId());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		cs.removeCg(category.getId());
		return "queryAll";
	}

	//��ѯ���ж������
	public String queryTwoCg(){
		CategoryService cs = new CategoryServiceImpl();
		categorys = cs.findTwoCg();
		System.out.println(categorys);
//		HttpSession session = ServletActionContext.getRequest().getSession();
//		session.setAttribute("categorys", categorys);
		return "queryTwoCg";
	}
	
	//��ѯ���ж������ ||���޸�ҳ��ʹ��
		public String queryTwoCg2(){
			CategoryService cs = new CategoryServiceImpl();
			categorys = cs.findTwoCg();
			System.out.println(categorys);
			return "queryTwoCg";
		}
		
	//ǰ��
		private List<Category> categories;
		public List<Category> getCategories() {
			return categories;
		}
		public void setCategories(List<Category> categories) {
			this.categories = categories;
		}
		//��ѯ�������
		public String FindAllC(){
			CategoryService cs = new CategoryServiceImpl();
			categories = cs.findAllC();
			return "FindAllC";
		}
		
}
