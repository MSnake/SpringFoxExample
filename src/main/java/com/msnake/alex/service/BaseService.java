package com.msnake.alex.service;

import java.io.Serializable;
import java.util.List;


/**
 * Generic service with ba
 *
 * @param <T> generic
 * @author shigaevak
 * @since 16.06.2017
 */
public interface BaseService<T extends Serializable> {

    /**
     * Get entity list
     *
     * @return entity list
     */
    List<T> get() throws Exception;


    /**
     * Ger entity by id
     *
     * @param id entity id
     * @return entity
     */
    T get(Integer id) throws Exception;

    /**
     * Create new entity
     *
     * @param entity entity model
     * @return entity model
     */
    T create(T entity) throws Exception;

    /**
     * Update entity
     *
     * @param entity entity model
     * @return entity model
     */
    T update(T entity) throws Exception;

    /**
     * Remove entity
     *
     * @param id entity id
     */
    void remove(Integer id) throws Exception;

}
