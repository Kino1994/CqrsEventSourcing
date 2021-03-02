package es.joaquin.cqrses.infrastructure.adapter;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import es.joaquin.cqrses.domain.dto.FullShoppingCartDTO;
import es.joaquin.cqrses.domain.repository.ShoppingCartRepository;
import es.joaquin.cqrses.infrastructure.entity.ShoppingCartEntity;
import es.joaquin.cqrses.infrastructure.exception.ShoppingCartNotFoundException;
import es.joaquin.cqrses.infrastructure.repository.SpringDataJPAShoppingCartRepository;

@Component
public class SpringDataJPAShoppingCartRepositoryAdapter implements ShoppingCartRepository {

	private SpringDataJPAShoppingCartRepository repository;
	private ModelMapper mapper = new ModelMapper();

	public SpringDataJPAShoppingCartRepositoryAdapter(SpringDataJPAShoppingCartRepository repository) {
		this.repository = repository;
	}

	@Override
	public FullShoppingCartDTO findById(UUID id) {
		return mapper.map(repository.findById(id).orElseThrow(ShoppingCartNotFoundException::new),
		        FullShoppingCartDTO.class);
	}

	@Override
	public FullShoppingCartDTO save(FullShoppingCartDTO shoppingCart) {
		ShoppingCartEntity shoppingCartEntity = mapper.map(shoppingCart, ShoppingCartEntity.class);
		shoppingCartEntity.setId(UUID.randomUUID());
		repository.save(shoppingCartEntity);

		return findById(shoppingCartEntity.getId());
	}

	@Override
	public void deleteById(UUID id) {
		repository.deleteById(id);
	}

}
