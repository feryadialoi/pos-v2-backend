package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.entity.auth.User_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 9/14/2021 10:30 AM
 */
public class UserSpecification {
    public static Specification<User> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(User_.name)),
                SpecificationUtil.like(name)
        );
    }

    public static Specification<User> usernameIsLike(String username) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(User_.username)),
                SpecificationUtil.like(username)
        );
    }

    public static Specification<User> emailIsLike(String email) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(User_.email)),
                SpecificationUtil.like(email)
        );
    }


    public static Specification<User> phoneIsLike(String phone) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(User_.phone)),
                SpecificationUtil.like(phone)
        );
    }
}
