package com.soagile.api.service.impl;

import com.google.common.collect.Lists;
import com.soagile.api.persistence.model.Principal;
import com.soagile.api.service.IPrincipalService;
import com.soagile.api.service.IUserService;
import com.soagile.api.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *
 */

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IPrincipalService principalService;


    @Override
    public UserDto getCurrentUser() {
        final Principal principal = principalService.getCurrentPrincipal();
        return new UserDto(principal);
    }

    @Override
    public UserDto findByName(String name) {
        return null;
    }

    @Override
    public Page<UserDto> findAllPaginatedAndSortedRaw(int page, int size, String sortBy, String sortOrder) {
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public UserDto findOne(long id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {

        final List<Principal> principals = principalService.findAll();
        final List<UserDto> userDtos = principals.stream().map(this::convert).collect(Collectors.toList());
        return Lists.newArrayList(userDtos);
    }

    @Override
    public UserDto create(final UserDto dto) {
        final Principal newPrincipal = new Principal(dto);
        principalService.create(newPrincipal);
        dto.setId(newPrincipal.getId());
        return dto;
    }

    private final UserDto convert(final Principal principal) {
        return new UserDto(principal);
    }
}