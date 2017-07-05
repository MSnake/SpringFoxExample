package com.msnake.alex.controller;

import com.msnake.alex.model.Catalog;
import com.msnake.alex.service.CatalogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Catalog REST - controller
 *
 * @author shigaevak
 * @since 05.07.2017
 */
@RequestMapping(path = "v1/catalogs/", produces = "application/json; charset=utf-8")
@RestController
@CrossOrigin
@Api(value = "Catalogs")
public class CatalogController {

    /**
     * Service for catalog
     */
    @Autowired
    CatalogService catalogService;

    /**
     * Get all catalogs from DB
     *
     * @return - car list, http - status
     */
    @GetMapping
    @ApiOperation(value = "Get list of catalogs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", responseContainer = "List", response = Catalog.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity(catalogService.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get catalog by id
     *
     * @param id - car id
     * @return - information about car, http - статус
     */
    @GetMapping(value = "{id}")
    @ApiOperation(value = "Get a catalog")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Catalog.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity(catalogService.get(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create new catalog
     *
     * @param catalog - information about catalog(catalog model)
     * @return - new catalog model, http - status
     */
    @PostMapping
    @ApiOperation(value = "Create new catalog")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success to create new catalog", response = Catalog.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity create(@RequestBody Catalog catalog) {
        try {
            return new ResponseEntity(catalogService.create(catalog), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update information about catalog
     *
     * @param car - information about catalog(catalog model)
     * @return - updated catalog model, http - status
     */
    @PutMapping
    @ApiOperation(value = "Update information about catalog")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Catalog updated", response = Catalog.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity update(@RequestBody Catalog car) {
        try {
            return new ResponseEntity(catalogService.update(car), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Remove catalog
     *
     * @param catalogId - catalog id
     * @return - http - status
     */
    @DeleteMapping(value = "{id}")
    @ApiOperation(value = "Remove catalog")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Catalog removed"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity remove(@PathVariable(value = "id") Integer catalogId) {
        try {
            catalogService.remove(catalogId);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
