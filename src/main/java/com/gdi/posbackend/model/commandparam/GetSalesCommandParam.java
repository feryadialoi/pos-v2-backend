package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.criteria.SaleCriteria;
import lombok.*;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/15/2021 12:18 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSalesCommandParam implements CommandParam {
    private SaleCriteria saleCriteria;
    private Pageable pageable;
}
