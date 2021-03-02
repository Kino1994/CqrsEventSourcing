package es.joaquin.cqrses.controller;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.joaquin.cqrses.application.layer.ClosedCartQueryService;
import es.joaquin.cqrses.controller.dto.response.ClosedCartResponseDto;

@RestController
@RequestMapping("/api/cartexpenditure")
public class ClosedCartQueryController {

	private ClosedCartQueryService closedCartQueryService;
	private ModelMapper mapper = new ModelMapper();

	public ClosedCartQueryController(ClosedCartQueryService closedCartQueryService) {
		this.closedCartQueryService = closedCartQueryService;
	}

	@GetMapping
	public Collection<ClosedCartResponseDto> getShoppingCart() {
		return Arrays.asList(mapper.map(closedCartQueryService.findAll(), ClosedCartResponseDto[].class));
	}
}