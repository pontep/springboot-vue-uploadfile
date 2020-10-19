package com.example.uploadingfiles.controller;

import com.example.uploadingfiles.Image;
import com.example.uploadingfiles.MessageResponse;
import com.example.uploadingfiles.repository.ImageRepository;
import com.example.uploadingfiles.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    StorageService storageService;

    @Autowired
    ImageRepository imageRepository;

    @PostMapping("/new")
    public ResponseEntity<?> handleFileUpload3(@RequestParam("file") MultipartFile file,
                                               @RequestParam("title") String title) {
        try {
//            Save file to backend storage.
            storageService.store(file);
//            New record in image table.
            Image image = new Image();
            image.setTitle(title); //set title.
            image.setFileName(file.getOriginalFilename()); //set fileName
            imageRepository.save(image); //save image to table.
//            this record will be -> ID: 1, title: Nature picture in SUT, Filename: suranives13.jpg
//            Return OK.
            String result = " successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.ok().body(result);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: " + ex.getMessage()));
        }
    }

    @GetMapping("/din")
    public String testDin(){
        return "Pontep Thaweesup";
    }
}
