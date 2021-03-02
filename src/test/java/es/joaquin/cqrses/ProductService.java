package es.joaquin.cqrses;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.modelmapper.ModelMapper;

import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.dto.ProductDTO;
import es.joaquin.cqrses.domain.model.Product;
import es.joaquin.cqrses.domain.repository.ProductRepository;
import es.joaquin.cqrses.domain.service.ProductServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class ProductService {

	private ProductRepository productRepository;
	private ProductServiceImpl productService;

	private ModelMapper mapper = new ModelMapper();

	private static FullProductDTO createdProduct;

	@BeforeEach
	void setUp() {
		productRepository = mock(ProductRepository.class);
		productService = new ProductServiceImpl(productRepository);
	}

	@Test
	@Order(1)
	void productCanBeAdded() {
		Product product = new Product(
		        "PLUMÍFERO MONTAÑA Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
		        "Esta chaqueta acolchada de plumón y plumas, con certificado RDS, abriga bien durante un vivac entre +5 °C y -5 °C.",
		        49.99);

		ProductDTO productDTO = mapper.map(product, ProductDTO.class);

		createdProduct = productService.createProduct(productDTO);
		verify(productRepository).save(createdProduct);
	}

	@Test
	@Order(2)
	void productCanBeDeleted() {
		productService.deleteProduct(createdProduct);
		verify(productRepository).deleteById(createdProduct.getId());
	}
}
