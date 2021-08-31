package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.JournalCriteria;
import com.gdi.posbackend.model.response.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:37 PM
 */
@RestController
@RequestMapping("/api/v1/journals")
@AllArgsConstructor
public class JournalController extends BaseController {

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Object>>> getJournals(JournalCriteria journalCriteria, Pageable pageable) {
        return response("get journals success", Page.empty());
    }

}
