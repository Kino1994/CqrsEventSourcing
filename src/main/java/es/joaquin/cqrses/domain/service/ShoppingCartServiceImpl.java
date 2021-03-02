package es.joaquin.cqrses.domain.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;

import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.dto.FullShoppingCartDTO;
import es.joaquin.cqrses.domain.dto.ShoppingCartDTO;
import es.joaquin.cqrses.domain.model.Product;
import es.joaquin.cqrses.domain.model.ShoppingCart;
import es.joaquin.cqrses.domain.model.ShoppingCartItem;
import es.joaquin.cqrses.domain.model.ShoppingCartStatus;
import es.joaquin.cqrses.domain.repository.ProductRepository;
import es.joaquin.cqrses.domain.repository.ShoppingCartRepository;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartRepository shoppingCartRepository;
	
	private ProductRepository productRepository;
	
	private ValidationService validationService;
	
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
	        ProductRepository productRepository,
	        ValidationService validationService) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.productRepository = productRepository;
		this.validationService = validationService;
	}
	
	private FullShoppingCartDTO saveShoppingCart(FullShoppingCartDTO fullShoppingCartDTO) {
		FullShoppingCartDTO saveFullShoppingCartDTO = shoppingCartRepository.save(fullShoppingCartDTO);

		return (saveFullShoppingCartDTO != null) ? saveFullShoppingCartDTO : fullShoppingCartDTO;
	}

	@Override
	public FullShoppingCartDTO getShoppingCart(UUID id) {
		return mapper.map(shoppingCartRepository.findById(id), FullShoppingCartDTO.class);
	}

	@Override
	public FullShoppingCartDTO createShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		FullShoppingCartDTO fullShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		
		return saveShoppingCart(fullShoppingCartDTO);
	}

	@Override
	public FullShoppingCartDTO updateShoppingCart(UUID id, ShoppingCartDTO shoppingCartDTO) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);

		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		ShoppingCart updateShoppingCart = mapper.map(shoppingCartDTO, ShoppingCart.class);

		if (updateShoppingCart.getStatus() != null &&
		        updateShoppingCart.getStatus() == ShoppingCartStatus.COMPLETED) {
			shoppingCart.setValidationService(validationService);
			shoppingCart.validate();
		}

		FullShoppingCartDTO newShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		
		return saveShoppingCart(newShoppingCartDTO);
	}

	@Override
	public FullShoppingCartDTO deleteShoppingCart(UUID id) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);
		shoppingCartRepository.deleteById(id);

		return fullShoppingCartDTO;
	}

	@Override
	public FullShoppingCartDTO addProduct(UUID idShoppingCart, UUID idProduct, int quantity) {
		FullProductDTO fullProductDTO = productRepository.findById(idProduct);
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

		return addProduct(fullProductDTO, fullShoppingCartDTO, quantity);
	}

	public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
	        int quantity) {
		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(fullProductDTO.getId());

		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(
		        mapper.map(fullProductDTO, Product.class),
		        quantity);
		shoppingCart.addItem(shoppingCartItem);

		FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

		return saveShoppingCart(newFullProductDTO);
	}

	@Override
	public FullShoppingCartDTO deleteProduct(UUID idShoppingCart, UUID idProduct) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(idProduct);

		FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

		return saveShoppingCart(newFullProductDTO);
	}
}
