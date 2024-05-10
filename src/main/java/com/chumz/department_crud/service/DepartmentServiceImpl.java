// DepartmentServiceImpl.java
package com.chumz.department_crud.service;

import com.chumz.department_crud.dto.DepartmentRequest;
import com.chumz.department_crud.dto.DepartmentResponse;
import com.chumz.department_crud.entity.DepartmentEntity;
import com.chumz.department_crud.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    // save operation
    @Override
    public DepartmentResponse saveDepartment(DepartmentRequest departmentRequest) {
        DepartmentEntity departmentEntity = departmentRepository.save(DepartmentEntity.builder()
                .code(departmentRequest.getCode())
                .name(departmentRequest.getName())
                .address(departmentRequest.getAddress()).build());


        return DepartmentResponse.builder().address(departmentEntity.getAddress())
                .name(departmentEntity.getName())
                .code(departmentEntity.getCode()).build();
    }



    // read operation
    @Override
    public List<DepartmentResponse> fetchDepartmentList() {
        List<DepartmentResponse> departmentResponses = new ArrayList<>();
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();

        for (int i = 0; i < departmentEntities.size(); i++) {
            DepartmentResponse departmentResponse = DepartmentResponse.builder().address(departmentEntities.get(i).getAddress())
                    .name(departmentEntities.get(i).getName())
                    .code(departmentEntities.get(i).getCode()).build();
            departmentResponses.add(departmentResponse);
        }

        return departmentResponses;
    }

    // update operation
    @Override
    public DepartmentResponse updateDepartment(DepartmentRequest departmentRequest, Long departmentId) {
            DepartmentEntity depDB = departmentRepository.findById(departmentId).get();

            if (Objects.nonNull(departmentRequest.getName()) && !"".equalsIgnoreCase(
                    departmentRequest.getName())) {
                depDB.setName(departmentRequest.getName());
            }
            if (Objects.nonNull(departmentRequest.getAddress()) && !"".equalsIgnoreCase(
                    departmentRequest.getAddress())) {
                depDB.setAddress(departmentRequest.getAddress());
            }
            if (Objects.nonNull(departmentRequest.getCode()) && !"".equalsIgnoreCase(
                    departmentRequest.getCode())) {
                depDB.setCode(departmentRequest.getCode());
            }
        DepartmentEntity departmentEntity = departmentRepository.save(depDB);
            return DepartmentResponse.builder().address(departmentEntity.getAddress())
                    .name(departmentEntity.getName())
                    .code(departmentEntity.getCode()).build();
        }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
