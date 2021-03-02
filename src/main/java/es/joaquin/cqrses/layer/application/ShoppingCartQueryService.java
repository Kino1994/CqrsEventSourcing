package es.joaquin.cqrses.layer.application;

import java.util.UUID;

import org.springframework.stereotype.Service;

import es.joaquin.cqrses.domain.dto.FullShoppingCartDTO;
import es.joaquin.cqrses.domain.repository.ShoppingCartRepository;

@Service
public class ShoppingCartQueryService {

  private ShoppingCartRepository shoppingCartRepository;

  public ShoppingCartQueryService(ShoppingCartRepository shoppingCartRepository) {
    this.shoppingCartRepository = shoppingCartRepository;
  }

  public FullShoppingCartDTO findById(String id) {
    return shoppingCartRepository.findById(UUID.fromString(id));
  }
  
}