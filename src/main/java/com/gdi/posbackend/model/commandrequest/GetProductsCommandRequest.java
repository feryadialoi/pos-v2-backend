package com.gdi.posbackend.model.commandrequest;

import com.gdi.posbackend.model.criteria.ProductCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:35 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProductsCommandRequest implements CommandRequest {
    private ProductCriteria productCriteria;
    private Pageable pageable;
}
