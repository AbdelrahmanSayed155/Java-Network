package com.abdelrahman.product.controller;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.abdelrahman.product.Product;
import com.abdelrahman.product.service.ProductService;
//to change it name  in wsdl and portname and servicename @WebService(name="abdo" ,portName="",serviceName="",targetNamespace="")
//@SOAPBinding(style=Style.RPC)

public class ProductController implements ProductControllerInterface {

	ProductService  proService = new ProductService();
	
	public List<String> getProductCategories(){
		return proService.getProductCategories();
	}
	
	public List<String> getProduct(String catName){
		return proService.getProduct(catName);
	}
	//@WebMethod(exclude=true,operationName="chane name of method inwsdl" , action="description of method work")
	
	public boolean addProduct(String catName,String productName){
		return proService.addProduct(catName, productName);
	}
	
	public Product getProductDetail(String name){
		return proService.getProductDetail(name);
		
	}
	
}
