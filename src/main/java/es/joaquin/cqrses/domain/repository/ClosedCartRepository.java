package es.joaquin.cqrses.domain.repository;

import java.util.List;

import es.joaquin.cqrses.domain.dto.ClosedCartDto;

public interface ClosedCartRepository {

	List<ClosedCartDto> findAll();

	ClosedCartDto save(ClosedCartDto cart);
}
