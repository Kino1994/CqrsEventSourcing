package es.joaquin.cqrses.domain.model;

public class ShoppingCartItem {

	private String id;
	private Product product;
	private int quantity;

	public ShoppingCartItem() {
		super();
	}

	public ShoppingCartItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
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
		return this.quantity * this.product.getPrice();
	}

}
