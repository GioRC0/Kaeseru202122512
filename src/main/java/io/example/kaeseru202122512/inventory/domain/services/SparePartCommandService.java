package io.example.kaeseru202122512.inventory.domain.services;

import io.example.kaeseru202122512.inventory.domain.model.commands.CreateSparePartCommand;

public interface SparePartCommandService {
    Long handle(CreateSparePartCommand command);
}
