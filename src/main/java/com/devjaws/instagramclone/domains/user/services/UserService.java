package com.devjaws.instagramclone.domains.user.services;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.role.RoleType;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.jws.soap.SOAPBinding;
import java.util.List;


@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private CommonDao commonDao;


    @Autowired
    private SqlSession sqlSession;

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
    public boolean existUsername(String username){ return commonDao.getData("User.exisetUsername",username);}


    @Transactional
    public void updateProfile(UserEntity userEntity){
        commonDao.updateData("User.updateProfile", userEntity);
    }

    @Transactional
    public UserEntity profile(String username){ return commonDao.getData("User.selectProfile", username);}
}