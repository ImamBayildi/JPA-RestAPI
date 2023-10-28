package com.labreport.backendlabrep.service;


import java.util.List;

import com.labreport.backendlabrep.entity.t_user;
import com.labreport.backendlabrep.repository.userRepository;

import lombok.RequiredArgsConstructor;


public interface userServiceInterface{
    
    t_user createUser(t_user user);//dafault: public abstract
    List<t_user> getUsers();
    t_user getUserId(Long id);
    t_user updateUser(Long id, t_user user);
    //t_user deleteUser(Long id, t_user user);// delete metodu YANLIŞ
    //Geriye boolean deer dönecek, parametre adı, parametre
    Boolean deleteUser(Long id);

}
