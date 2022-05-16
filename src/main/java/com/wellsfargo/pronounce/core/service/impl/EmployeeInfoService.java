package com.wellsfargo.pronounce.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.pronounce.core.data.dao.EmployeeInfoRepo;
import com.wellsfargo.pronounce.core.data.entity.EmployeeInfo;
import com.wellsfargo.pronounce.core.model.EmployeeInfoDto;
import com.wellsfargo.pronounce.core.service.IEmployeeInfoService;

@Service
public class EmployeeInfoService implements IEmployeeInfoService {
	
	@Autowired
	EmployeeInfoRepo repo;

    @Override
    public EmployeeInfoDto getEmployeeInfo(Long empId) {
        return mapToDto(repo.findById(empId).get());

    }

    @Override
    public EmployeeInfoDto saveEmployeeInfo(EmployeeInfoDto employeeInfo) {
    	EmployeeInfo emp = repo.findById(employeeInfo.getEmpId()).get();
    	emp.setNamePhoneme(employeeInfo.getNamePhoneme());
    	emp.setPronunciation(employeeInfo.getPronunciation());
    	return mapToDto(repo.save(emp));
    }

    @Override
    public List<EmployeeInfoDto> searchEmployee(String name) {
    	List<EmployeeInfoDto> empList = new ArrayList<EmployeeInfoDto>();
        repo.findByEmpNameContainingIgnoreCase(name).forEach(entity ->
        		empList.add(mapToDto(entity)));
        return empList;
    }
    
    private EmployeeInfoDto mapToDto(EmployeeInfo entity) {
    	EmployeeInfoDto dto = new EmployeeInfoDto();
    	dto.setEmpId(entity.getEmpId());
    	dto.setEmpName(entity.getEmpName());
    	dto.setLegalName(entity.getLegalName());
    	dto.setNamePhoneme(entity.getNamePhoneme());
    	dto.setPronunciation(entity.getPronunciation());
    	dto.setRole(entity.getRole());
    	dto.setTitle(entity.getTitle());
    	
    	return dto;
    }

}	