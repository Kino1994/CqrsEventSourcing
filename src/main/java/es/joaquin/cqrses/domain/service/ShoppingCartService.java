package es.joaquin.cqrses.domain.service;

import java.util.UUID;

import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.dto.FullShoppingCartDTO;
import es.joaquin.cqrses.domain.dto.ShoppingCartDTO;

public interface ShoppingCartService {
	
	public FullShoppingCartDTO getShoppingCart(UUID id);

	public FullShoppingCartDTO createShoppingCart();

	public FullShoppingCartDTO updateShoppingCart(UUID id, ShoppingCartDTO shoppingCartDTO);

	public FullShoppingCartDTO deleteShoppingCart(UUID id);

	public FullShoppingCartDTO addProduct(UUID idShoppingCart, UUID idProduct, int nProducts);

	public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
	        int quantity);

	public FullShoppingCartDTO deleteProduct(UUID idShoppingCart, UUID idProduct);
}
