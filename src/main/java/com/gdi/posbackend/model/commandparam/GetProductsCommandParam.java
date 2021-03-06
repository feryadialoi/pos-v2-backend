package com.gdi.posbackend.model.commandparam;

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
public class GetProductsCommandParam implements CommandParam {
    private ProductCriteria productCriteria;
    private Pageable pageable;
}
