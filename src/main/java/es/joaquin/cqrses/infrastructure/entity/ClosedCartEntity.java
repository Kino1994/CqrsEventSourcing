package es.joaquin.cqrses.infrastructure.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClosedCartEntity {
	
  @Id
  private UUID cartId;

  private double expenditure;

  
  public ClosedCartEntity() {
	  
  }

  public ClosedCartEntity(UUID cartId, double expenditure) {
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