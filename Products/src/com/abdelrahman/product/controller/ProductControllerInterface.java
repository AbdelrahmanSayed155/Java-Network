package com.abdelrahman.product.controller;

import java.util.List;

import javax.jws.WebMethod;

import com.abdelrahman.product.Product;

public interface ProductControllerInterface {
	
	@WebMethod
	public List<String> getProductCategories();
	@WebMethod
	public List<String> getProduct(String catName);
	//@WebMethod(exclude=true,operationName="chane name of method inwsdl" , action="description of method work")
	@WebMethod
	public boolean addProduct(String catName,String productName);

	@WebMethod
	public Product getProductDetail(String name);

	
}
