package es.joaquin.cqrses.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAProductRepository extends JpaRepository<ProductEntity, Long> {

}
