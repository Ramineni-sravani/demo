package com.jdbc.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Customer;

public class CustomerDao {
		private JdbcTemplate jdbcTemplate;
		
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate=jdbcTemplate;
		}
		public void insertData(Customer customer) {
			String query="insert into customer(customerName,mailId,cPoints) values(?,?,?)";
			jdbcTemplate.update(query,new Object[] {customer.getCustomerName(),customer.getEmail(),customer.getcPoints()}),
		public List<Customer> getAllCustomers() {
				String query="select * from customer";
				return jdbcTemplate.query(query, new CustomerMapper());
				}
			public static final class CustomerMapper implements RowMapper<Customer>
			{
				public Customer mapRow(ResultSet rs, int count) throws SQlException{
					return new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				}
			}
			public List<Customer> getAllCustomersById(int cid){
				String query="select*from customer where customerId=?";
				return jdbcTemplate.query(query,new Object[] {cid}, new CustomerMapper(), null);
			}
		}
		public List<Customer> getAllCustomers() {
			// TODO Auto-generated method stub
			return null;
		}
		public void updateData(Customer customer) {
			String query="update customer set customerName=?,mailId=? where customerId=?";
			jdbcTemplate.update(query,new Object[] {customer.getCustomerName(),customer.getEmail(),customer.getcPoints(),customer.getCustomerId()});
			
		}
		public List<Customer> getAllCustomersById(int cid4) {
			// TODO Auto-generated method stub
			return null;
		}
		public void deleteData(int cid5) {
			String query="delete from customer where customerId=?";
			jdbcTemplate.update(query,new Object[] {cid5});
			
			
		}

}
