package com.devjaws.instagramclone.domains.feed.service;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.feed.dtos.entities.FeedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedService {

    @Autowired
    private CommonDao commonDao;

    @Transactional
    public void regi(FeedEntity feedEntity){
        commonDao.insertData("Feed.insertFeed",feedEntity);
    }
}
