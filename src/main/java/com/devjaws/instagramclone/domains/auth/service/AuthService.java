package com.devjaws.instagramclone.domains.auth.service;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.role.RoleType;
import com.devjaws.instagramclone.domains.user.services.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final Logger logger = LoggerFactory.getLogger(AuthService.class);
    //데이터 엑세스를 위해 정의
    @Autowired
    private CommonDao commonDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public boolean findById(String username) { return commonDao.getData("Auth.existUsername",username); }

    @Transactional
    public void insert(UserEntity user) {
        commonDao.insertData("Auth.insertUser", user);
    }


    @Transactional
    public void join(UserEntity userEntity) {
        String rawPassword= userEntity.getPassword();
        String encPassword=encoder.encode(rawPassword);
        userEntity.setPassword(encPassword);
        userEntity.setRole(RoleType.USER);
        logger.info("====>{}", new Gson().toJson(userEntity));
        insert(userEntity);
    }
}
