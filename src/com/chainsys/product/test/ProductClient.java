package com.chainsys.product.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;
import com.chainsys.product.service.ProductServiceImpl;

public class ProductClient {
	public static void main(String[] args) throws Exception{

		Set<Product> productSet;
		ProductService service = new ProductServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 2:
			System.out.println("Find the Product By Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				Product product = service.findById(id);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 3:
			System.out.println("Update the Product Name Based on the Id");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct = new Product(2, "Pencil", LocalDate.parse(date, dateFormat));
			try {
				service.update(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		case 4:
			System.out.println("Adding a Product");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product newProduct = new Product(4, "Pencil", LocalDate.parse(date, dateFormat));
			service.save(newProduct);
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 5:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				service.delete(id);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
		case 6:
			System.out.println("Find the Product By Name ");
			System.out.println("Enter the Product Name");
			String name=scanner.next();
			try {
				Product product = service.findByName(name);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
			//Update the Product Expiry Date Based on the Id 
//		case 7:
//			String date = scanner.next();
//
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//			Date date2=null;
//			try {
//			    //Parsing the String
//			    date2 = dateFormat.parse(date);
//			} catch (ParseException e) {
//			    // TODO Auto-generated catch block
//			    e.printStackTrace();
//			}
//			System.out.println(date2);
//			  System.out.println("Enter the Product Id");
//			  id = scanner.nextInt();
//			  System.out.println(date1);
////			Product updateProductExp = new Product(2, "Pencil", LocalDate.parse(date, dateFormat));
////			try {
////				service.update(updateProduct);
////				productSet = service.findAll();
////				System.out.println(productSet);
////			} catch (ProductNotFoundException e) {
////
////			}
//			break;	
			
		default:
			break;
		}
		scanner.close();
	}

}