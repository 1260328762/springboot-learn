package com.github.springbootlearn.dao;

import com.github.springbootlearn.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PermissionRepository extends JpaRepository<Permission,Long>{

}
