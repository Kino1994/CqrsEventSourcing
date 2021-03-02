package es.joaquin.cqrses.application.layer;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Service;

import es.joaquin.cqrses.domain.dto.FullProductDTO;
import es.joaquin.cqrses.domain.repository.ProductRepository;

@Service
public class ProductQueryService {

  private ProductRepository productRepository;

  public ProductQueryService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Collection<FullProductDTO> findAll() {
    return productRepository.finAll();
  }

  public FullProductDTO findById(String id) {
    return productRepository.findById(UUID.fromString(id));
  }
}


