package com.ugp.clone_ugp.services;

import com.ugp.clone_ugp.helpers.AddMissingPersonReq;
import com.ugp.clone_ugp.modules.MissingPerson;
import com.ugp.clone_ugp.repository.MissingPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class MissingPersonService {

    @Autowired
    MissingPersonRepository missingPersonRepository;

    @Autowired
    DataSavingService dataSavingService;


    public void addMissingPerson(AddMissingPersonReq missingPersonReq, MultipartFile file) throws IOException {

        MissingPerson missingPerson = MissingPerson.builder()
                .name(missingPersonReq.getName())
                .description(missingPersonReq.getDescription())
                .status(missingPersonReq.getStatus())
                .dateReported(new Date())
                .imgUrl(dataSavingService.saveAndGetUrl(file))
                .build();

        missingPersonRepository.save(missingPerson);
    }


    public void deleteMissingPerson(int id){
        MissingPerson missingPerson = missingPersonRepository.findById(id).orElseThrow();

        missingPersonRepository.delete(missingPerson);
    }

    public List<MissingPerson> getAllMissingPersons(){
        return missingPersonRepository.findAll();
    }


}
