package controllers;


import models.Product;
import models.ProductModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductController {
	public String createProduct(Product _product) {
		int response = productModel.createProduct(_product);

		return response == 1 ?
			"Producto creado exitosamente" :
			"Falló la creación del producto";
	}

	public String deleteProduct(UUID _productId) {
		int response = productModel.deleteProduct(_productId);
		return response == 1 ?
			"Producto eliminado exitosamente" :
			"Fallo la eliminación del producto";
	}

	public List<Product> searchProduct(String _productName) {
		List<Product> products = new ArrayList<>();
		try (ResultSet rs = productModel.searchProduct(_productName)) {
			while (rs.next()) {
				products.add(convert(rs));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return products;
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		try (ResultSet rs = productModel.getAllProducts()) {
			while (rs.next()) {
				products.add(convert(rs));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return products;
	}

	private Product convert(ResultSet _rs) {
		Product product = null;
		try {
			product = new Product(
				UUID.fromString(_rs.getString("product_id")),
				_rs.getString("product_name"),
				_rs.getDouble("price"),
				_rs.getShort("stock")
			);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}


		return product;
	}

	private final ProductModel productModel = new ProductModel();
}
