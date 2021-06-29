package com.devjaws.instagramclone.configs.auth;

import com.devjaws.instagramclone.configs.database.dao.CommonDao;
import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private CommonDao commonDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity principal = null;
        if(commonDao.getData("User.existUsername",username)){
            principal=commonDao.getData("User.selectUser",username);
        }
        return new PrincipalDetail(principal);
    }
}
