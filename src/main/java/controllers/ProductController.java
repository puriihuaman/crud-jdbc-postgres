package controllers;

import models.Product;
import models.ProductModel;
import models.ResponseType;

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

	public ResponseType createProduct(Product _product) {
		boolean isExist = isExistProduct(_product.getProductName());

		if (!isExist) {
			int response = productModel.createProduct(_product);
			return response == 0 ?
				ResponseType.error("Falló la creación del producto") :
				ResponseType.success("Producto creado exitosamente");
		}
		return ResponseType.error("El nombre del producto ya existe");
	}

	public ResponseType updateProduct(Product _product) {
		Product product = getProduct(_product.getProductId());
		if (product == null) ResponseType.error("El producto no existe");

		boolean isExist = isExistProduct(_product.getProductName());

		if (!isExist) {
			int rowsAffected = productModel.updateProduct(_product);

			return rowsAffected == 0 ?
				ResponseType.error("Falló la actualización del producto") :
				ResponseType.success("Producto actualizado exitosamente");
		}
		return ResponseType.error("El nombre del producto ya existe");
	}

	public ResponseType deleteProduct(UUID _productId) {
		Product product = getProduct(_productId);

		if (product == null) return ResponseType.error("El producto no existe");
		int rowsAffected = productModel.deleteProduct(product.getProductId());

		return rowsAffected == 0 ?
			ResponseType.error("Falló la eliminación del producto") :
			ResponseType.success("El producto se eliminado exitosamente");
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

	public boolean isExistProduct(String _productName) {
		List<Product> products = searchProduct(_productName);
		boolean isExist = false;
		for (Product product : products) {
			if (product
				.getProductName()
				.toLowerCase()
				.equals(_productName.toLowerCase())) {
				isExist = true;
			}
		}
		return isExist;
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
