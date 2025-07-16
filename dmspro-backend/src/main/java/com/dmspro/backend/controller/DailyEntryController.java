package com.dmspro.backend.controller;

import com.dmspro.backend.model.DailyEntry;
import com.dmspro.backend.service.DailyEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/entries")
@CrossOrigin(origins = "*")
public class DailyEntryController {

    @Autowired
    private DailyEntryService entryService;

    @PostMapping
    public ResponseEntity<?> addEntry(@RequestBody DailyEntry request) {
        try {
            DailyEntry saved = entryService.saveEntry(request);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/by-customer/{customerId}")
    public List<DailyEntry> getByCustomer(@PathVariable Long customerId) {
        return entryService.getEntriesByCustomer(customerId);
    }

    @GetMapping("/pdf/{customerId}")
    public ResponseEntity<FileSystemResource> getCustomerPdf(@PathVariable Long customerId) {
        File dir = new File("pdf-reports");
        File[] files = dir.listFiles((d, name) -> name.endsWith(customerId + ".pdf"));

        if (files == null || files.length == 0) {
            return ResponseEntity.notFound().build();
        }

        File target = files[0];
        FileSystemResource resource = new FileSystemResource(target);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + target.getName())
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
