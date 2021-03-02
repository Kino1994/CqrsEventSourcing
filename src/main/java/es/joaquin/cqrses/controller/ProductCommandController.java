package es.joaquin.cqrses.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.joaquin.cqrses.application.layer.ProductCommandService;
import es.joaquin.cqrses.controller.dto.request.ProductRequestDTO;
import es.joaquin.cqrses.controller.dto.response.ProductResponseDTO;
import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.dto.ProductDTO;

@RestController
@RequestMapping("/api/products")
public class ProductCommandController {

	private ProductCommandService productCommandService;

	private ModelMapper mapper = new ModelMapper();

	public ProductCommandController(ProductCommandService productCommandService) {
		this.productCommandService = productCommandService;
	}

	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		ProductDTO productDTO = mapper.map(productRequestDTO, ProductDTO.class);
		FullProductDTO fullProductDTO = productCommandService.createProduct(productDTO);

		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(fullProductDTO.getId()).toUri();

		return ResponseEntity.created(location).body(mapper.map(fullProductDTO, ProductResponseDTO.class));
	}

	@DeleteMapping("/{id}")
	public ProductResponseDTO deleteProduct(@PathVariable String id) {
		return mapper.map(productCommandService.deleteProduct(id), ProductResponseDTO.class);
	}

}