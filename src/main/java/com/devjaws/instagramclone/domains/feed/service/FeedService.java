package com.devjaws.instagramclone.domains.feed.service;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.feed.dtos.entities.FeedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class FeedService {

    @Autowired
    private CommonDao commonDao;

    @Transactional
    public void regi(FeedEntity feedEntity){
        commonDao.insertData("Feed.insertFeed",feedEntity);
    }

    @Transactional
    public List<FeedEntity> main(Model model){
        return commonDao.getList("Feed.main", model);
    }

    @Transactional
    public List<FeedEntity> getpp (String username){
        return commonDao.getList("Feed.getpp", username);
    }
}
