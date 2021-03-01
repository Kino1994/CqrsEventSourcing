package es.joaquin.cqrses;

import org.springframework.context.annotation.Bean;

import es.joaquin.cqrses.domain.ProductService;
import es.joaquin.cqrses.domain.ProductServiceImpl;
import es.joaquin.cqrses.domain.ShoppingCartService;
import es.joaquin.cqrses.domain.ShoppingCartServiceImpl;
import es.joaquin.cqrses.infrastructure.SpringDataJPAProductRepositoryAdapter;
import es.joaquin.cqrses.infrastructure.SpringDataJPAShoppingCartRepositoryAdapter;
import es.joaquin.cqrses.service.ValidationServiceImpl;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ShoppingCartService shoppingCartService(
	        SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
	        SpringDataJPAProductRepositoryAdapter productRepositoryAdapter) {
		return new ShoppingCartServiceImpl(
		        shoppingCartRepositoryAdapter,
		        productRepositoryAdapter,
		        new ValidationServiceImpl());
	}

	@Bean
	public ProductService productService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductServiceImpl(repositoryAdapter);
	}

}
