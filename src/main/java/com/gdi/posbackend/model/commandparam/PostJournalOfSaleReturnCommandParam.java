package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.entity.SaleReturn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/29/2021 3:55 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostJournalOfSaleReturnCommandParam implements CommandParam{
    private SaleReturn saleReturn;
}
