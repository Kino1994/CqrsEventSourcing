package es.joaquin.cqrses.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.joaquin.cqrses.application.layer.ShoppingCartQueryService;
import es.joaquin.cqrses.controller.dto.response.ShoppingCartResponseDTO;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartQueryController {

	private ShoppingCartQueryService shoppingCartQueryService;

	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartQueryController(ShoppingCartQueryService shoppingCartQueryService) {
		this.shoppingCartQueryService = shoppingCartQueryService;
	}

	@GetMapping("/{id}")
	public ShoppingCartResponseDTO getShoppingCart(@PathVariable String id) {
		return mapper.map(shoppingCartQueryService.findById(id), ShoppingCartResponseDTO.class);
	}

}