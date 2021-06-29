package com.devjaws.instagramclone.domains.file.util;

import com.devjaws.instagramclone.configs.Const;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileUploder {
    public static void uploadProfile(MultipartFile file, String filename, String username) throws Exception{
        String path= Const.PATH_PROFILEPICTURE;
        File uploadPath=new File(path, username);
        if(uploadPath.exists()==false){
            uploadPath.mkdirs();
        }
        filename=file.getOriginalFilename();
        filename.substring(filename.lastIndexOf("\\")+1);
        File savefile=new File(uploadPath, filename);
        try{
            file.transferTo(savefile);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void uploadPost(MultipartFile file,String filename, String username) throws Exception{
        String path= Const.PATH_POSTPICTURE;
        File uploadPath=new File(path, username);
        if(uploadPath.exists()==false){
            uploadPath.mkdirs();
        }
        filename=file.getOriginalFilename();
        filename.substring(filename.lastIndexOf("\\")+1);
        File savefile=new File(uploadPath, filename);
        try{
            file.transferTo(savefile);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
