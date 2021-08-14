package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.ProductCriteria;
import com.gdi.posbackend.model.request.CreateProductRequest;
import com.gdi.posbackend.model.request.UpdateProductRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.model.response.ProductResponse;
import com.gdi.posbackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:02 AM
 */
@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController extends BaseController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProductResponse>, Object>> getProducts(ProductCriteria productCriteria, Pageable pageable) {
        return response("get products success",
                productService.getProducts(productCriteria, pageable)
        );
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<DetailedProductResponse, Object>> getProduct(@PathVariable(name = "productId") String productId) {
        return response("get product success",
                productService.getProduct(productId)
        );
    }

//    @PostMapping
//    public ResponseEntity<ApiResponse<DetailedProductResponse, Object>> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
//        return response("create product success",
//                productService.createProduct(createProductRequest)
//        );
//    }

    @PostMapping
    public Object createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {

        return response("create product success",
                productService.createProduct(createProductRequest)
        );
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ApiResponse<DetailedProductResponse, Object>> updateProduct(@PathVariable(name = "productId") String productId,
                                                                                      @Valid @RequestBody UpdateProductRequest updateProductRequest) {
        return response("update product success",
                productService.updateProduct(productId, updateProductRequest)
        );
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse<Object, Object>> deleteProduct(@PathVariable(name = "productId") String productId) {
        return response("delete product success",
                productService.deleteProduct(productId)
        );
    }

}
