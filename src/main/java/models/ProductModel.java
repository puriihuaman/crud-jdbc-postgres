package models;

import controllers.DatabaseConnection;

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
		int rs = 0;
		String
			query
			= "UPDATE product SET product_name = ?, price = ?, stock = ? WHERE product_id = CAST(? AS UUID)";

		try (Connection conn = DatabaseConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, _product.getProductName());
			ps.setDouble(2, _product.getPrice());
			ps.setShort(3, _product.getStock());
			ps.setString(4, _product.getProductId().toString());
			rs = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return rs;
	}

	public int deleteProduct(UUID _productId) {
		int rs = 0;
		String query = "DELETE FROM product WHERE product_id = CAST(? AS UUID)";

		try (Connection conn = DatabaseConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, _productId.toString());
			rs = ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return rs;
	}

	public ResultSet getProduct(UUID _productId) {
		String
			query
			= "SELECT product_id, product_name, price, stock FROM get_product(?)";
		try (Connection conn = DatabaseConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, _productId.toString());
			RESULT_SET = ps.executeQuery();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return RESULT_SET;
	}

	public ResultSet searchProduct(String _productName) {
		String
			query
			= "SELECT product_id, product_name, price, stock FROM product WHERE LOWER(product_name) LIKE LOWER(?)";
		try (Connection conn = DatabaseConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + _productName + "%");
			RESULT_SET = ps.executeQuery();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return RESULT_SET;
	}

	public ResultSet getAllProducts() {
		String query = "SELECT product_id, product_name, price, stock FROM product";
		try (Connection conn = DatabaseConnection.getConnection()) {
			Statement stmt = conn.createStatement();

			RESULT_SET = stmt.executeQuery(query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return RESULT_SET;
	}

	private ResultSet RESULT_SET = null;
}
