package com.dmspro.backend.controller;

import com.dmspro.backend.dto.DailyEntryRequest;
import com.dmspro.backend.model.DailyEntry;
import com.dmspro.backend.service.DailyEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entries")
@CrossOrigin
public class DailyEntryController {

    @Autowired
    private DailyEntryService dailyEntryService;

    @PostMapping
    public ResponseEntity<DailyEntry> createEntry(@RequestBody DailyEntryRequest request) throws Exception {
        DailyEntry saved = dailyEntryService.saveEntry(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<DailyEntry>> getEntries(@PathVariable Long customerId) {
        List<DailyEntry> entries = dailyEntryService.getEntriesByCustomer(customerId);
        return ResponseEntity.ok(entries);
    }
}
