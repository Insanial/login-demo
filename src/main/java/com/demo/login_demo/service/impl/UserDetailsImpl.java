package com.demo.login_demo.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.login_demo.entity.User;

public class UserDetailsImpl implements UserDetails{
    private User user;

     public UserDetailsImpl(User user) {
        this.user = user;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getName();
    }
 
    @Override
    public boolean isAccountNonExpired() {  // 检查账户是否 没过期。
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {   // 检查账户是否 没有被锁定。
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {  //检查凭据（密码）是否 没过期。
        return true;
    }
 
    @Override
    public boolean isEnabled() {    // 检查账户是否启用。
        return true;
    }
    
	public User getUser() {	
	    return user;	
	}
}
