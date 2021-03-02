package es.joaquin.cqrses.layer.application;

import org.springframework.stereotype.Service;

import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.dto.ProductDTO;
import es.joaquin.cqrses.domain.service.ProductService;

@Service
public class ProductCommandService {

	private ProductService productService;
	
	private ProductQueryService productQueryService;

	public ProductCommandService(ProductService productService, ProductQueryService productQueryService) {
		this.productService = productService;
		this.productQueryService = productQueryService;
	}

	public FullProductDTO createProduct(ProductDTO productDTO) {
		return productService.createProduct(productDTO);
	}

	public FullProductDTO deleteProduct(String id) {
		FullProductDTO fullProductDTO = productQueryService.findById(id);
		return productService.deleteProduct(fullProductDTO);
	}

}