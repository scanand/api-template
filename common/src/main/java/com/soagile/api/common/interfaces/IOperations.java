package com.soagile.api.common.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Created by BMGTS on 22/03/2016.
 */
public interface IOperations<T extends Serializable>
{
    T findOne(final long id);

    List<T> findAll();

    T create(final T resource);

}
