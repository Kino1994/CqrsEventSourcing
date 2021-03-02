package es.joaquin.cqrses.controller.dto;

import es.joaquin.cqrses.domain.model.Product;

public class ShoppingCartItemResponseDTO {

	private String id;
	private Product product;
	private int quantity;
	private double totalPrice;

	public ShoppingCartItemResponseDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
