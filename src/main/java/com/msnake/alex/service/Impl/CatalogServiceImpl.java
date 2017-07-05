package com.msnake.alex.service.Impl;

import com.msnake.alex.model.Catalog;
import com.msnake.alex.repository.CatalogRepository;
import com.msnake.alex.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Catalog service impl
 *
 * @author shigaevak
 * @since 05.07.2017
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CatalogServiceImpl implements CatalogService {

    /**
     * Logger Object
     */
    private Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

    /**
     * Repository for Catalog
     */
    @Autowired
    CatalogRepository catalogRepository;

    @Override
    public List<Catalog> get() throws Exception {
        List<Catalog> catalogs = (List<Catalog>) catalogRepository.findAll();
        return catalogs;
    }

    @Override
    public Catalog get(Integer id) throws Exception {
        return catalogRepository.findOne(id);
    }

    @Override
    public Catalog create(Catalog entity) throws Exception {
        return catalogRepository.save(entity);
    }

    @Override
    public Catalog update(Catalog entity) throws Exception {
        return catalogRepository.save(entity);
    }

    @Override
    public void remove(Integer id) throws Exception {
        catalogRepository.delete(id);
    }
}
