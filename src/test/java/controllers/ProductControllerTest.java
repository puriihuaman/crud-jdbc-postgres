package controllers;

import models.Product;
import models.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {
	private final ProductModel model = new ProductModel();
	private final ProductController controller = new ProductController();

	@Test
	void createProduct() {
		Product existingProduct = new Product("Leche Gloria", 5.50, (short) 20);
		Product newProduct = new Product("Leche Nestle", 2.50, (short) 50);

		boolean
			isExistingProductExists
			= controller.isExistProduct(existingProduct.getProductName());
		boolean
			isNewProductExists
			= controller.isExistProduct(newProduct.getProductName());

		int createExistingProductResult = model.createProduct(existingProduct);
		int createNewProductResult = model.createProduct(newProduct);

		assertTrue(isExistingProductExists);
		assertFalse(isNewProductExists);
		assertEquals(0,
			createExistingProductResult,
			"El producto no se debe estar duplicado"
		);
		assertEquals(1,
			createNewProductResult,
			"El producto no se debe existir en la base de datos para registrarse"
		);
	}

	@Test
	void updateProduct() {
		Product existingProduct = new Product(UUID.fromString(
			"ad2f6072-82f2-4826-b88c-7a357f7d160a"),
			"Leche Gloria",
			5.50,
			(short) 20
		);
		Product productToUpdate = new Product(UUID.fromString(
			"ad2f6072-82f2-4826-b88c-7a357f7d160a"),
			"Leche Nestle",
			5,
			(short) 50
		);

		boolean
			isExistingProductExists
			= controller.isExistProduct(existingProduct.getProductName());
		boolean
			isNewProductExists
			= controller.isExistProduct(productToUpdate.getProductName());

		int updateProductResult = model.updateProduct(productToUpdate);

		assertTrue(isExistingProductExists,
			"El nombre producto debe existir una sola vez"
		);
		assertFalse(isNewProductExists,
			"El nombre del producto no debe existir por duplicado"
		);
		assertEquals(1, updateProductResult);
	}

	@Test
	void deleteProduct() {
		UUID productId = UUID.randomUUID();
		Product product = getProduct(productId);

		// Agregar id existente para probar que pasa
		// Product product = getProduct(UUID.fromString("id"));
		assertNotNull(product, "El producto debe existir en la base de datos");
		assertInstanceOf(Product.class, product);

		int rowsAffected = model.deleteProduct(product.getProductId());
		assertEquals(1, rowsAffected, "Debe eliminar exactamente un producto");

		Product deletedProduct = getProduct(productId);
		assertNull(deletedProduct, "El producto debe haber sido eliminado");
	}

	@Test
	void searchProduct() throws SQLException {
		String productName = "Coca Cola";
		List<Product> products = new ArrayList<>();
		ResultSet rs = model.searchProduct(productName);
		while (rs.next()) {
			products.add(convert(rs));
		}
		assertNotNull(products, "La lista de productos no debe ser nula");
		assertFalse(
			products.isEmpty(),
			"La lista debe estar vacía si no se encuentran coincidencias"
		);
	}

	@Test
	void getAllProducts() throws SQLException {
		ResultSet rs = model.getAllProducts();
		List<Product> products = new ArrayList<>();

		while (rs.next()) {
			products.add(convert(rs));
		}
		assertNotNull(products, "La lista de productos no debe ser nula");
		assertFalse(
			products.isEmpty(),
			"La lista debe estar vacía si no se encuentran coincidencias"
		);
	}

	private Product getProduct(UUID _productId) {
		Product product = null;

		try (ResultSet rs = model.getProduct(_productId)) {
			if (rs.next()) {
				product = new Product(UUID.fromString(rs.getString("product_id")),
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

	private Product convert(ResultSet _rs) {
		Product product = null;
		try {
			product = new Product(UUID.fromString(_rs.getString("product_id")),
				_rs.getString("product_name"),
				_rs.getDouble("price"),
				_rs.getShort("stock")
			);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return product;
	}
}