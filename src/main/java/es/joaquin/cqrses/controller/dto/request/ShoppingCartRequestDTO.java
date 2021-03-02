package es.joaquin.cqrses.controller.dto.request;

import es.joaquin.cqrses.domain.model.ShoppingCartStatus;

public class ShoppingCartRequestDTO {
	
	private ShoppingCartStatus status;

	public ShoppingCartRequestDTO() {
		super();
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}

}
