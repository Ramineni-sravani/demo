package com.demo.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Customer;
import com.jdbc.dao.CustomerDao;



public class CustomerMain {
	public static void main(String[]args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring_bean.xml");
		CustomerDao dao=(CustomerDao) context.getBean("cdao");
		Customer customer=new Customer();
		Scanner s=new Scanner(System.in);
		
		do
		{
			System.out.println("Menu");
		System.out.println(" 1.Create Customer");
		System.out.println("2.Get Customer ");
		System.out.println("3.get Indivitual Customer ");
		System.out.println("4. Update Customer ");
		System.out.println("5.Delete Customer ");
		System.out.println("6.Exit ");
		System.out.println(" Enter your Option");
		switch (s.nextInt()) {
		case 1:
		System.out.println("Enter the customer Name: ");
		s.nextLine();
		customer.setCustomerName(s.nextLine());
		System.out.println("Enter the Mail Id:");
		customer.setEmail(s.nextLine());
		System.out.println("Enter the customer points:");
		customer.setEmail(s.nextLine());
		dao.insertData(customer);
		System.out.println("Data inserted Successfully");
		break;
		case 2:
		List<Customer> customers=dao.getAllCustomers();
		if(customers.size()==0)
		{
			System.out.println("No Customer Information");
		}
		else {
			System.out.printf("%-15s %-15s %-15s %s\n","Customer Id","Customer Name","Email","Points");
			for(Customer c:customers)
			{
				System.out.printf("%-15s %-15s %-15s %s\n",c.getCustomerId(),c.getCustomerName(),c.getEmail(),c.getcPoints());
			}
		}
		break;
		case 3:
		System.out.println("Which Customer Id you are going to get it:");
		int cid=s.nextInt();
		List<Customer> customers1=dao.getAllCustomersById(cid);
		if(customers1.size()==0)
		{
			System.out.println("No customer Information");
		}
		else 
		{
			System.out.printf("%-15s %-15s %-15s %s\n","Customer Id","Customer Name","Email","Points");
			for(Customer c:customers1)
			{
				System.out.printf("%-15s %-15s %-15s %s\n",c.getCustomerId(),c.getCustomerName(),c.getEmail(),c.getcPoints());
			}
		}
		break;
		case 4:
		System.out.println("which customer Id you are going to update is:");
		int cid4=s.nextInt();
		List<Customer> customers4=dao.getAllCustomersById(cid4);
		if(customers4.size()==0)
		{
			System.out.println("Id doesnot exist enter correct Id:");
		}
		else
		{
			customer.setCustomerId(cid4);
			System.out.println("Enter the customer Name: ");
			s.nextLine();
			customer.setCustomerName(s.nextLine());
			System.out.println("Enter the Mail Id:");
			customer.setEmail(s.nextLine());
			System.out.println("Enter the customer points:");
			customer.setEmail(s.nextLine());
			dao.updateData(customer);
			System.out.println("Data updated Successfully");	
		}
		break;
		case 5:
			System.out.println("which customer Id you are going to delete is:");
			int cid5=s.nextInt();
			List<Customer> customers5=dao.getAllCustomersById(cid5);
			if(customers5.size()==0)
			{
				System.out.println("Id doesnot exist enter correct Id:");
			}
			else
			{
				
				dao.deleteData(cid5);
				System.out.println("Data deleted Successfully");	
			}
		break;
		case 6:
		System.out.println(" Bye");
		System.exit(0);
		default:
		System.out.println(" Invalid Choice"); }


			
			
		}while(true);
	}

}
