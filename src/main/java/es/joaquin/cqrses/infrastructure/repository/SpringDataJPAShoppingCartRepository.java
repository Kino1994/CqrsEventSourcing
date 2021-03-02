package es.joaquin.cqrses.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.cqrses.infrastructure.entity.ShoppingCartEntity;

public interface SpringDataJPAShoppingCartRepository extends JpaRepository<ShoppingCartEntity, UUID> {

}
