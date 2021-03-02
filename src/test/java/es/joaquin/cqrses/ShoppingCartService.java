package es.joaquin.cqrses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.modelmapper.ModelMapper;

import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.dto.FullShoppingCartDTO;
import es.joaquin.cqrses.domain.dto.FullShoppingCartItemDTO;
import es.joaquin.cqrses.domain.dto.ProductDTO;
import es.joaquin.cqrses.domain.model.Product;
import es.joaquin.cqrses.domain.repository.ProductRepository;
import es.joaquin.cqrses.domain.repository.ShoppingCartRepository;
import es.joaquin.cqrses.domain.service.ProductServiceImpl;
import es.joaquin.cqrses.domain.service.ShoppingCartServiceImpl;
import es.joaquin.cqrses.service.ValidationServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class ShoppingCartService {
	
	private ProductRepository productRepository;
	private ProductServiceImpl productService;

	private ShoppingCartRepository shoppingCartRepository;
	private ShoppingCartServiceImpl shoppingCartService;

	private ModelMapper mapper = new ModelMapper();
	
	private static FullShoppingCartDTO createdShoppingCart;
	
	@BeforeEach
	void setUp() {
		productRepository = mock(ProductRepository.class);
		shoppingCartRepository = mock(ShoppingCartRepository.class);
		
		productService = new ProductServiceImpl(productRepository);
		shoppingCartService = new ShoppingCartServiceImpl(
				shoppingCartRepository,
		        productRepository,
		        new ValidationServiceImpl());
	}
	
	@Test
	@Order(1)
	void shoppingCartCanBeAdded() {
		createdShoppingCart = shoppingCartService.createShoppingCart();
		verify(shoppingCartRepository).save(createdShoppingCart);
	}
	
	@Test
	@Order(2)
	void productCanBeAddedToShoppingCart() {
		Product product = new Product(
		        "PLUMÍFERO MONTAÑA Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
		        "Esta chaqueta acolchada de plumón y plumas, con certificado RDS, abriga bien durante un vivac entre +5 °C y -5 °C.",
		        49.99);
		ProductDTO productDTO = mapper.map(product, ProductDTO.class);

		FullProductDTO fullProductDTO = productService.createProduct(productDTO);
		verify(productRepository).save(fullProductDTO);
		
		int items = Math.abs(new Random().nextInt());
				
		createdShoppingCart = shoppingCartService.addProduct(fullProductDTO, createdShoppingCart, items);
		FullShoppingCartItemDTO fullShoppingCartItemDTO = createdShoppingCart.getItems().get(0);

		assertEquals(fullShoppingCartItemDTO.getQuantity(), items);
		assertEquals(fullShoppingCartItemDTO.getTotalPrice(), items * productDTO.getPrice());
	}
	
	@Test
	@Order(3)
	void shoppingCartCanBeDeleted() {
		shoppingCartService.deleteShoppingCart(createdShoppingCart.getId());
		verify(shoppingCartRepository).deleteById(createdShoppingCart.getId());
	}
}
