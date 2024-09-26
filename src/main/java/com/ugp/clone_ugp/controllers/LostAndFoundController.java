package com.ugp.clone_ugp.controllers;

import com.ugp.clone_ugp.helpers.AddLostAndFoundReq;
import com.ugp.clone_ugp.modules.LostAndFound;
import com.ugp.clone_ugp.services.LostAndFoundService;
import io.micrometer.common.lang.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/lostAndFound/")
public class LostAndFoundController {


    @Autowired
    LostAndFoundService lostAndFoundService;

    @GetMapping("getAll")
    public ResponseEntity<List<LostAndFound>> getAll(){
        return ResponseEntity.ok(lostAndFoundService.getAll());
    }

    @PostMapping("addLostAndFound")
    public ResponseEntity<Void> addLostAndFound(
            @RequestPart("file") MultipartFile file,
            @ModelAttribute AddLostAndFoundReq lostAndFoundReq
            ){
        try {
            lostAndFoundService.addLostAndFound(lostAndFoundReq, file);
        } catch (IOException e) {
            log.info("Error adding the lostandfoundt:  {}", e);
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteLostAndFound(
            @PathVariable("id") Integer id
    ){
        lostAndFoundService.deleteLostAndFound(id);
        return ResponseEntity.ok().build();
    }

}
