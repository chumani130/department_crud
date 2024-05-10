// DepartmentServiceImpl.java
package com.chumz.department_crud.service;

import com.chumz.department_crud.entity.DepartmentEntity;
import com.chumz.department_crud.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // save operation
    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    // read operation
    @Override
    public List<DepartmentEntity> fetchDepartList() {
        return (List<DepartmentEntity>) departmentRepository.findAll();
    }

    // update operation
    @Override
    public DepartmentEntity updateDepartment(DepartmentEntity departmentEntity, Long departmentId) {
        DepartmentEntity depDB = departmentRepository.findById(departmentId).orElse(null);

        if (Objects.nonNull(depDB)) {
            if (Objects.nonNull(departmentEntity.getDepartmentName()) && !"".equalsIgnoreCase(departmentEntity.getDepartmentName())) {
                depDB.setDepartmentName(departmentEntity.getDepartmentName());
            }
            if (Objects.nonNull(departmentEntity.getDepartmentAddress()) && !"".equalsIgnoreCase(departmentEntity.getDepartmentAddress())) {
                depDB.setDepartmentAddress(departmentEntity.getDepartmentAddress());
            }
            if (Objects.nonNull(departmentEntity.getDepartmentCode()) && !"".equalsIgnoreCase(departmentEntity.getDepartmentCode())) {
                depDB.setDepartmentCode(departmentEntity.getDepartmentCode());
            }
            return departmentRepository.save(depDB);
        }

        return null;
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
