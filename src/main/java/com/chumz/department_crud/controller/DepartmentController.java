package com.chumz.department_crud.controller;

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
    @GetMapping("/departments")
    public DepartmentEntity saveDepartment(@Validated @RequestBody DepartmentEntity departmentEntity) {
        return departmentService.saveDepartment(departmentEntity);
    }

    // Read operation
    @GetMapping("/departments/{id}")
    public List<DepartmentEntity> fetchDepartmentList() {
        return departmentService.fetchDepartList();
    }

    // update operation
    @PutMapping("/departments/{id}")
    public DepartmentEntity updateDepartment(@RequestBody DepartmentEntity departmentEntity, @PathVariable("id") Long departmentId) {
        return departmentService.updateDepartment(departmentEntity, departmentId);
    }

    //delete operation
    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        return "Deleted successfully";
    }
}
