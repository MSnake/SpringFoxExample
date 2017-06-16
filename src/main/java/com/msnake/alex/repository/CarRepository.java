package com.msnake.alex.repository;

import com.msnake.alex.model.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Car Repository
 *
 * @author shigaevak
 * @since 29.05.2017
 */
public interface CarRepository extends CrudRepository<Car, Integer> {
}
