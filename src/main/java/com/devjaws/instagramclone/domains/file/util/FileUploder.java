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
    public void uploadPost(MultipartFile[] file, Model model) throws Exception{
        String path= Const.PATH_POSTPICTURE;
        for(MultipartFile multipartFile: file){
            UUID uuid=UUID.randomUUID();
            String filename="Post_"+uuid.toString().replaceAll("-","")+multipartFile.getOriginalFilename();
            File savefile=new File(path, filename);
            try{
                multipartFile.transferTo(savefile);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
