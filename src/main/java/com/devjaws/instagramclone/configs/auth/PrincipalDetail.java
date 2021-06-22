package com.devjaws.instagramclone.configs.auth;

import com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetail implements UserDetails {
    private UserEntity userEntity;

    public PrincipalDetail(UserEntity userEntity) { this.userEntity=userEntity; }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collector=new ArrayList<>();
        collector.add(()->{
            return "ROLE_"+userEntity.getRole();
        });
        return null;
    }
}
