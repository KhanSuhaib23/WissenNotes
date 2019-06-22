package com.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.db.SQLConnectionFactory;
import com.model.Product;
import com.model.ProductType;

public class JDBCProductRepository implements ProductRepository {

	public void save(Product product) {

		Connection connection = null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "insert into product(id, name,price,type) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getType().name());

			int count = ps.executeUpdate();
			if (count == 1)
				System.out.println("New record inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public void deleteById(int id) {
		Connection connection = null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "delete from product where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			

			int count = ps.executeUpdate();
			if (count == 1)
				System.out.println("Record deleted");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Product getById(int id) {
		Connection connection = null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "select * from product where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			

			ResultSet rs = ps.executeQuery();
			
			Product pro = null;
			
			if (rs.next()) {
				pro = new Product(0, null, 0, null);
				pro.setId(id);
				pro.setName(rs.getString(2));
				pro.setPrice(rs.getDouble(3));
				pro.setType(ProductType.valueOf(rs.getString(4)));
			}
			
			return pro;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}


	@Override
	public List<Product> getAll() {
		
		try {
			
			List<Product> products = new ArrayList<Product>();
			
			Connection connection = SQLConnectionFactory.getConnection();
			
			PreparedStatement ps = connection.prepareStatement("select * from product");
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				String typeString = rs.getString(4);
				
				ProductType type = ProductType.valueOf(typeString);
				
				products.add(new Product(id, name, price, type));
				
			}
		
			
			
			return products;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}
}
