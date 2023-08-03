package com.example.crud.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v2/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {

        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Inventory> getInventory() {

        return inventoryService.getInventory();
    }

    @PostMapping
    public void registerNewItem(@RequestBody Inventory inventory){
        inventoryService.registerNewItem(inventory);
    }

    @DeleteMapping(path = "{inventoryId}")
    public void deleteItem(@PathVariable("inventoryId") Long inventoryId){
        inventoryService.deleteItem(inventoryId);
    }

    @PutMapping(path = "{inventoryId}")
    public void updateItem(
            @PathVariable("inventoryId") Long inventoryId,
            @RequestParam(required = false) String item,
            @RequestParam(required = false) Integer quantity
    ){
        inventoryService.updateItem(inventoryId, item, quantity);
    }

}
