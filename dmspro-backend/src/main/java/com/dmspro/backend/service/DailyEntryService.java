package com.dmspro.backend.service;

import com.dmspro.backend.dto.DailyEntryRequest;
import com.dmspro.backend.model.Customer;
import com.dmspro.backend.model.DailyEntry;
import com.dmspro.backend.repository.CustomerRepository;
import com.dmspro.backend.repository.DailyEntryRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

@Service
public class DailyEntryService {

    @Autowired
    private DailyEntryRepository entryRepo;

    @Autowired
    private CustomerRepository customerRepo;

    public DailyEntry saveEntry(DailyEntryRequest request) throws Exception {
        Customer customer = customerRepo.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        DailyEntry entry = new DailyEntry();
        entry.setCustomer(customer);
        entry.setMorningMilk(request.getMorningMilk());
        entry.setEveningMilk(request.getEveningMilk());
        entry.setRate(request.getRate());
        entry.setFat(request.getFat());
        entry.setSnf(request.getSnf());
        entry.setDate(LocalDate.now().toString());

        DailyEntry saved = entryRepo.save(entry);
        generatePdfForCustomer(customer);
        return saved;
    }

    public List<DailyEntry> getEntriesByCustomer(Long customerId) {
        return entryRepo.findByCustomerId(customerId);
    }

    public void generatePdfForCustomer(Customer customer) throws Exception {
        List<DailyEntry> entries = entryRepo.findByCustomerId(customer.getId());

        File dir = new File("pdf-reports");
        if (!dir.exists()) dir.mkdirs();

        String filePath = "pdf-reports/" + customer.getName().replace(" ", "_") + "_" + customer.getId() + ".pdf";

        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(filePath));
        doc.open();

        doc.add(new Paragraph("Milk Report - " + customer.getName(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
        doc.add(new Paragraph("Village: " + customer.getVillage()));
        doc.add(new Paragraph(" "));

        for (DailyEntry e : entries) {
            doc.add(new Paragraph("Date: " + e.getDate()));
            doc.add(new Paragraph("Morning: " + e.getMorningMilk() + " L | Evening: " + e.getEveningMilk() + " L"));
            doc.add(new Paragraph("Rate: ₹" + e.getRate() + " | Fat: " + e.getFat() + "% | SNF: " + e.getSnf() + "%"));
            doc.add(new Paragraph("---------------------------------------------"));
        }

        doc.close();
    }
}
