package com.chumz.department_crud.service;

import com.chumz.department_crud.dto.DepartmentRequest;
import com.chumz.department_crud.dto.DepartmentResponse;
import com.chumz.department_crud.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {

    // save operation
    DepartmentResponse saveDepartment(DepartmentRequest departmentRequest);

    //Read operation
    List<DepartmentResponse> fetchDepartmentList();

    // Update operation
    DepartmentResponse updateDepartment(DepartmentRequest departmentRequest, Long departmentId);

    // Delete operation
    void deleteDepartmentById(Long departmentId);
}
