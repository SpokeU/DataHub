package dev.omyshko.datahub.data.repository;

import dev.omyshko.datahub.data.entity.ConnectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends JpaRepository<ConnectionEntity, Integer> {
}