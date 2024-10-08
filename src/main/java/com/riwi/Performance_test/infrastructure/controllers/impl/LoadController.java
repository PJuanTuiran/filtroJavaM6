package com.riwi.Performance_test.infrastructure.controllers.impl;

import com.riwi.Performance_test.application.servicies.IModel.IModelLoads;
import com.riwi.Performance_test.domain.models.LoadsEntity;
import com.riwi.Performance_test.infrastructure.controllers.interfaces.ILoadController;
import com.riwi.Performance_test.infrastructure.dtos.request.LoadRequest;
import com.riwi.Performance_test.utils.enums.StatusLoads;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/loads")
public class LoadController implements ILoadController {
    @Autowired
    IModelLoads iModelLoads;

    @Operation(summary = "Delete a Load", description = "Deletes a load by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Load deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Load not found.")
    })
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        iModelLoads.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }

    @Operation(summary = "Get All Loads", description = "Retrieves a list of all loads.")
    @ApiResponse(responseCode = "200", description = "List of loads retrieved successfully.")
    @Override
    @GetMapping
    public ResponseEntity<List<LoadsEntity>> getAll() {
        return ResponseEntity.ok().body(iModelLoads.getAll()) ;
    }
    @Operation(summary = "Get Load by ID", description = "Retrieves a load by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Load retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Load not found.")
    })
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(Long id) {
        return ResponseEntity.ok(iModelLoads.getById(id));
    }

    @Operation(summary = "Create a Load", description = "Creates a new load.")
    @ApiResponse(responseCode = "201", description = "Load created successfully.")
    @PostMapping
    @Override
    public ResponseEntity<?> save(LoadRequest loadRequest) {
        return ResponseEntity.ok(iModelLoads.save(loadRequest));
    }
    @Operation(summary = "Update a Load", description = "Updates an existing load.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Load updated successfully."),
            @ApiResponse(responseCode = "404", description = "Load not found.")
    })
    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable Long id , @RequestBody @Valid LoadRequest loadRequest) {
        return ResponseEntity.ok(iModelLoads.update( loadRequest, id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateLoadStatus(@PathVariable Long id, @RequestBody StatusLoads status) {
        LoadsEntity updatedLoad = iModelLoads.updateStatus(id, status);
        return ResponseEntity.ok(updatedLoad);
    }
}
