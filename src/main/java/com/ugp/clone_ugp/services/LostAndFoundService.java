package com.ugp.clone_ugp.services;

import com.ugp.clone_ugp.helpers.AddLostAndFoundReq;
import com.ugp.clone_ugp.modules.LostAndFound;
import com.ugp.clone_ugp.repository.LostAndFoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class LostAndFoundService {

    @Autowired
    LostAndFoundRepository lostAndFoundRepository;

    @Autowired
    DataSavingService dataSavingService;

    public void addLostAndFound(AddLostAndFoundReq lostAndFoundReq,
                                MultipartFile file) throws IOException {
        LostAndFound lostAndFound = LostAndFound.builder()
                .nameOnItem(lostAndFoundReq.getNameOnItem())
                .propertyType(lostAndFoundReq.getPropertyType())
                .location(lostAndFoundReq.getLocation())
                .category(lostAndFoundReq.getCategory())
                .storage(lostAndFoundReq.getStorage())
                .contactPerson(lostAndFoundReq.getContactPerson())
                .contactPhone(lostAndFoundReq.getContactPhone())
                .serialNo(lostAndFoundReq.getSerialNo())
                .status(lostAndFoundReq.getStatus())
                .details(lostAndFoundReq.getDetails())
                .imgUrl( dataSavingService.saveAndGetUrl(file))
                .dateFound(new Date())
                .build();


        lostAndFoundRepository.save(lostAndFound);
    }

    public void deleteLostAndFound(int id){
        LostAndFound lostAndFound = lostAndFoundRepository.findById(id).orElseThrow();
        lostAndFoundRepository.delete(lostAndFound);
    }


    public List<LostAndFound> getAll(){
        return lostAndFoundRepository.findAll();
    }

}
