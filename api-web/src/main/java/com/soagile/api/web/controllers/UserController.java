package com.soagile.api.web.controllers;

import com.soagile.api.common.web.controller.AbstractController;
import com.soagile.api.common.web.controller.ISortingController;
import com.soagile.api.common.web.exception.MyResourceNotFoundException;
import com.soagile.api.service.IUserService;
import com.soagile.api.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.soagile.api.web.util.UmMappings.USERS;


/***
 *
 *
 */
@Controller
@RequestMapping(value = USERS)
public class UserController extends AbstractController<UserDto> implements ISortingController<UserDto> {

    @Autowired
    private IUserService service;

    public UserController() {
        super(UserDto.class);
    }

    public UserController(Class<UserDto> clazzToSet) {
        super(clazzToSet);
    }

    protected final IUserService getService() {
        return service;
    }

    @Override
    public List<UserDto> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        return null;
    }

    @Override
    public List<UserDto> findAllPaginated(int page, int size) {
        return null;
    }

    @Override
    public List<UserDto> findAllSorted(String sortBy, String sortOrder) {
        return null;
    }

    /**
     * @param request
     * @return
     */
    @Override
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> findAll(HttpServletRequest request) {
        if (request.getParameterNames().hasMoreElements()) {
            throw new MyResourceNotFoundException();
        }
        return getService().findAll();
    }

    public UserDto findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid final UserDto resource) {
        createInternal(resource);
    }
}
