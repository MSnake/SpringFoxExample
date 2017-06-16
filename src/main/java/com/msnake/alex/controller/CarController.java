package com.msnake.alex.controller;

import com.msnake.alex.model.Car;
import com.msnake.alex.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Car REST - controller
 *
 * @author shigaevak
 * @since 14.06.2017
 */
@RequestMapping(path = "v1/cars/", produces = "application/json; charset=utf-8")
@RestController
@CrossOrigin
@Api(value = "Cars")
public class CarController {

    /**
     * Service for car
     */
    @Autowired
    CarService carService;

    /**
     * Get all cars from DB
     *
     * @return - car list, http - status
     */
    @GetMapping
    @ApiOperation(value = "Get list of cars")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", responseContainer = "List", response = Car.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity(carService.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get car by id
     *
     * @param id - car id
     * @return - information about car, http - статус
     */
    @GetMapping(value = "{id}")
    @ApiOperation(value = "Get a car")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Car.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity(carService.get(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create new car
     *
     * @param car - information about car(car model)
     * @return - new car model, http - status
     */
    @PostMapping
    @ApiOperation(value = "Create new car")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success to create new car", response = Car.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity create(@RequestBody Car car) {
        try {
            return new ResponseEntity(carService.create(car), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update information about car
     *
     * @param car - information about car(car model)
     * @return - updated car model, http - status
     */
    @PutMapping
    @ApiOperation(value = "Update information about car")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Car updated", response = Car.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity update(@RequestBody Car car) {
        try {
            return new ResponseEntity(carService.update(car), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Remove car
     *
     * @param carId - car id
     * @return - http - status
     */
    @DeleteMapping(value = "{id}")
    @ApiOperation(value = "Remove car")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Car removed"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity remove(@PathVariable(value = "id") Integer carId) {
        try {
            carService.remove(carId);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
