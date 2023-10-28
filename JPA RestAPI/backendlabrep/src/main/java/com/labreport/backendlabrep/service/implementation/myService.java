package com.labreport.backendlabrep.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.labreport.backendlabrep.entity.t_user;
import com.labreport.backendlabrep.repository.userRepository;
import com.labreport.backendlabrep.service.userServiceInterface;

import lombok.RequiredArgsConstructor;

@Service//spring IoC için bildiri
@RequiredArgsConstructor // Lombok ile otomatik cunstructor oluşturulabilir.
public class myService implements userServiceInterface{

    private final userRepository userRepository;

    @Override
    public t_user createUser(t_user user) {
        
        user.setCreatedDate(new Date());
        user.setCreatedBy("Admin");

        return userRepository.save(user);
    }

    @Override
    public List<t_user> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public t_user getUserId(Long id) {
        Optional<t_user> user = userRepository.findById(id);
        
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public t_user updateUser(Long id, t_user user) {
        Optional<t_user> resultUser = userRepository.findById(id);
        
        if(resultUser.isPresent()){
            resultUser.get().setFirtName(user.getFirtName());//t_user class ında annotation ile oluşturulan getter ve setter lara dayanır. İsim hatasını kasıtlı olarak düzeltmiyorum.
            resultUser.get().setLastName(user.getLastName());
            resultUser.get().setUpdatedAt(new Date());
            resultUser.get().setUpdatedBy("Admin");

            return userRepository.save(resultUser.get());
            
        }

        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<t_user> user = userRepository.findById(id);
        
        if(user.isPresent()){
            userRepository.deleteById(id);//userRepository nin deleteById metoduna
            return true;
        }
        return false;
    }

    // @Override    //YANLIŞ
    // public t_user deleteUser(Long id, t_user user) {

    //     Optional<t_user> resultUser = userRepository.findById(id);

    //     if(resultUser.isPresent()){
    //         return userRepository.delete(t_user user);
    //     }
    //     return null;
    // }

    
    


    
}
