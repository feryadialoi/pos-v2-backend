package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.exception.AdjustmentJournalNotFoundException;
import com.gdi.posbackend.model.request.CreateAdjustmentJournalRequest;
import com.gdi.posbackend.service.AdjustmentJournalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 9/5/2021 9:00 PM
 */
@RestController
@RequestMapping("/api/v1/adjustment-journals")
@AllArgsConstructor
public class AdjustmentJournalController extends BaseController {

    private final AdjustmentJournalService adjustmentJournalService;

    @GetMapping
    public Object getAdjustmentJournals() {
        throw new AdjustmentJournalNotFoundException("random throw error");
    }

    @PostMapping
    public Object createAdjustmentJournal(@Valid @RequestBody CreateAdjustmentJournalRequest createAdjustmentJournalRequest) {
        return response("create adjustment journal success", adjustmentJournalService.createAdjustmentJournal(createAdjustmentJournalRequest));
    }


}
