package es.joaquin.cqrses.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {

}
