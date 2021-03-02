package es.joaquin.cqrses.domain.dto;

import java.util.UUID;

public class ClosedCartDto {

	private UUID cartId;
	private double expenditure;

	public ClosedCartDto() {

	}

	public ClosedCartDto(UUID cartId, double expenditure) {
		this.cartId = cartId;
		this.expenditure = expenditure;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public double getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(double expenditure) {
		this.expenditure = expenditure;
	}

}