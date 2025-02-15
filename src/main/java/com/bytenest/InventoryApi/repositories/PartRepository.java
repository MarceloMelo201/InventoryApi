package com.bytenest.InventoryApi.repositories;

import com.bytenest.InventoryApi.models.entities.PartModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PartRepository extends JpaRepository<PartModel, UUID> {

    Optional<PartModel> findByCodeSku(String codeSku);
}
