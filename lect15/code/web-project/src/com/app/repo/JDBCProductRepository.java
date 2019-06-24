package com.app.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.db.SQLConnectionFactory;
import com.app.model.Product;
import com.app.model.ProductType;

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
