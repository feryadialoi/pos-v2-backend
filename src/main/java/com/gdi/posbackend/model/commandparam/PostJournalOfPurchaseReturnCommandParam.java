package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.entity.PurchaseReturn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/29/2021 3:53 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostJournalOfPurchaseReturnCommandParam implements CommandParam{
    private PurchaseReturn purchaseReturn;
}
