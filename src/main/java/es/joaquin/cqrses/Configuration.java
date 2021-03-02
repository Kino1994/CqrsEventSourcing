package es.joaquin.cqrses;

import org.springframework.context.annotation.Bean;

import es.joaquin.cqrses.domain.repository.ProductRepository;
import es.joaquin.cqrses.domain.repository.ShoppingCartRepository;
import es.joaquin.cqrses.domain.service.ProductService;
import es.joaquin.cqrses.domain.service.ProductServiceImpl;
import es.joaquin.cqrses.domain.service.ShoppingCartService;
import es.joaquin.cqrses.domain.service.ShoppingCartServiceImpl;
import es.joaquin.cqrses.service.ValidationServiceImpl;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ShoppingCartService shoppingCartService(
			ShoppingCartRepository shoppingCartRepository,
			ProductRepository productRepository) {
		return new ShoppingCartServiceImpl(shoppingCartRepository, productRepository,
				new ValidationServiceImpl());
	}

	@Bean
	public ProductService productService(ProductRepository productRepository) {
		return new ProductServiceImpl(productRepository);
	}

}
