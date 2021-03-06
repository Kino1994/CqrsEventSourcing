package es.joaquin.cqrses.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import es.joaquin.cqrses.domain.dto.ShoppingCartDontStockException;
import es.joaquin.cqrses.domain.service.ValidationService;

public class ShoppingCart {

	private UUID id;
	private ShoppingCartStatus status;
	private List<ShoppingCartItem> items;

	private ValidationService validationService;

	public ShoppingCart() {
		super();

		this.status = ShoppingCartStatus.PENDING;
		this.items = new ArrayList<>();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}

	public List<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItem> items) {
		this.items = items;
	}

	public ValidationService getValidationService() {
		return validationService;
	}

	public void setValidationService(ValidationService validationService) {
		this.validationService = validationService;
	}

	public void addItem(ShoppingCartItem shoppingCartItem) {
		this.items.add(shoppingCartItem);
	}

	public void removeItem(UUID idProduct) {
		this.items.removeIf(item -> item.getProduct().getId().equals(idProduct));
	}

	public double getPrice() {
		double price = 0;

		if (this.items != null) {
			for (ShoppingCartItem item : this.items) {
				price += item.getTotalPrice();
			}
		}

		return price;
	}

	public void validate() {
		if (this.status != ShoppingCartStatus.COMPLETED) {
			
			if (!validationService.validate(this.items)) {
				throw new ShoppingCartDontStockException("Not enough stock");
			}

			this.status = ShoppingCartStatus.COMPLETED;
		}
	}

}
