package es.joaquin.cqrses.domain;

import java.util.List;

public interface ValidationService {

	boolean validate(List<ShoppingCartItem> items);
	
}
