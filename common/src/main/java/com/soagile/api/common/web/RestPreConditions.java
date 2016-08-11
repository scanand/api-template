package com.soagile.api.common.web;

import com.soagile.api.common.persistence.model.IEntity;
import com.soagile.api.common.web.exception.MyBadRequestException;
import com.soagile.api.common.web.exception.MyConflictException;
import com.soagile.api.common.web.exception.MyResourceNotFoundException;

/**
 * Created by BMGTS on 23/03/2016.
 */
public final class RestPreConditions {

    public RestPreConditions() {
        throw new AssertionError();
    }

    /**
     * <T> in method declaration that signifies method uses generic type T
     * T indicates generic type T is return type
     * [final T reference] indicates *reference* is of generic type T
     **/
    public static <T> T checkNotNull(final T reference) {
        if (reference == null) {
            throw new MyResourceNotFoundException();
        }
        return reference;
    }

    /**
     * @param reference
     * @param <T>
     */
    public static <T extends IEntity> T checkRequestElementNotNull(final  T reference)   {
        return checkRequestElementNotNull(reference,null);

    }

    public static <T extends IEntity> T checkRequestElementNotNull(final T reference, final String message)  {
        if( null == reference ) {
            throw new MyBadRequestException(message);
        }
        return reference;
    }

    public static void checkRequestState(final boolean expression) {
        checkRequestState(expression, null);
    }

    private static void checkRequestState(final boolean expression, final String message) {
        if( !expression) {
            throw new MyConflictException(message);
        }
    }
}

