package es.joaquin.cqrses.infrastructure.adapter;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import es.joaquin.cqrses.domain.dto.ClosedCartDto;
import es.joaquin.cqrses.domain.repository.ClosedCartRepository;
import es.joaquin.cqrses.infrastructure.entity.ClosedCartEntity;
import es.joaquin.cqrses.infrastructure.repository.SpringDataJPAClosedCartRepository;

@Component
public class SpringDataJPAClosedCartRepositoryAdapter implements ClosedCartRepository {

	private SpringDataJPAClosedCartRepository repository;

	private ModelMapper mapper = new ModelMapper();

	public SpringDataJPAClosedCartRepositoryAdapter(SpringDataJPAClosedCartRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<ClosedCartDto> findAll() {
		return Arrays.asList(mapper.map(repository.findAll(), ClosedCartDto[].class));
	}

	@Override
	public ClosedCartDto save(ClosedCartDto cart) {
		ClosedCartEntity closedCartEntity = mapper.map(cart, ClosedCartEntity.class);
		closedCartEntity.setCartId(UUID.randomUUID());
		repository.save(closedCartEntity);

		return mapper.map(closedCartEntity, ClosedCartDto.class);
	}
}
