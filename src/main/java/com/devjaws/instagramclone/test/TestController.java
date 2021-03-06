package com.devjaws.instagramclone.test;

import com.devjaws.instagramclone.configs.Const;
import com.devjaws.instagramclone.domains.comment.dtos.entities.CommentEntity;
import com.devjaws.instagramclone.domains.comment.service.CommentService;
import com.devjaws.instagramclone.domains.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.UUID;

@Controller
public class TestController {

    @Autowired
    private CommentService commentService;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    @GetMapping("/test/index")
    public String testIndex(){return "index";}
    @GetMapping("/test/upload")
    public String testupload() {return "board/testup";}


    @PostMapping("/test/uploadPropicture")
    public String testuploadProc(@RequestPart("file") MultipartFile[] uploadfile, Model model){
        String uploadFolder= Const.PATH_PROFILEPICTURE;
        for(MultipartFile multipartFile : uploadfile){
            logger.info("---------------------------");
            logger.info("Upload file name: "+ multipartFile.getOriginalFilename());
            logger.info("Upload file size: "+multipartFile.getSize());

            UUID uuid=UUID.randomUUID();
            String uploadFilename=uuid.toString().replaceAll("-","")+"-"+multipartFile.getOriginalFilename();
            File saveFile=new File(uploadFolder, uploadFilename);

            try{
                multipartFile.transferTo(saveFile);
            }
            catch (Exception e){
                logger.info(e.getMessage());
            }
        }
        return "board/testup";
    }

    @GetMapping("/test/comment")
    public String goCommentTest(){
        return "test/comment";
    }
    @PostMapping("/test/insert")
    public String insertComment(CommentEntity commentEntity){
        commentService.insertComment(commentEntity);
        return "test/comment";
    };
    private boolean checkImageType(File file){
        try{
            String contentType= Files.probeContentType(file.toPath());
            return contentType.startsWith("image");
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
