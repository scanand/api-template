package com.soagile.api.common.persistence.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.soagile.api.common.persistence.model.IEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by BMGTS on 29/03/2016.
 */
@Transactional
public abstract class AbstractRawService<T extends IEntity> implements IRawService<T> {

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    protected abstract PagingAndSortingRepository<T, Long> getDao();

    public T create(final T entity) {
        Preconditions.checkNotNull(entity);

        final T persistedEntity = getDao().save(entity);

        return persistedEntity;
    }


}
