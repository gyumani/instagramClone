package com.devjaws.instagramclone.domains.user.services;

import com.devjaws.instagramclone.configs.database.dao.ICommonDao;
import com.devjaws.instagramclone.domains.user.dtos.SignUpDTO;
import com.devjaws.instagramclone.domains.user.dtos.entities.ProfileEntity;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import com.devjaws.instagramclone.utils.bean.BeanUtil;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {
    private final Logger logger= LoggerFactory.getLogger(UserService.class);
    @Autowired
    private ICommonDao commonDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public UserEntity signUp(SignUpDTO signUpDTO){
        if(existUsername(signUpDTO.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"이미 존재하는 아이디 입니다.");
        }
        var user= BeanUtil.beansCopy(signUpDTO, UserEntity.class);
        var profile=BeanUtil.beansCopy(signUpDTO.getProfile(), ProfileEntity.class);
        insert(profile);
        user.setProfileId(profile.getId());

        user.setPassword(encoder.encode(signUpDTO.getPassword()));
        insert(user);

        return user;
        
    }

    public void insert(UserEntity user) {
        commonDao.insertData("User.insertUser",user);
    }

    public void insert(ProfileEntity profile) {
        commonDao.insertData("User.insertProfile",profile);
    }



    public boolean existUsername(String username){
        return commonDao.getData("User.existUsername",username);
    }
}
