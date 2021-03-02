package es.joaquin.cqrses.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.cqrses.infrastructure.entity.ProductEntity;

public interface SpringDataJPAProductRepository extends JpaRepository<ProductEntity, UUID> {

}
