package es.joaquin.cqrses.controller.dto.response;

import java.util.UUID;

public class ClosedCartResponseDto {

	private String cartId;

	private double expenditure;

	public ClosedCartResponseDto() {

	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId.toString();
	}

	public double getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(double expenditure) {
		this.expenditure = expenditure;
	}

}
