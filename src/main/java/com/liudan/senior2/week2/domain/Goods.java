package com.liudan.senior2.week2.domain;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 	创建一个Goods类，并且实现序列化接口
 * @author 柳旦
 *
 */
public class Goods implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String name;
	private double price;//价格
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	private String baifenbi;//百分比
	//实现set/get方法
	public Integer getId() {
		return id;
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
	
	public String getBaifenbi() {
		return baifenbi;
	}
	public void setBaifenbi(String baifenbi) {
		this.baifenbi = baifenbi;
	}
	
	//重写toString方法
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", baifenbi=" + baifenbi + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
