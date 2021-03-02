package es.joaquin.cqrses.layer.application;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.joaquin.cqrses.domain.dto.ClosedCartDto;
import es.joaquin.cqrses.domain.repository.ClosedCartRepository;

@Service
public class ClosedCartQueryService {

	private ClosedCartRepository closedCartRepository;

	public ClosedCartQueryService(ClosedCartRepository closedCartRepository) {
		this.closedCartRepository = closedCartRepository;
	}

	public Collection<ClosedCartDto> findAll() {
		return closedCartRepository.findAll();
	}
}
