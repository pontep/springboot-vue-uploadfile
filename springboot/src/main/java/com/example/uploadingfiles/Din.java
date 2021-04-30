package com.example.uploadingfiles;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Din {
    public static void main(String args[]){
//        String originalString = "pontep";
//        String sha256hex = Hashing.sha256()
//                .hashString(originalString, StandardCharsets.UTF_8)
//                .toString();
//        System.out.println("originalString = " + originalString);
//        System.out.println("Hash = " + sha256hex);
        int hash = Objects.hash("pontep");
        System.out.println(hash);
    }
}
