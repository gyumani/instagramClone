package com.devjaws.instagramclone.domains.follow.service;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.follow.dtos.entities.FollowEntity;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FollowService {
    private Logger logger= LoggerFactory.getLogger(FollowService.class);
    @Autowired
    private CommonDao commonDao;

    @Transactional
    public void follow(FollowEntity followEntity){
        commonDao.insertData("Follow.follow", followEntity);
        logger.info("============>{}",new Gson().toJson(followEntity));
    }

    @Transactional
    public boolean followData(String username) { return commonDao.getData("Follow.followData",username);}
}
