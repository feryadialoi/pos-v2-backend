package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Company_;
import com.gdi.posbackend.entity.Employee;
import com.gdi.posbackend.entity.Employee_;
import com.gdi.posbackend.entity.auth.User_;
import com.gdi.posbackend.entity.enums.EmployeeStatus;
import com.gdi.posbackend.entity.enums.Gender;
import com.gdi.posbackend.entity.enums.Religion;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 9/13/2021 1:49 AM
 */
public class EmployeeSpecification {
    public static Specification<Employee> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.name)),
                SpecificationUtil.like(name)
        );
    }

    public static Specification<Employee> userNameIsLike(String userName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.user).get(User_.name)),
                SpecificationUtil.like(userName)
        );
    }

    public static Specification<Employee> companyNameIsLike(String companyName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.company).get(Company_.name)),
                SpecificationUtil.like(companyName)
        );
    }

    public static Specification<Employee> nationalIdentificationNumberIsLike(String nationalIdentificationNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.nationalIdentificationNumber)),
                SpecificationUtil.like(nationalIdentificationNumber)
        );
    }

    public static Specification<Employee> placeOfBirthIsLike(String placeOfBirth) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.placeOfBirth)),
                SpecificationUtil.like(placeOfBirth)
        );
    }

    public static Specification<Employee> addressIsLike(String address) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.address)),
                SpecificationUtil.like(address)
        );
    }

    public static Specification<Employee> addressInIdentityCardIsLike(String addressInIdentityCard) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.addressInIdentityCard)),
                SpecificationUtil.like(addressInIdentityCard)
        );
    }

    public static Specification<Employee> religionIsLike(Religion religion) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.religion.getName())),
                SpecificationUtil.like(religion.name())
        );
    }

    public static Specification<Employee> dateOfBirthIs(LocalDateTime dateOfBirth) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(Employee_.dateOfBirth), dateOfBirth);
    }

    public static Specification<Employee> joinDateIs(LocalDateTime joinDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(Employee_.joinDate), joinDate);
    }

    public static Specification<Employee> educationIsLike(String education) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.education)),
                SpecificationUtil.like(education)
        );
    }

    public static Specification<Employee> phoneIsLike(String phone) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.phone)),
                SpecificationUtil.like(phone)
        );
    }

    public static Specification<Employee> phone2IsLike(String phone2) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.phone2)),
                SpecificationUtil.like(phone2)
        );
    }

    public static Specification<Employee> emailIsLike(String email) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.email)),
                SpecificationUtil.like(email)
        );
    }

    public static Specification<Employee> marriageIs(Boolean marriage) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(Employee_.marriage), marriage);
    }

    public static Specification<Employee> genderIs(Gender gender) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(Employee_.gender), gender);
    }

    public static Specification<Employee> taxIdentificationNumberIsLike(String taxIdentificationNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.taxIdentificationNumber)),
                SpecificationUtil.like(taxIdentificationNumber)
        );
    }

    public static Specification<Employee> insuranceAndSocialSecurityIsLike(String insuranceAndSocialSecurity) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.insuranceAndSocialSecurity)),
                SpecificationUtil.like(insuranceAndSocialSecurity)
        );
    }

    public static Specification<Employee> bankNameIsLike(String bankName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.bankName)),
                SpecificationUtil.like(bankName)
        );
    }

    public static Specification<Employee> bankAccountNumberIsLike(String bankAccountNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Employee_.bankAccountNumber)),
                SpecificationUtil.like(bankAccountNumber)
        );
    }

    public static Specification<Employee> statusIs(EmployeeStatus status) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(Employee_.status), status);
    }


}


