package com.github.springbootlearn.service.impl;

import com.github.springbootlearn.dao.PermissionRepository;
import com.github.springbootlearn.model.Permission;
import com.github.springbootlearn.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {


    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getPermissionlist() {

        return permissionRepository.findAll();
    }
}
