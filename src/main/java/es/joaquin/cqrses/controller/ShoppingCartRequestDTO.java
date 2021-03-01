package es.joaquin.cqrses.controller;

import es.joaquin.cqrses.domain.ShoppingCartStatus;

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
