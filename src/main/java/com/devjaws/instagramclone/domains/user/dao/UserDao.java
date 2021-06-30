package com.devjaws.instagramclone.domains.user.dao;

import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    UserEntity selectProfile(Integer id);
}
