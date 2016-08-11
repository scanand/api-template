package com.soagile.api.service.impl;

import com.soagile.api.common.persistence.service.AbstractService;
import com.soagile.api.persistence.dao.IPrincipalJpaDao;
import com.soagile.api.persistence.model.Principal;
import com.soagile.api.service.IPrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by BMGTS on 29/03/2016.
 */

@Service
@Transactional
public class PrincipalServiceImpl extends AbstractService<Principal> implements IPrincipalService {


    @Autowired
    private IPrincipalJpaDao dao;

    @Override
    public Principal findByName(String name) {
        return null;
    }

    @Override
    public Principal getCurrentPrincipal() {
        return null;
    }

    public IPrincipalJpaDao getDao() {
        return dao;
    }

    protected JpaSpecificationExecutor<Principal> getSpecificationExecutor() {
        return dao;
    }
}
