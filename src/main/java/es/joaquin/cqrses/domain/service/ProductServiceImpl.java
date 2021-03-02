package es.joaquin.cqrses.domain.service;

import java.util.Collection;
import java.util.UUID;

import org.modelmapper.ModelMapper;

import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.dto.ProductDTO;
import es.joaquin.cqrses.domain.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	private ProductRepository repository;
	
	ModelMapper mapper = new ModelMapper();

	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<FullProductDTO> getProducts() {
		return repository.finAll();
	}

	@Override
	public FullProductDTO getProduct(UUID id) {
		return repository.findById(id);
	}

	@Override
	public FullProductDTO createProduct(ProductDTO productDTO) {
		FullProductDTO fullProductDTO = mapper.map(productDTO, FullProductDTO.class);
		FullProductDTO saveFullProductDTO = repository.save(fullProductDTO);

		return (saveFullProductDTO != null) ? saveFullProductDTO : fullProductDTO;
	}

	@Override
	public FullProductDTO deleteProduct(FullProductDTO fullProductDTO) {
		repository.deleteById(fullProductDTO.getId());
		return fullProductDTO;
	}

}
