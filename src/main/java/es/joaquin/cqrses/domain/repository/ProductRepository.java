package es.joaquin.cqrses.domain.repository;

import java.util.Collection;
import java.util.UUID;

import es.joaquin.cqrses.domain.dto.FullProductDTO;

public interface ProductRepository {
	
	Collection<FullProductDTO> finAll();

	FullProductDTO findById(UUID id);

	FullProductDTO save(FullProductDTO product);

	void deleteById(UUID id);
}
