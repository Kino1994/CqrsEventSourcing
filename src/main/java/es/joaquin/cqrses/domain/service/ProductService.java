package es.joaquin.cqrses.domain.service;

import java.util.Collection;
import java.util.UUID;

import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.dto.ProductDTO;

public interface ProductService {
	
	public Collection<FullProductDTO> getProducts();
	
	public FullProductDTO getProduct(UUID id);
	
	public FullProductDTO createProduct(ProductDTO productDTO);
	
	public FullProductDTO deleteProduct(FullProductDTO fullProductDTO);
	
}