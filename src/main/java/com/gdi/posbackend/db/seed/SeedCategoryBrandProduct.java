package com.gdi.posbackend.db.seed;

import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.repository.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:59 AM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class SeedCategoryBrandProduct {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final UnitRepository unitRepository;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class ProductDummyData {
        private Type type;
        private String code;
        private String name;
        private BigDecimal price;
        private Integer quantity;
    }

    private enum Type {
        PACK, CUP
    }

    public void seed() {
        long productCount = productRepository.count();
        long categoryCount = categoryRepository.count();
        long brandCount = brandRepository.count();

        log.info("product count {}", productCount);
        if (productCount == 0) {
            insertProduct();
            log.info("seed data product success");
        } else {
            log.info("no need to seed product data");
        }
    }

    private void insertProduct() {
        // @formatter:off
        List<ProductDummyData> productDummyDataList = Arrays.asList(
                new ProductDummyData(Type.PACK, "INDOMIE-001", "Indomie Mi Goreng",                                new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-002", "Indomie Mi Goreng Hot & Spicy",                    new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-003", "Indomie Mi Goreng Barbeque Chicken Flavour",       new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-004", "Indomie Mi Goreng Satay Flavour",                  new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-005", "Indomie Mi Goreng Rendang Flavour",                new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-006", "Indomie Mi Goreng Iga Penyet Flavour",             new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-007", "Indomie Mi Goreng Cabe Ijo Flavour",               new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-008", "Indomie Mi Goreng Soto",                           new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-009", "Indomie Special Fried Curly Noodles",              new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-010", "Indomie Curly Noodles BBQ Chicken Flavour",        new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-011", "Indomie Mi Goreng Jumbo",                          new BigDecimal("4000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-012", "Indomie Mi Goreng Barbeque Chicken Flavour Jumbo", new BigDecimal("4000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-013", "Indomie Mi Goreng 5S",                             new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-014", "Indomie Mi Goreng 10S",                            new BigDecimal("3000"), 100),
                new ProductDummyData(Type.CUP,  "INDOMIE-015", "Indomie Cup Mi Goreng",                            new BigDecimal("5000"), 100),
                new ProductDummyData(Type.CUP,  "INDOMIE-016", "Indomie Cup Mi Goreng Barbeque Chicken Flavour",   new BigDecimal("5000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-017", "Indomie Chicken Flavour",                          new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-018", "Indomie Special Chicken Flavour",                  new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-019", "Indomie Chicken Curry Flavour",                    new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-020", "Indomie Kakaruk Chicken Flavour",                  new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-021", "Indomie Vegetable Flavour",                        new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-022", "Indomie Shrimp Flavour",                           new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-023", "Indomie Onion Chicken Flavour",                    new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-024", "Indomie Beef Flavour",                             new BigDecimal("3000"), 100),
                new ProductDummyData(Type.PACK, "INDOMIE-025", "Indomie Soto Special",                             new BigDecimal("3000"), 100),
                new ProductDummyData(Type.CUP,  "INDOMIE-026", "Indomie Cup Chicken Flavour",                      new BigDecimal("5000"), 100),
                new ProductDummyData(Type.CUP,  "INDOMIE-027", "Indomie Cup Soto Flavour",                         new BigDecimal("5000"), 100),
                new ProductDummyData(Type.CUP,  "INDOMIE-028", "Indomie Cup Beef Flavour",                         new BigDecimal("5000"), 100),
                new ProductDummyData(Type.CUP,  "INDOMIE-029", "Indomie Cup Chicken Curly Flavour",                new BigDecimal("5000"), 100)
        );
        // @formatter:on


        Brand brand = getBrand("Indomie");
        Category category = getCategory("Makanan");
        Unit dus = getUnit("Dus");
        Unit bungkus = getUnit("Bungkus");
        Unit cup = getUnit("Cup");

        for (ProductDummyData productDummyData : productDummyDataList) {
            createProduct(productDummyData, category, brand, dus, bungkus, cup);
        }


    }

    private void createProduct(ProductDummyData productDummyData, Category category, Brand brand, Unit dus, Unit bungkus, Unit cup) {

        Product product = new Product();
        product.setName(productDummyData.getName().trim());
        product.setCode(productDummyData.getCode());
        product.setCategory(category);
        product.setBrand(brand);
        product.setUnits(getUnits(productDummyData.getType(), dus, bungkus, cup));
        product.setUnitConversions(getUnitConversions(productDummyData.getType(), product, dus, bungkus, cup));
        product.setStock(BigDecimal.ZERO);
        product.setMinimumStock(BigDecimal.ZERO);
        product.setIdempotentKey(UUID.randomUUID().toString());

        productRepository.save(product);
    }

    private List<UnitConversion> getUnitConversions(Type type, Product product, Unit dus, Unit bungkus, Unit cup) {
        if (type == Type.PACK) {
            return List.of(UnitConversion.builder()
                    .fromUnit(dus)
                    .multiplier(BigDecimal.valueOf(40))
                    .toUnit(bungkus)
                    .product(product)
                    .build());
        } else {
            return List.of(UnitConversion.builder()
                    .fromUnit(dus)
                    .multiplier(BigDecimal.valueOf(24))
                    .toUnit(cup)
                    .product(product)
                    .build());
        }
    }

    private Brand getBrand(String name) {
        return brandRepository.findByName(name).orElseGet(() -> brandRepository.save(Brand
                .builder()
                .name(name)
                .build())
        );
    }

    private Category getCategory(String name) {
        return categoryRepository.findByName(name).orElseGet(() -> categoryRepository.save(Category
                .builder()
                .name(name)
                .build())
        );
    }

    private Unit getUnit(String name) {
        return unitRepository.findByNameIgnoreCase(name).orElseGet(() -> unitRepository.save(Unit
                .builder()
                .name(name)
                .build())
        );
    }

    private List<Unit> getUnits(Type type, Unit dus, Unit bungkus, Unit cup) {
        if (type == Type.PACK) {
            return List.of(dus, bungkus);
        } else {
            return List.of(dus, cup);
        }
    }

}
