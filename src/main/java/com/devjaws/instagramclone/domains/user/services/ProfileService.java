package com.devjaws.instagramclone.domains.user.services;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.user.dtos.ProfileDTO;
import com.devjaws.instagramclone.domains.user.dtos.entities.ProfileEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProfileService {
    private final Logger logger = LoggerFactory.getLogger(ProfileService.class);

    @Autowired
    private CommonDao commonDao;

    @Transactional
    public void insert(ProfileEntity profileEntity){
        commonDao.insertData("Profile.insertProfile", profileEntity);
        logger.info("----------------------{}: "+profileEntity );
    }
    @Transactional
    public void update(ProfileEntity profileEntity){
        commonDao.updateData("Profile.updateProfile", profileEntity);
    }

    @Transactional
    public List<ProfileDTO> profile (String username){
        return commonDao.getList("Profile.viewProfile", username);
    }

}
