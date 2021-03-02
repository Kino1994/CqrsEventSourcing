package es.joaquin.cqrses.controller;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.joaquin.cqrses.controller.dto.ClosedCartResponseDto;
import es.joaquin.cqrses.layer.application.ClosedCartQueryService;

@RestController
@RequestMapping("/api/cartexpenditure")
public class ClosedCartQueryController {

	private ClosedCartQueryService closedCartQueryService;
	private ModelMapper mapper = new ModelMapper();

	public ClosedCartQueryController(ClosedCartQueryService closedCartQueryService) {
		this.closedCartQueryService = closedCartQueryService;
	}

	@GetMapping
	public List<ClosedCartResponseDto> getShoppingCart() {
		return Arrays.asList(mapper.map(closedCartQueryService.findAll(), ClosedCartResponseDto[].class));
	}
}