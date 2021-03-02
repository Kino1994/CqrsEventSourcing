package es.joaquin.cqrses.infrastructure.adapter;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.repository.ProductRepository;
import es.joaquin.cqrses.infrastructure.entity.ProductEntity;
import es.joaquin.cqrses.infrastructure.exception.ProductNotFoundException;
import es.joaquin.cqrses.infrastructure.repository.SpringDataJPAProductRepository;

@Component
public class SpringDataJPAProductRepositoryAdapter implements ProductRepository {

	private SpringDataJPAProductRepository repository;
	private ModelMapper mapper = new ModelMapper();

	public SpringDataJPAProductRepositoryAdapter(SpringDataJPAProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<FullProductDTO> finAll() {
		return Arrays.asList(mapper.map(repository.findAll(), FullProductDTO[].class));
	}

	@Override
	public FullProductDTO findById(UUID id) {
		return mapper.map(repository.findById(id).orElseThrow(ProductNotFoundException::new), FullProductDTO.class);
	}

	@Override
	public FullProductDTO save(FullProductDTO product) {
		ProductEntity productEntity = mapper.map(product, ProductEntity.class);
		repository.save(productEntity);

		return mapper.map(productEntity, FullProductDTO.class);
	}

	@Override
	public void deleteById(UUID id) {
		repository.deleteById(id);
	}

}
