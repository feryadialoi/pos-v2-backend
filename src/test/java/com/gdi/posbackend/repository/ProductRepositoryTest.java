package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Brand;
import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Feryadialoi
 * @date 9/6/2021 10:18 AM
 */
@Slf4j
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class DummyProduct {
        private String name;
        private BigDecimal price;
        private String category;
        private String imageUrl;
    }

    @Test
    void insertData() {
        List<DummyProduct> dummyProducts = List.of(
                new DummyProduct("logitech g501 hero gaming mouse", BigDecimal.valueOf(1199000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/non-braid/hyjal-g502-hero/g502-hero-gallery-1-nb.png?v=1"),
                new DummyProduct("logitech pro x superlight gaming mouse", BigDecimal.valueOf(2299000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/pro-x-superlight/pro-x-superlight-black-gallery-1.png?v=1"),
                new DummyProduct("logitech g102 lightsync gaming mouse", BigDecimal.valueOf(379000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/refreshed-g203/g203-black-gallery-1.png?v=1"),
                new DummyProduct("logitech g604 lightspeed wireless gaming mouse", BigDecimal.valueOf(1549000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g604/g604-gallery-1.png?v=1"),
                new DummyProduct("logitech g703 lightspeed wireless gaming mouse", BigDecimal.valueOf(1549000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g703/g703-gallery-1.png?v=1"),
                new DummyProduct("logitech g903 lightspeed wireless gaming mouse", BigDecimal.valueOf(2390000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g903/g903-gallery-1.png?v=1"),
                new DummyProduct("logitech g403 hero gaming mouse", BigDecimal.valueOf(1099000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/non-braid/g403/g403-wired-gallery-1-nb.png?v=1"),
                new DummyProduct("logitech pro gaming mouse", BigDecimal.valueOf(1049000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/pro-gaming-mouse/plasma-hero-carbon-gallery-4.png?v=1"),
                new DummyProduct("logitech pro wireless gaming mouse", BigDecimal.valueOf(2390000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/pro-wireless-gaming-mouse/pro-wireless-carbon-gallery-1.png?v=1"),
                new DummyProduct("logitech g603 lightspeed wireless gaming mouse", BigDecimal.valueOf(1049000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g603/g603-gallery-1.png?v=1"),
                new DummyProduct("logitech g102 prodigy gaming mouse", BigDecimal.valueOf(379000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g203/g203-gallery-1.png?v=1"),
                new DummyProduct("logitech g402 hyperion fury ultra fast fps gaming mouse", BigDecimal.valueOf(729000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/products/gaming/mice/g402-hyperion-fury-fps-gaming-mouse/910-004068/g402-hyperion-fury-ultra-fast-fps-gaming-mouse30.png?v=1"),
                new DummyProduct("logitech g90 optical gaming mouse", BigDecimal.valueOf(299000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/products/gaming/mice/g90-optical-gaming-mouse/910-005018/g90-optical-gaming-mouse27.png?v=1"),
                new DummyProduct("logitech g304 lightspeed wireless gaming mouse", BigDecimal.valueOf(699000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g305/g305-gallery-1.png?v=1"),
                new DummyProduct("logitech g403 wired gaming mouse", BigDecimal.valueOf(1049000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/products/gaming/mice/g403-prodigy-wired-gaming-mouse/910-004825/g403-prodigy-gaming-mouse15.png?v=1"),
                new DummyProduct("logitech g302 daedalus prime moba gaming mouse", BigDecimal.valueOf(679000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g302/g302-gallery-1.png?v=1"),
                new DummyProduct("logitech g703 incredible lag-free wireless responsiveness gaming mouse", BigDecimal.valueOf(1549000), "mouse", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g703/g703-gallery-1.png?v=1"),

                new DummyProduct("logitech pro x keyboard", BigDecimal.valueOf(2290000), "keyboard", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/pro-x-keyboard/pro-x-keyboard-gallery-1.png?v=1"),
                new DummyProduct("logitech g813 lightsync rgb mechanical gaming keyboard", BigDecimal.valueOf(2999000), "keyboard", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g815/g815-gallery-1.png?v=1"),
                new DummyProduct("logitech g512 carbon rgb mechanical gaming keyboard", BigDecimal.valueOf(1790000), "keyboard", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/products/gaming/keyboards/g512-mechanical-gaming-keyboard/920-008762/g512-backlit-mechanical-gaming-keyboard-13.png?v=1"),
                new DummyProduct("logitech g613 wireless mechanical gaming keyboard", BigDecimal.valueOf(1490000), "keyboard", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g613/g613-gallery-1.png?v=1"),
                new DummyProduct("logitech g910 rgb mechanical gaming keyboard", BigDecimal.valueOf(2999000), "keyboard", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g910/g910-gallery-1.png?v=1"),
                new DummyProduct("logitech g213 prodigy rgb gaming keyboard", BigDecimal.valueOf(949000), "keyboard", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g213/g213-gallery-1.png?v=1"),
                new DummyProduct("logitech g413 mechanical backlit gaming keyboard", BigDecimal.valueOf(1290000), "keyboard", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/non-braid/g413-firebird/g413-gallery-1-nb.png?v=1"),

                new DummyProduct("logitech g335 wired gaming headset", BigDecimal.valueOf(899000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g335/g335-black-gallery-1.png?v=1"),
                new DummyProduct("logitech g333 gaming earphone", BigDecimal.valueOf(799000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g333-gaming-earphones/g333-black-gallery-1.png?v=1"),
                new DummyProduct("logitech g733 ligthspeed wireless rgb gaming headset", BigDecimal.valueOf(1899000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g733/gallery/g733-black-gallery-1.png?v=1"),
                new DummyProduct("logitech g pro x gaming headset", BigDecimal.valueOf(2399000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/pro-x/pro-headset-gallery-1.png?v=1"),
                new DummyProduct("logitech g pro headset pro gaming headset", BigDecimal.valueOf(1699000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/pro-x/pro-headset-gallery-1.png?v=1"),
                new DummyProduct("logitech g633s 7.1 surround sound lightsync gaming headset", BigDecimal.valueOf(2499000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g633s/g633s-gallery-1.png?v=1"),
                new DummyProduct("logitech g433 7.1 wired surround gaming headset", BigDecimal.valueOf(1599000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g433/g433-gallery-black-1.png?v=1"),
                new DummyProduct("logitech g431 7.1 surround sound wired gaming headset", BigDecimal.valueOf(1449000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g431/g431-gallery-1.png?v=1"),
                new DummyProduct("logitech g331 stereo gaming headset", BigDecimal.valueOf(999000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g331/g331-gallery-1.png?v=1"),
                new DummyProduct("logitech speaker x623 with subwoofer", BigDecimal.valueOf(2599000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/products/gaming/audio-video/speaker-system-z623/980-000403/speaker-system-z6235.png?v=1"),
                new DummyProduct("logitech pro gaming headset", BigDecimal.valueOf(1499000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/products/gaming/audio-video/pro-gaming-headset/981-000721/zarya-pro-gaming-headset8.png?v=1"),
                new DummyProduct("logitech g560 lightsync pc gaming speaker", BigDecimal.valueOf(3099000), "audio", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/gaming/en/products/g560/g560-gallery-1.png?v=1"),

                new DummyProduct("logitech hd pro webcam c920", BigDecimal.valueOf(2049000), "webcam", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/products/gaming/audio-video/hd-pro-webcam-c920/960-000764/c920-pro-hd-webcam-refresh65478.png?v=1"),
                new DummyProduct("logitech c922 pro stream webcam", BigDecimal.valueOf(2099000), "webcam", "https://resource.logitechg.com/e_trim/w_490,h_310,c_limit/c_lpad,ar_413:310,q_auto,f_auto,dpr_auto/d_transparent.gif/content/dam/products/gaming/audio-video/c922-pro-stream-webcam/960-001088/c922-pro-stream-webcam6.png?v=1")
        );

        Category categoryAudioKomputer = new Category("audio komputer");
        Category categoryMouseKomputer = new Category("mouse komputer");
        Category categoryKeyboardKomputer = new Category("keyboard komputer");
        Category categoryWebcamKomputer = new Category("webcam komputer");

        categoryAudioKomputer = categoryRepository.save(categoryAudioKomputer);
        categoryMouseKomputer = categoryRepository.save(categoryMouseKomputer);
        categoryKeyboardKomputer = categoryRepository.save(categoryKeyboardKomputer);
        categoryWebcamKomputer = categoryRepository.save(categoryWebcamKomputer);


        Unit unitPcs = new Unit("PCS");

        unitPcs = unitRepository.save(unitPcs);

        Brand brandLogitech = new Brand("Logitech");

        brandLogitech = brandRepository.save(brandLogitech);

        for (DummyProduct dummyProduct : dummyProducts) {
            Product product = new Product();
            product.setName(dummyProduct.name);
            product.setCode(dummyProduct.name);
            product.setImageUrl(dummyProduct.imageUrl);
            product.setBrand(brandLogitech);
            product.setCategory(Objects.equals(dummyProduct.category, "mouse")
                    ? categoryMouseKomputer
                    : Objects.equals(dummyProduct.category, "keyboard")
                    ? categoryKeyboardKomputer
                    : Objects.equals(dummyProduct.category, "audio")
                    ? categoryAudioKomputer
                    : categoryWebcamKomputer
            );
            product.setMinimumStock(BigDecimal.ZERO);
            product.setUnits(List.of(unitPcs));

            productRepository.save(product);
        }
        log.info("product insert success");

    }


}
