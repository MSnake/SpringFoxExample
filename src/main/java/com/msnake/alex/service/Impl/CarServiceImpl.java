package com.msnake.alex.service.Impl;

import com.msnake.alex.model.Car;
import com.msnake.alex.repository.CarRepository;
import com.msnake.alex.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Car service impl
 *
 * @author shigaevak
 * @since 29.05.2017
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CarServiceImpl implements CarService {

    /**
     * Logger Object
     */
    private Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    /**
     * Repository for car
     */
    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> get() throws Exception {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car get(Integer id) throws Exception {
        return carRepository.findOne(id);
    }

    @Override
    public Car create(Car entity) throws Exception {
        return carRepository.save(entity);
    }

    @Override
    public Car update(Car entity) throws Exception {
        return carRepository.save(entity);
    }

    @Override
    public void remove(Integer id) throws Exception {
        carRepository.delete(id);

    }
}
