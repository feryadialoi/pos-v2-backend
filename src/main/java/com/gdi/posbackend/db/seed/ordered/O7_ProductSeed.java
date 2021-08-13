package com.gdi.posbackend.db.seed.ordered;

import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.entity.Unit;
import com.gdi.posbackend.entity.UnitConversion;
import com.gdi.posbackend.entity.enums.ProductDefaultUnit;
import com.gdi.posbackend.repository.CategoryRepository;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.repository.UnitConversionRepository;
import com.gdi.posbackend.repository.UnitRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:59 AM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class O7_ProductSeed implements ApplicationListener<ApplicationReadyEvent>, Ordered {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UnitRepository unitRepository;
    private final UnitConversionRepository unitConversionRepository;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class ProductDummyData {
        private String code;
        private String name;
        private Type type;
        private BigDecimal price;
        private Integer quantity;
    }

    private enum Type {
        PACK, CUP
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        long productCount = productRepository.count();
        log.info("product count {}", productCount);
        if (productCount == 0) {
            insertProduct();
            log.info("seed data product success");
        } else {
            log.info("no need to seed product data");
        }
    }

    private void insertProduct() {
        List<ProductDummyData> productDummyDataList = Arrays.asList(
                new ProductDummyData("INDOMIE-001", "Indomie Mi Goreng", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-002", "Indomie Mi Goreng Hot & Spicy", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-003", "Indomie Mi Goreng Barbeque Chicken Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-004", "Indomie Mi Goreng Satay Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-005", "Indomie Mi Goreng Rendang Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-006", "Indomie Mi Goreng Iga Penyet Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-007", "Indomie Mi Goreng Cabe Ijo Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-008", "Indomie Mi Goreng Soto", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-009", "Indomie Special Fried Curly Noodles", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-010", "Indomie Curly Noodles BBQ Chicken Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-011", "Indomie Mi Goreng Jumbo", Type.PACK, new BigDecimal("4000"), 100),
                new ProductDummyData("INDOMIE-012", "Indomie Mi Goreng Barbeque Chicken Flavour Jumbo", Type.PACK, new BigDecimal("4000"), 100),
                new ProductDummyData("INDOMIE-013", "Indomie Mi Goreng 5S", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-014", "Indomie Mi Goreng 10S", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-015", "Indomie Cup Mi Goreng", Type.CUP, new BigDecimal("5000"), 100),
                new ProductDummyData("INDOMIE-016", "Indomie Cup Mi Goreng Barbeque Chicken Flavour", Type.CUP, new BigDecimal("5000"), 100),
                new ProductDummyData("INDOMIE-017", "Indomie Chicken Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-018", "Indomie Special Chicken Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-019", "Indomie Chicken Curry Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-020", "Indomie Kakaruk Chicken Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-021", "Indomie Vegetable Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-022", "Indomie Shrimp Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-023", "Indomie Onion Chicken Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-024", "Indomie Beef Flavour", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-025", "Indomie Soto Special", Type.PACK, new BigDecimal("3000"), 100),
                new ProductDummyData("INDOMIE-026", "Indomie Cup Chicken Flavour", Type.CUP, new BigDecimal("5000"), 100),
                new ProductDummyData("INDOMIE-027", "Indomie Cup Soto Flavour", Type.CUP, new BigDecimal("5000"), 100),
                new ProductDummyData("INDOMIE-028", "Indomie Cup Beef Flavour", Type.CUP, new BigDecimal("5000"), 100),
                new ProductDummyData("INDOMIE-029", "Indomie Cup Chicken Curly Flavour", Type.CUP, new BigDecimal("5000"), 100)
        );
        /**
         * create product
         * set category
         * set units
         * set price
         * set unit conversion
         */


        Optional<Category> optionalCategory = categoryRepository.findByNameIgnoreCase("Makanan");
        Optional<Unit> optionalDus = unitRepository.findByNameIgnoreCase("Dus");
        Optional<Unit> optionalBungkus = unitRepository.findByNameIgnoreCase("Bungkus");

        log.info("optionalCategory {}", optionalCategory.isPresent());
        log.info("optionalDus {}", optionalDus.isPresent());
        log.info("optionalBungkus {}", optionalBungkus.isPresent());

        if (optionalCategory.isPresent() && optionalDus.isPresent() && optionalBungkus.isPresent()) {
            Category category = optionalCategory.get();
            Unit dus = optionalDus.get();
            Unit bungkus = optionalBungkus.get();

            for (ProductDummyData productDummyData : productDummyDataList) {
                Product product = new Product();
                product.setName(productDummyData.getName());
                product.setCode(productDummyData.getCode());
                product.setCategory(category);

                product.setDefaultUnit(ProductDefaultUnit.MEDIUM);
                product.setUnitMedium(dus);
                product.setUnitSmall(bungkus);

                product.setUnitMediumPrice(getUnitMediumPrice(productDummyData));
                product.setUnitSmallPrice(productDummyData.getPrice());

                UnitConversion unitConversion = new UnitConversion(product, dus, getUnitConversionMultiplier(productDummyData), bungkus);
                product.setUnitConversions(List.of(unitConversion));
                product.setStock(BigDecimal.ZERO);
                product.setMinimumStock(BigDecimal.ZERO);

                productRepository.save(product);
            }

        } else {
            if (optionalCategory.isEmpty()) log.info("category not found");
            if (optionalDus.isEmpty()) log.info("dus not found");
            if (optionalBungkus.isEmpty()) log.info("bungkus not found");
        }
    }

    private BigDecimal getUnitMediumPrice(ProductDummyData productDummyData) {
        if (productDummyData.getPrice().compareTo(BigDecimal.valueOf(3000)) == 0) {
            return productDummyData.getPrice().multiply(BigDecimal.valueOf(40)).subtract(BigDecimal.valueOf(20000));
        } else if (productDummyData.getPrice().compareTo(BigDecimal.valueOf(4000)) == 0) {
            return productDummyData.getPrice().multiply(BigDecimal.valueOf(24)).subtract(BigDecimal.valueOf(20000));
        } else if (productDummyData.getPrice().compareTo(BigDecimal.valueOf(5000)) == 0) {
            return productDummyData.getPrice().multiply(BigDecimal.valueOf(12)).subtract(BigDecimal.valueOf(20000));
        } else {
            throw new RuntimeException("no match type");
        }
    }

    private BigDecimal getUnitConversionMultiplier(ProductDummyData productDummyData) {

        if (productDummyData.getPrice().compareTo(BigDecimal.valueOf(3000)) == 0) {
            return BigDecimal.valueOf(40);
        } else if (productDummyData.getPrice().compareTo(BigDecimal.valueOf(4000)) == 0) {
            return BigDecimal.valueOf(24);
        } else if (productDummyData.getPrice().compareTo(BigDecimal.valueOf(5000)) == 0) {
            return BigDecimal.valueOf(12);
        } else {
            throw new RuntimeException("no match type");
        }

    }

    @Override
    public int getOrder() {
        return 7;
    }
}
