package com.hp.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{

	private String id;
	private String category; //类别名
	private Integer levels;
	private String parent_id;
	
	private Category categorys; //关系属性：一个二级类别对应一个一级类别
	private List<Category> cates; //关系属性：所有类别
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String id, String category, Integer levels,
			String parent_id) {
		super();
		this.id = id;
		this.category = category;
		this.levels = levels;
		this.parent_id = parent_id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + ", levels="
				+ levels + ", parent_id=" + parent_id + ", categorys="
				+ categorys + ", cates=" + cates + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public Category getCategorys() {
		return categorys;
	}
	public void setCategorys(Category categorys) {
		this.categorys = categorys;
	}
	public List<Category> getCates() {
		return cates;
	}
	public void setCates(List<Category> cates) {
		this.cates = cates;
	}

	
}
