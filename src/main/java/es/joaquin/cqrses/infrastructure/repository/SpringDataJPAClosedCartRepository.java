package es.joaquin.cqrses.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.cqrses.infrastructure.entity.ClosedCartEntity;

public interface SpringDataJPAClosedCartRepository extends JpaRepository<ClosedCartEntity, UUID> {

}
