package es.joaquin.cqrses.domain.service;

import java.util.List;

import es.joaquin.cqrses.domain.model.ShoppingCartItem;

public interface ValidationService {

	boolean validate(List<ShoppingCartItem> items);
	
}
