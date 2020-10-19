package com.example.uploadingfiles;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TestPayload {
    private String name;
    private MultipartFile image;
}
