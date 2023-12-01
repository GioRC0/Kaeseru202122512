package io.example.kaeseru202122512.inventory.infrastructure.persistencia.jpa.repositories;

import io.example.kaeseru202122512.inventory.domain.model.aggregates.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    Optional<Equipment> findEquipmentById(Long equipmentId);
}
