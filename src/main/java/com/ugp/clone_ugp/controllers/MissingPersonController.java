package com.ugp.clone_ugp.controllers;

import com.ugp.clone_ugp.helpers.AddMissingPersonReq;
import com.ugp.clone_ugp.modules.MissingPerson;
import com.ugp.clone_ugp.services.MissingPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/missingPerson/")
public class MissingPersonController {

    @Autowired
    MissingPersonService missingPersonService;


    @GetMapping("getAll")
    public ResponseEntity<List<MissingPerson>> getAllMissingPersons(){
        return ResponseEntity.ok(missingPersonService.getAllMissingPersons());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteMissingPerson(
            @PathVariable("id") Integer id
    ){
        missingPersonService.deleteMissingPerson(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("addMissingPerson")
    public ResponseEntity<Void> addMissingPerson(
            @ModelAttribute AddMissingPersonReq missingPersonReq,
            @RequestPart("file")MultipartFile file
            ){

        try {
            missingPersonService.addMissingPerson(missingPersonReq,file);
        } catch (IOException e) {
            log.info("Error adding the Missing person:  {}", e);
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }

}
