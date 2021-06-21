package com.devjaws.instagramclone.domains.user.services;

import com.devjaws.instagramclone.configs.database.dao.ICommonDao;
import com.devjaws.instagramclone.domains.user.dtos.entities.ProfileEntity;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.domains.user.role.RoleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    private final Logger logger= LoggerFactory.getLogger(UserService.class);
    @Autowired
    private ICommonDao commonDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void join(UserEntity userEntity){
        String rawPassoword=userEntity.getPassword();
        String encPassword= encoder.encode(rawPassoword);
        userEntity.setPassword(encPassword);
        userEntity.setRole(RoleType.USER);
        insert(userEntity);
    }

    public void insert(UserEntity user) {
        commonDao.insertData("User.insertUser",user);
    }




    public boolean existUsername(String username){
        return commonDao.getData("User.existUsername",username);
    }
}
