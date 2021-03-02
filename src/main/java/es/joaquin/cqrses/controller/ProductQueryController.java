package es.joaquin.cqrses.controller;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.joaquin.cqrses.application.layer.ProductQueryService;
import es.joaquin.cqrses.controller.dto.response.ProductResponseDTO;

@RestController
@RequestMapping("/api/products")
public class ProductQueryController {

	private ProductQueryService productQueryService;

	private ModelMapper mapper = new ModelMapper();

	public ProductQueryController(ProductQueryService productQueryService) {
		this.productQueryService = productQueryService;
	}

	@GetMapping
	public Collection<ProductResponseDTO> getProducts() {
		return Arrays.asList(mapper.map(productQueryService.findAll(), ProductResponseDTO[].class));
	}

	@GetMapping("/{id}")
	public ProductResponseDTO getProduct(@PathVariable String id) {
		return mapper.map(productQueryService.findById(id), ProductResponseDTO.class);
	}

}