package es.joaquin.cqrses.controller.dto.response;

import java.util.List;

import es.joaquin.cqrses.domain.model.ShoppingCartStatus;

public class ShoppingCartResponseDTO {

	private String id;
	private ShoppingCartStatus status;
	private List<ShoppingCartItemResponseDTO> items;
	private double price;

	public ShoppingCartResponseDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}

	public List<ShoppingCartItemResponseDTO> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItemResponseDTO> items) {
		this.items = items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
