package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/29/2021 2:52 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostJournalOfPurchaseCommandParam implements CommandParam {
    private Purchase purchase;

}
