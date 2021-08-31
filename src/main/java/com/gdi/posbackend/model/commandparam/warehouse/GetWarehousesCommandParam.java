package com.gdi.posbackend.model.commandparam.warehouse;

import com.gdi.posbackend.model.commandparam.CommandParam;
import com.gdi.posbackend.model.criteria.WarehouseCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/5/2021 12:04 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetWarehousesCommandParam implements CommandParam {
    private WarehouseCriteria warehouseCriteria;
    private Pageable pageable;
}
