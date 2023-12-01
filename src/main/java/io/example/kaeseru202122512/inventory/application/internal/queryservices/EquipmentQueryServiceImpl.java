package io.example.kaeseru202122512.inventory.application.internal.queryservices;

import io.example.kaeseru202122512.inventory.domain.model.aggregates.Equipment;
import io.example.kaeseru202122512.inventory.domain.model.queries.GetEquipmentByIdQuery;
import io.example.kaeseru202122512.inventory.domain.services.EquipmentQueryService;
import io.example.kaeseru202122512.inventory.infrastructure.persistencia.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentQueryServiceImpl implements EquipmentQueryService {
    private EquipmentRepository equipmentRepository;

    public EquipmentQueryServiceImpl(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Optional<Equipment> handle(GetEquipmentByIdQuery query) {
        var equipment = equipmentRepository.findEquipmentById(query.equipmentId());
        return equipment;
    }
}
