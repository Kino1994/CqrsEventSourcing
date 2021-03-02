package es.joaquin.cqrses.domain.repository;

import java.util.UUID;

import es.joaquin.cqrses.domain.dto.FullShoppingCartDTO;

public interface ShoppingCartRepository {
	
	FullShoppingCartDTO findById(UUID id);

	FullShoppingCartDTO save(FullShoppingCartDTO shoppingCart);

	void deleteById(UUID id);
}
