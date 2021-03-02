package es.joaquin.cqrses.service;

import java.util.List;
import java.util.Random;

import es.joaquin.cqrses.domain.model.ShoppingCartItem;
import es.joaquin.cqrses.domain.service.ValidationService;

public class ValidationServiceImpl implements ValidationService {

	@Override
	public boolean validate(List<ShoppingCartItem> items) {
		Random rnd = new Random();

		return rnd.nextBoolean();
	}


}
