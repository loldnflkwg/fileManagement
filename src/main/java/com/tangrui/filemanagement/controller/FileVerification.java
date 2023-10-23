package com.tangrui.filemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;


@Controller
@RequestMapping("/FileVerification")
public class FileVerification {

    @PostMapping("/Duplication")
    Object verificationFileDuplication(MultipartFile multipartFile){
        try {
            //return walk(new File(multipartFile.getInputStream()),);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    static ArrayList<String> result;
    public static ArrayList walk(File file,String regex){
        for (File f:file.listFiles()) {
            if(f.isDirectory()){
                walk(f,regex);
            }else {
                if(f.getName().matches(regex)){
                    result.add(f.getName());
                }
            }
        }
        return result;
    }
    public static long getFolderSize(File folder) {
        long size = 0;
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else {
                    size += getFolderSize(file);
                }
            }
        }
        return size;
    }
}
