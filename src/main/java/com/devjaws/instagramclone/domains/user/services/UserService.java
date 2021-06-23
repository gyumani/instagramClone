package com.devjaws.instagramclone.domains.user.services;

import com.devjaws.instagramclone.configs.database.dao.ICommonDao;
import com.devjaws.instagramclone.domains.user.dtos.entities.ProfileEntity;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.role.RoleType;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private ICommonDao commonDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void join(UserEntity userEntity) {
        String rawPassword= userEntity.getPassword();
        String encPassword=encoder.encode(rawPassword);
        userEntity.setPassword(encPassword);
        userEntity.setRole(RoleType.USER);
        logger.info("====>{}", new Gson().toJson(userEntity));
        insert(userEntity);
    }



    @Transactional
    public void updateUser(UserEntity userEntity){
        String rawPassword= userEntity.getPassword();
        String encPassword=encoder.encode(rawPassword);
        userEntity.setPassword(encPassword);
        logger.info("====>{}",new Gson().toJson(userEntity));
        update(userEntity);

    }

    @Transactional
    public boolean deleteUser(Integer id){
        return commonDao.deleteData("User.deleteUser", id)==1;
    }

    public void insert(UserEntity user) {
        commonDao.insertData("User.insertUser", user);
    }
    public void update(UserEntity user) {commonDao.updateData("User.updateUser", user);}
}