package com.example.crud.inventory;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }
    public List<Inventory> getInventory(){

        return inventoryRepository.findAll();
    }

    public void registerNewItem(Inventory inventory) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findInventoryByItemCode(inventory.getItemCode());
        if(inventoryOptional.isPresent())
        {
            throw new IllegalStateException("Item code already exists.");
        }
        inventoryRepository.save(inventory);
    }

    public void deleteItem(Long inventoryId) {
        boolean exists = inventoryRepository.existsById(inventoryId);
        if (!exists) {
            throw new IllegalStateException(
                    "Item with id " + inventoryId + " does not exists."
            );
        }
        inventoryRepository.deleteById(inventoryId);
    }

    @Transactional
    public void updateItem(Long inventoryId, String item, Integer quantity) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new IllegalStateException(
                                "Item with id " + inventoryId + "does now exist."
                        )
                );
        if (
                item != null && item.length() > 0 && !Objects.equals(inventory.getItem(), item)
        ){
            inventory.setItem(item);
        }

        if (
                quantity != null && quantity > 0 && !Objects.equals(inventory.getQuantity(), quantity)
        ){
            inventory.setQuantity(quantity);
        }
    }
}