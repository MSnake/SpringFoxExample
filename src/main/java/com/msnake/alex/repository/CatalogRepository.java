package com.msnake.alex.repository;

import com.msnake.alex.model.Catalog;
import org.springframework.data.repository.CrudRepository;

/**
 * Catalog Repository
 *
 * @author shigaevak
 * @since 05.07.2017
 */
public interface CatalogRepository extends CrudRepository<Catalog, Integer> {
}
