package es.joaquin.cqrses.domain.repository;

import java.util.Collection;

import es.joaquin.cqrses.domain.dto.ClosedCartDto;

public interface ClosedCartRepository {

	Collection<ClosedCartDto> findAll();

	ClosedCartDto save(ClosedCartDto cart);
}
