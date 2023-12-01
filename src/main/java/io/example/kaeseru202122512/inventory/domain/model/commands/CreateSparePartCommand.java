package io.example.kaeseru202122512.inventory.domain.model.commands;

public record CreateSparePartCommand(Long supplierId, String model, String supplierProvidedSerialNumber, Long equipmentId) {
}
