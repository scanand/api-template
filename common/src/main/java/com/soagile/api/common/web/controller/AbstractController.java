package com.soagile.api.common.web.controller;

import com.soagile.api.common.persistence.model.IEntity;
import com.soagile.api.common.web.RestPreConditions;

/**
 * Created by BMGTS on 21/03/2016.
 */
public abstract class AbstractController <T extends IEntity> extends AbstractReadOnlyController<T>
{

    public AbstractController (final Class<T> clazzToSet )
    {
        super(clazzToSet);
    }


    protected final void createInternal( final T resource) {

        RestPreConditions.checkRequestElementNotNull(resource);
        RestPreConditions.checkRequestState(resource.getId() == null);
        getService().create(resource);
    }

}
