package com.riwi.Performance_test.infrastructure.controllers.impl;

import com.riwi.Performance_test.application.servicies.IModel.IModalPallets;
import com.riwi.Performance_test.application.servicies.IModel.IModelLoads;
import com.riwi.Performance_test.application.servicies.impl.LoadImpl;
import com.riwi.Performance_test.domain.models.LoadsEntity;
import com.riwi.Performance_test.domain.models.PalletsEntity;
import com.riwi.Performance_test.infrastructure.controllers.interfaces.IPalletController;
import com.riwi.Performance_test.infrastructure.dtos.request.PalletRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/pallets")
public class PalletController implements IPalletController {
    @Autowired
    IModalPallets iModalPallets;
    @Autowired
    IModelLoads iModelLoads;
    @Operation(summary = "Delete a Pallet", description = "Deletes a pallet by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pallet deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Pallet not found.")
    })
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        iModalPallets.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }


    @Operation(summary = "Get All Pallets", description = "Retrieves a list of all pallets.")
    @ApiResponse(responseCode = "200", description = "List of pallets retrieved successfully.")
    @Override
    @GetMapping
    public ResponseEntity<List<PalletsEntity>> getAll() {
        return ResponseEntity.status(200).body(iModalPallets.getAll());
    }


    @Operation(summary = "Get Pallet by ID", description = "Retrieves a pallet by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pallet retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Pallet not found.")
    })
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById( @PathVariable Long id) {
        return ResponseEntity.status(200).body(iModalPallets.getById(id));
    }


    @Operation(summary = "Create a Pallet", description = "Creates a new pallet.")
    @ApiResponse(responseCode = "201", description = "Pallet created successfully.")
    @Override
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid PalletRequest palletRequest) {
        return ResponseEntity.status(201).body(iModalPallets.save(palletRequest));
    }


    @Operation(summary = "Update a Pallet", description = "Updates an existing pallet.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pallet updated successfully."),
            @ApiResponse(responseCode = "404", description = "Pallet not found.")
    })
    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid PalletRequest palletRequest) {
        return ResponseEntity.status(200).body(iModalPallets.update( palletRequest, id));
    }


    @Operation(
            summary = "Get loads by pallet ID",
            description = "Retrieve all loads associated with a specific pallet. Accessible by Transporter or Administrator roles.",
            parameters = {
                    @Parameter(name = "id", description = "ID of the pallet", required = true, example = "1")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Loads retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Pallet not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}/loads")
    public ResponseEntity<Set<LoadsEntity>> getLoadsByPalletId(@PathVariable Long id) {
        Set<LoadsEntity> loads = iModelLoads.getLoadsByPalletId(id);
        return ResponseEntity.ok(loads);
    }
}
