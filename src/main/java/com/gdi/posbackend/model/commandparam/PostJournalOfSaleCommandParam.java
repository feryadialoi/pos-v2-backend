package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/29/2021 2:54 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostJournalOfSaleCommandParam implements CommandParam {
    private Sale sale;
}
