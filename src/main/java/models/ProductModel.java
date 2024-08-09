package models;

import controllers.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.UUID;

public class ProductModel {
	public int createProduct(Product _product) {
		int rs = 0;
		String
			query
			= "INSERT INTO product (product_name, price, stock) VALUES (?, ?, ?)";
		try (Connection conn = DatabaseConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, _product.getProductName());
			ps.setDouble(2, _product.getPrice());
			ps.setShort(3, _product.getStock());
			rs = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return rs;
	}

	public int updateProduct(Product _product) {
		Product product = getProduct(_product.getProductId());
		
		int rs = 0;

		try (Connection conn = DatabaseConnection.getConnection()) {
			if (product != null) {
				String
					query
					= "UPDATE product SET product_name = ?, price = ?, stock = ? WHERE product_id = CAST(? AS UUID)";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, _product.getProductName());
				ps.setDouble(2, _product.getPrice());
				ps.setShort(3, _product.getStock());
				ps.setString(4, _product.getProductId().toString());
				rs = ps.executeUpdate();
			} else {
				rs = 0;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return rs;
	}

	public int deleteProduct(UUID _productId) {
		Product product = getProduct(_productId);
		int response = 0;

		if (product != null) {
			String query = "DELETE FROM product WHERE product_id = CAST(? AS UUID)";
			try (Connection conn = DatabaseConnection.getConnection()) {
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, product.getProductId().toString());
				response = ps.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return response;
	}

	private static Product getProduct(UUID _productId) {
		Product product = null;
		String
			query
			= "SELECT product_id, product_name, price, stock FROM product WHERE product_id = CAST(? AS UUID)";
		try (Connection conn = DatabaseConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, _productId.toString());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product = new Product(
					UUID.fromString(rs.getString("product_id")),
					rs.getString("product_name"),
					rs.getDouble("price"),
					rs.getShort("stock")
				);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return product;
	}

	public ResultSet searchProduct(String _productName) {
		ResultSet rs = null;
		String
			query
			= "SELECT product_id, product_name, price, stock FROM product WHERE LOWER(product_name) LIKE LOWER(?)";
		try (Connection conn = DatabaseConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + _productName + "%");
			rs = ps.executeQuery();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return rs;
	}

	public ResultSet getAllProducts() {
		ResultSet rs = null;
		String query = "SELECT product_id, product_name, price, stock FROM product";
		try (Connection conn = DatabaseConnection.getConnection()) {
			Statement stmt = conn.createStatement();

			rs = stmt.executeQuery(query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return rs;
	}


}
