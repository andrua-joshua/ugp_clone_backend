package com.ugp.clone_ugp.controllers;

import com.ugp.clone_ugp.helpers.AddReportReq;
import com.ugp.clone_ugp.modules.Report;
import com.ugp.clone_ugp.services.ReportService;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/report/")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("getAllReports")
    public ResponseEntity<List<Report>> getAllReports(){
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @PostMapping("addReport")
    public ResponseEntity<Void> addReport(
            @ModelAttribute AddReportReq reportReq,
            @RequestPart("attachment") @Nullable MultipartFile attachment
//            @RequestPart("audio") MultipartFile audio
            ){
        try {
            reportService.addReport(
                    reportReq,
                    attachment
//                    audio
            );
        } catch (IOException e) {
            log.info("Error adding the report:  {}", e);
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteReport(
            @PathVariable("id") Integer id
    ){
        reportService.deleteReport(id);
        return ResponseEntity.ok().build();
    }


}
