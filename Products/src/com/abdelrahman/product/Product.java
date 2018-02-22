package com.abdelrahman.product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="MyProduct")
@XmlType(propOrder={"id","address","name","email",})
public class Product {
	
	private int id;
	private String name;
	private String address;
	private String email;
	
	/// for using jaxB you must have Ctructor hasn't any args
	public Product(){
	}
	public Product(int id,String name,String address){
		this.id=id;
		this.name=name;
		this.address = address;
	}
    @XmlElement(name="sequince")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
