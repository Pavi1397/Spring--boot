package com.deloitte.deloittespringboot.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitialzer","handler"})

public class Product {
 @Id @GeneratedValue(strategy = GenerationType.AUTO)
 int pid;
 String pname;
 float price;
 LocalDate releasedDate;

 public Product() {

}

public Product(int pid, String pname, float price, LocalDate releasedDate) {

	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.releasedDate = releasedDate;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public LocalDate getReleasedDate() {
	return releasedDate;
}

public void setReleasedDate(LocalDate releasedDate) {
	this.releasedDate = releasedDate;
}

@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", releasedDate=" + releasedDate + "]";
}
 
}
