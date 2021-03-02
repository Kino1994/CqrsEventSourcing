package es.joaquin.cqrses.layer.application;

import org.springframework.stereotype.Service;

import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.dto.FullShoppingCartDTO;
import es.joaquin.cqrses.domain.dto.ShoppingCartDTO;
import es.joaquin.cqrses.domain.service.ShoppingCartService;

@Service
public class ShoppingCartCommandService {

	private ShoppingCartService shoppingCartService;

	private ShoppingCartQueryService shoppingCartQueryService;

	private ProductQueryService productQueryService;

	public ShoppingCartCommandService(ShoppingCartService shoppingCartService,
			ShoppingCartQueryService shoppingCartQueryService, ProductQueryService productQueryService) {
		this.shoppingCartService = shoppingCartService;
		this.shoppingCartQueryService = shoppingCartQueryService;
		this.productQueryService = productQueryService;
	}

	public FullShoppingCartDTO createShoppingCart() {
		return shoppingCartService.createShoppingCart();
	}

	public FullShoppingCartDTO updateShoppingCart(String id, ShoppingCartDTO shoppingCartDTO) {
		FullShoppingCartDTO currentFullShoppingCartDTO = shoppingCartQueryService.findById(id);
		return shoppingCartService.updateShoppingCart(currentFullShoppingCartDTO.getId(), shoppingCartDTO);

	}

	public FullShoppingCartDTO deleteShoppingCart(String id) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartQueryService.findById(id);
		return shoppingCartService.deleteShoppingCart(fullShoppingCartDTO.getId());
	}

	public FullShoppingCartDTO addProduct(String idShoppingCart, String idProduct, int quantity) {
		FullProductDTO fullProductDTO = productQueryService.findById(idProduct);
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartQueryService.findById(idShoppingCart);
		return shoppingCartService.addProduct(fullShoppingCartDTO.getId(), fullProductDTO.getId(), quantity);
	}

	public FullShoppingCartDTO deleteProduct(String idShoppingCart, String idProduct) {
		FullProductDTO fullProductDTO = productQueryService.findById(idProduct);
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartQueryService.findById(idShoppingCart);
		return shoppingCartService.deleteProduct(fullShoppingCartDTO.getId(), fullProductDTO.getId());
	}

}