package com.gdi.posbackend.service;

import com.gdi.posbackend.model.request.CreateAdjustmentJournalRequest;
import com.gdi.posbackend.model.response.AdjustmentJournalResponse;

/**
 * @author Feryadialoi
 * @date 9/5/2021 9:01 PM
 */
public interface AdjustmentJournalService {
    AdjustmentJournalResponse createAdjustmentJournal(CreateAdjustmentJournalRequest createAdjustmentJournalRequest);
}
