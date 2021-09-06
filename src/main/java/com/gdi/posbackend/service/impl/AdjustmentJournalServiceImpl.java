package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.model.request.CreateAdjustmentJournalRequest;
import com.gdi.posbackend.model.response.AdjustmentJournalResponse;
import com.gdi.posbackend.service.AdjustmentJournalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 9/5/2021 9:32 PM
 */
@Service
@AllArgsConstructor
public class AdjustmentJournalServiceImpl implements AdjustmentJournalService {
    @Override
    public AdjustmentJournalResponse createAdjustmentJournal(CreateAdjustmentJournalRequest createAdjustmentJournalRequest) {
        return null;
    }
}
