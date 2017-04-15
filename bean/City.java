package com.sangfei.bean;


public class City  {
	private static final long serialVersionUID = 1L;
	public City(){
		
	}
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public City(int id,String name){
		setId(id);
		setName(name);
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
