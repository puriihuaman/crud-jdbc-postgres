package models;

import java.util.UUID;

public class Product {
	private UUID productId;
	private String productName;
	private double price;
	private short stock;

	public Product() {
	}

	public Product(UUID _productId, String _productName, double _price, short _stock) {
		this.productId = _productId;
		this.productName = _productName;
		this.price = _price;
		this.stock = _stock;
	}

	public UUID getProductId() {
		return this.productId;
	}

	public void setProductId(final UUID _productId) {
		this.productId = _productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(final String _productName) {
		this.productName = _productName;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(final double _price) {
		this.price = _price;
	}

	public short getStock() {
		return this.stock;
	}

	public void setStock(final short _stock) {
		this.stock = _stock;
	}

	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName +
			", price=" + price + ", stock=" + stock + "]";
	}
}
