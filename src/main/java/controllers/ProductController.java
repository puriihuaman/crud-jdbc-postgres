package controllers;

import models.Product;
import models.ProductModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductController {
	private Product getProduct(UUID _productId) {
		Product product = null;

		try (ResultSet rs = productModel.getProduct(_productId)) {
			if (rs.next()) {
				product = new Product(
					UUID.fromString(rs.getString("product_id")),
					rs.getString("product_name"),
					rs.getDouble("price"),
					rs.getShort("stock")
				);
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return product;
	}

	public String createProduct(Product _product) {
		int response = productModel.createProduct(_product);

		return response == 1 ?
			"Producto creado exitosamente" :
			"Falló la creación del producto";
	}

	public String updateProduct(Product _product) {
		Product product = getProduct(_product.getProductId());
		if (product == null) return "El producto no existe";

		try (ResultSet rs = productModel.updateProduct(product)) {
			if (rs.next()) {
				int rowsAffected = rs.getInt("rows_affected");
				return rowsAffected > 0 ?
					"Producto actualizado exitosamente" :
					"Falló la actualización del producto";

			} else {
				return "El producto no existe";
			}

		} catch (SQLException ex) {
			return "Ocurrió un error al eliminar el producto. Por favor, intenta de nuevo más tarde.";
		}
	}

	public String deleteProduct(UUID _productId) {
		Product product = getProduct(_productId);

		if (product == null) return "El producto no existe";
		int rowsAffected = productModel.deleteProduct(product.getProductId());

		return rowsAffected > 0 ?
			"El producto se eliminado exitosamente" :
			"Falló la eliminación del producto";
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
