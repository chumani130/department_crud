package com.chumz.department_crud.service;

import com.chumz.department_crud.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {

    // save operation
    DepartmentEntity saveDepartment(DepartmentEntity departmentEntity);

    //Read operation
    List<DepartmentEntity> fetchDepartList();

    // Update operation
    DepartmentEntity updateDepartment(DepartmentEntity departmentEntity, Long departmentId);

    // Delete operation
    void deleteDepartmentById(Long departmentId);
}
