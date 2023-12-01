package io.example.kaeseru202122512.inventory.interfaces.rest.resources;

public record CreateSparePartResource(
        Long supplierId,
        String model,
        String supplierProvidedSerialNumber,
        Long equipmentId
) {
}
