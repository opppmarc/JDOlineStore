package com.aaa.vo;

public class Product {
private Integer pid;
private Integer cid;
private String name;
private Integer price;
private String pdesc;
private Integer stock;
private String img;
public Product() {
}


public Product(Integer cid, String name, Integer price, String pdesc,
		Integer stock, String img) {
	super();
	this.cid = cid;
	this.name = name;
	this.price = price;
	this.pdesc = pdesc;
	this.stock = stock;
	this.img = img;
}


public Product(Integer pid, Integer cid, String name, Integer price,
		String pdesc, Integer stock, String img) {
	super();
	this.pid = pid;
	this.cid = cid;
	this.name = name;
	this.price = price;
	this.pdesc = pdesc;
	this.stock = stock;
	this.img = img;
}


public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public Integer getStock() {
	return stock;
}
public void setStock(Integer stock) {
	this.stock = stock;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}

public String getPdesc() {
	return pdesc;
}

public void setPdesc(String pdesc) {
	this.pdesc = pdesc;
}

}
