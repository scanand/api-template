package com.soagile.api.common.web.controller;

import com.google.common.base.Preconditions;
import com.soagile.api.common.persistence.model.IEntity;
import com.soagile.api.common.persistence.service.IRawService;
import com.soagile.api.common.web.RestPreConditions;

/**
 * Created by BMGTS on 21/03/2016.
 */
public abstract class AbstractReadOnlyController<T extends IEntity> {
    protected Class<T> clazz;

    public AbstractReadOnlyController(final Class<T> clazzToSet) {
        super();
        Preconditions.checkNotNull(clazzToSet);
        clazz = clazzToSet;
    }

    protected abstract IRawService<T> getService();

    protected final T findOneInternal(final Long id) {
        return RestPreConditions.checkNotNull(getService().findOne(id));

    }

}
