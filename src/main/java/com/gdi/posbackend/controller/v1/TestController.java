package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.util.Translator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Feryadialoi
 * @date 9/27/2021 4:26 PM
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private Translator translator;

    /**
     * testing entity manager
     */
    @GetMapping("/entity-manager")
    public void testEntityManager() {
        final String name = "";
        var firstName = "";
        final var lastName = "";

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, "1cfd4aa1-19eb-4937-8089-3d0520bdc92b");

        log.info("{}", product);

        entityManager.getTransaction().commit();
    }

    @GetMapping("/lang")
    public String testLang() {
        return translator.getMessage("test.controller.greeting-user", new Object[]{"Feryadi"});
    }
}
