package com.chumz.department_crud.controller;

import com.chumz.department_crud.dto.DepartmentRequest;
import com.chumz.department_crud.dto.DepartmentResponse;
import com.chumz.department_crud.entity.DepartmentEntity;
import com.chumz.department_crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // save operation
    @PostMapping("/departments")
    public DepartmentResponse saveDepartment(@Validated @RequestBody DepartmentRequest departmentRequest) {
        return departmentService.saveDepartment(departmentRequest);
    }

    // Read operation
    @GetMapping("/departments")
    public List<DepartmentResponse> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    // update operation
    @PutMapping("/departments/{id}")
    public DepartmentResponse updateDepartment(@RequestBody DepartmentRequest departmentRequest, @PathVariable("id") Long departmentId) {
        return departmentService.updateDepartment(departmentRequest, departmentId);
    }

    //delete operation
    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        return "Deleted successfully";
    }
}
