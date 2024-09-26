package com.ugp.clone_ugp.services;


import com.ugp.clone_ugp.helpers.AddReportReq;
import com.ugp.clone_ugp.modules.Report;
import com.ugp.clone_ugp.repository.LocationRepository;
import com.ugp.clone_ugp.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    DataSavingService dataSavingService;


    public void addReport(
            AddReportReq addReportReq,
            MultipartFile attachment
//            MultipartFile audio
    ) throws IOException {
        Report report = Report.builder()
                .category(addReportReq.getCategory())
                .details(addReportReq.getDetails())
                .type(addReportReq.getType())
                .firstname(addReportReq.getFirstname())
                .lastName(addReportReq.getLastname())
                .phone(addReportReq.getPhone())
                .latitude(addReportReq.getLatitude())
                .longitude(addReportReq.getLongitude())
                .attachment(attachment!=null? dataSavingService.saveAndGetUrl(attachment):null)
//                .audio(dataSavingService.saveAndGetUrl(audio))
                .build();

        reportRepository.save(report);
    }


    public void deleteReport(int id){
        Report report = reportRepository.findById(id).orElseThrow();
        reportRepository.delete(report);
    }

    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }
}
