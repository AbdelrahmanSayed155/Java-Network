package com.abdelrahman.product.service;

import java.util.ArrayList;
import java.util.List;

import com.abdelrahman.product.Product;

public class ProductService {
	
	
	private  List<String> books = new ArrayList<String>();
	private  List<String> movies = new ArrayList<String>();
	private  List<String> series = new ArrayList<String>();
	private  List<String> doors = new ArrayList<String>();
    private  List<Product>productDetail = new ArrayList<Product>();
	
	public ProductService(){
		books.add("Ali Co");
		books.add("Fighter Man");
		books.add("Player Man");
		books.add("Oracle Man");
		books.add("Samy OIL");
		
		movies.add("Movie 1");
		movies.add("Movie 2");
		movies.add("Movie 3");
		movies.add("Movie 4");
		movies.add("Movie 5");
		
		series.add("Series 1");
		series.add("Series 2");
		series.add("Series 3");
		series.add("Series 4");
		
		doors.add("door 1");
		doors.add("door 2");
		doors.add("door 3");
		doors.add("door 4");
		doors.add("door 5");
		
		productDetail.add(new Product(10, "DVD", "gom"));
		productDetail.add(new Product(11, "DVD1", "com"));
		productDetail.add(new Product(12, "DVD2", "gomjhjh"));
		productDetail.add(new Product(13, "DVD3", "gom"));
		productDetail.add(new Product(14, "DVD4", "gom"));
		productDetail.add(new Product(15, "DVD5", "gom"));
	}
	
	public List<String> getProductCategories(){
		List<String> ca = new ArrayList<String>();
		ca.add("Books");
		ca.add("Movies");
		ca.add("Series");
		ca.add("Progarms");
		ca.add("Doors");
		return ca;
	}
	
	public  List<String>  getProduct(String categoryName){
		if(categoryName.equalsIgnoreCase("books")){
			return books;
		}else if(categoryName.equalsIgnoreCase("movies")){
			return movies;
		}else if(categoryName.equalsIgnoreCase("series")){
			return series;
		}else if(categoryName.equalsIgnoreCase("doors")){
			return doors;
		}else{
			return null;
		}
	}
	
	public boolean addProduct(String categoryName,String productName){
		if(categoryName !=null&&!categoryName.trim().isEmpty()&&productName !=null&&!productName.trim().isEmpty()){
			if(categoryName.equalsIgnoreCase("books")){
				books.add(productName);
				return true;
			}else if(categoryName.equalsIgnoreCase("movies")){
				movies.add(productName);
				return true;
			}else if(categoryName.equalsIgnoreCase("series")){
				series.add(productName);
				return true;
			}else if(categoryName.equalsIgnoreCase("doors")){
				doors.add(productName);
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	
	public Product getProductDetail(String name){
		return null;
	}

}
