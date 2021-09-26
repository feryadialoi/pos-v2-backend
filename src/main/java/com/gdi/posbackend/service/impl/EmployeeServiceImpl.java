package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Employee;
import com.gdi.posbackend.entity.enums.EmployeeStatus;
import com.gdi.posbackend.mapper.EmployeeMapper;
import com.gdi.posbackend.model.criteria.EmployeeCriteria;
import com.gdi.posbackend.model.request.CreateEmployeeRequest;
import com.gdi.posbackend.model.request.UpdateEmployeeRequest;
import com.gdi.posbackend.model.response.EmployeeResponse;
import com.gdi.posbackend.repository.EmployeeRepository;
import com.gdi.posbackend.service.CompanyService;
import com.gdi.posbackend.service.EmployeeService;
import com.gdi.posbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.gdi.posbackend.specification.EmployeeSpecification.*;

/**
 * @author Feryadialoi
 * @date 9/13/2021 1:48 AM
 */
@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserService userService;
    private final CompanyService companyService;
    private final EmployeeMapper employeeMapper;

    @Override
    public Page<EmployeeResponse> getEmployees(EmployeeCriteria employeeCriteria, Pageable pageable) {

        Specification<Employee> specification = Specification.where(null);

        if (employeeCriteria.getUserName() != null)
            specification = specification.or(userNameIsLike(employeeCriteria.getUserName()));

        if (employeeCriteria.getCompanyName() != null)
            specification = specification.or(companyNameIsLike(employeeCriteria.getCompanyName()));

        if (employeeCriteria.getName() != null)
            specification = specification.or(nameIsLike(employeeCriteria.getName()));

        if (employeeCriteria.getNationalIdentificationNumber() != null)
            specification = specification.or(nationalIdentificationNumberIsLike(employeeCriteria.getNationalIdentificationNumber()));

        if (employeeCriteria.getPlaceOfBirth() != null)
            specification = specification.or(placeOfBirthIsLike(employeeCriteria.getPlaceOfBirth()));

        if (employeeCriteria.getDateOfBirth() != null)
            specification = specification.or(dateOfBirthIs(employeeCriteria.getDateOfBirth()));

        if (employeeCriteria.getAddress() != null)
            specification = specification.or(addressIsLike(employeeCriteria.getAddress()));

        if (employeeCriteria.getAddressInIdentityCard() != null)
            specification = specification.or(addressInIdentityCardIsLike(employeeCriteria.getAddressInIdentityCard()));

        if (employeeCriteria.getReligion() != null)
            specification = specification.or(religionIsLike(employeeCriteria.getReligion()));

        if (employeeCriteria.getEducation() != null)
            specification = specification.or(educationIsLike(employeeCriteria.getEducation()));

        if (employeeCriteria.getJoinDate() != null)
            specification = specification.or(joinDateIs(employeeCriteria.getJoinDate()));

        if (employeeCriteria.getPhone() != null)
            specification = specification.or(phoneIsLike(employeeCriteria.getPhone()));

        if (employeeCriteria.getPhone2() != null)
            specification = specification.or(phone2IsLike(employeeCriteria.getPhone2()));

        if (employeeCriteria.getEmail() != null)
            specification = specification.or(emailIsLike(employeeCriteria.getEmail()));

        if (employeeCriteria.getMarriage() != null)
            specification = specification.or(marriageIs(employeeCriteria.getMarriage()));

        if (employeeCriteria.getGender() != null)
            specification = specification.or(genderIs(employeeCriteria.getGender()));

        if (employeeCriteria.getTaxIdentificationNumber() != null)
            specification = specification.or(taxIdentificationNumberIsLike(employeeCriteria.getTaxIdentificationNumber()));

        if (employeeCriteria.getInsuranceAndSocialSecurity() != null)
            specification = specification.or(insuranceAndSocialSecurityIsLike(employeeCriteria.getInsuranceAndSocialSecurity()));

        if (employeeCriteria.getBankName() != null)
            specification = specification.or(bankNameIsLike(employeeCriteria.getBankName()));

        if (employeeCriteria.getBankAccountNumber() != null)
            specification = specification.or(bankAccountNumberIsLike(employeeCriteria.getBankAccountNumber()));

        if (employeeCriteria.getStatus() != null)
            specification = specification.or(statusIs(employeeCriteria.getStatus()));

        return employeeRepository.findAll(specification, pageable).map(employeeMapper::mapEmployeeToEmployeeResponse);
    }

    @Override
    public EmployeeResponse getEmployee(String employeeId) {
        return employeeMapper.mapEmployeeToEmployeeResponse(findEmployeeByIdOrThrowNotFound(employeeId));
    }

    @Override
    public EmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = new Employee();
        employee.setName(createEmployeeRequest.getName());
        employee.setUser(userService.findUserByIdOrThrowNotFound(createEmployeeRequest.getUserId()));
        employee.setCompany(companyService.findCompanyByIdOrThrowNotFound(createEmployeeRequest.getCompanyId()));
        employee.setNationalIdentificationNumber(createEmployeeRequest.getNationalIdentificationNumber());
        employee.setPlaceOfBirth(createEmployeeRequest.getPlaceOfBirth());
        employee.setDateOfBirth(createEmployeeRequest.getDateOfBirth());
        employee.setAddress(createEmployeeRequest.getAddress());
        employee.setAddressInIdentityCard(createEmployeeRequest.getAddressInIdentityCard());
        employee.setReligion(createEmployeeRequest.getReligion());
        employee.setEducation(createEmployeeRequest.getEducation());
        employee.setJoinDate(createEmployeeRequest.getJoinDate());
        employee.setPhone(createEmployeeRequest.getPhone());
        employee.setPhone2(createEmployeeRequest.getPhone2());
        employee.setEmail(createEmployeeRequest.getEmail());
        employee.setOfficeEmail(createEmployeeRequest.getOfficeEmail());
        employee.setMarriage(createEmployeeRequest.getMarriage());
        employee.setGender(createEmployeeRequest.getGender());
        employee.setTaxIdentificationNumber(createEmployeeRequest.getTaxIdentificationNumber());
        employee.setInsuranceAndSocialSecurity(createEmployeeRequest.getInsuranceAndSocialSecurity());
        employee.setBankName(createEmployeeRequest.getBankName());
        employee.setBankBranch(createEmployeeRequest.getBankBranch());
        employee.setBankAccountNumber(createEmployeeRequest.getBankAccountNumber());
        employee.setStatus(createEmployeeRequest.getStatus());
        employee.setActive(createEmployeeRequest.getActive());


        employee = employeeRepository.save(employee);

        return employeeMapper.mapEmployeeToEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse updateEmployee(String employeeId, UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = findEmployeeByIdOrThrowNotFound(employeeId);

        if (updateEmployeeRequest.getName() != null)
            employee.setName(updateEmployeeRequest.getName());

        if (updateEmployeeRequest.getUserId() != null)
            employee.setUser(userService.findUserByIdOrThrowNotFound(updateEmployeeRequest.getUserId()));

        if (updateEmployeeRequest.getCompanyId() != null)
            employee.setCompany(companyService.findCompanyByIdOrThrowNotFound(updateEmployeeRequest.getCompanyId()));

        if (updateEmployeeRequest.getNationalIdentificationNumber() != null)
            employee.setNationalIdentificationNumber(updateEmployeeRequest.getNationalIdentificationNumber());

        if (updateEmployeeRequest.getPlaceOfBirth() != null)
            employee.setPlaceOfBirth(updateEmployeeRequest.getPlaceOfBirth());

        if (updateEmployeeRequest.getDateOfBirth() != null)
            employee.setDateOfBirth(updateEmployeeRequest.getDateOfBirth());

        if (updateEmployeeRequest.getAddress() != null)
            employee.setAddress(updateEmployeeRequest.getAddress());

        if (updateEmployeeRequest.getAddressInIdentityCard() != null)
            employee.setAddressInIdentityCard(updateEmployeeRequest.getAddressInIdentityCard());

        if (updateEmployeeRequest.getReligion() != null)
            employee.setReligion(updateEmployeeRequest.getReligion());

        if (updateEmployeeRequest.getEducation() != null)
            employee.setEducation(updateEmployeeRequest.getEducation());

        if (updateEmployeeRequest.getJoinDate() != null)
            employee.setJoinDate(updateEmployeeRequest.getJoinDate());

        if (updateEmployeeRequest.getPhone() != null)
            employee.setPhone(updateEmployeeRequest.getPhone());

        if (updateEmployeeRequest.getPhone2() != null)
            employee.setPhone2(updateEmployeeRequest.getPhone2());

        if (updateEmployeeRequest.getEmail() != null)
            employee.setEmail(updateEmployeeRequest.getEmail());

        if (updateEmployeeRequest.getOfficeEmail() != null)
            employee.setOfficeEmail(updateEmployeeRequest.getOfficeEmail());

        if (updateEmployeeRequest.getMarriage() != null)
            employee.setMarriage(updateEmployeeRequest.getMarriage());

        if (updateEmployeeRequest.getGender() != null)
            employee.setMarriage(updateEmployeeRequest.getMarriage());

        if (updateEmployeeRequest.getTaxIdentificationNumber() != null)
            employee.setTaxIdentificationNumber(updateEmployeeRequest.getTaxIdentificationNumber());

        if (updateEmployeeRequest.getInsuranceAndSocialSecurity() != null)
            employee.setInsuranceAndSocialSecurity(updateEmployeeRequest.getInsuranceAndSocialSecurity());

        if (updateEmployeeRequest.getBankName() != null)
            employee.setBankName(updateEmployeeRequest.getBankName());

        if (updateEmployeeRequest.getBankAccountNumber() != null)
            employee.setBankAccountNumber(updateEmployeeRequest.getBankAccountNumber());

        if (updateEmployeeRequest.getStatus() != null)
            employee.setStatus(updateEmployeeRequest.getStatus());

        employeeRepository.save(employee);

        return employeeMapper.mapEmployeeToEmployeeResponse(employee);
    }

    @Override
    public String deleteEmployee(String employeeId) {

        Employee employee = findEmployeeByIdOrThrowNotFound(employeeId);

        employeeRepository.delete(employee);

        return employeeId;
    }

    @Override
    public Employee findEmployeeByIdOrThrowNotFound(String employeeId) {
        return employeeRepository.findByIdOrThrowNotFound(employeeId);
    }
}
