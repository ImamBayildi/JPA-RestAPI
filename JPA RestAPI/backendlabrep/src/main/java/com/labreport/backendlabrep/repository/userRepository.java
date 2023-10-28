package com.labreport.backendlabrep.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.labreport.backendlabrep.entity.t_user;
import java.util.List;


//Database işlemleri
                                                    //hangi class ve primary key değer tipine hizmet ediyor?
public interface userRepository extends JpaRepository<t_user,Long> {//JPA repository içinde hazır database metotları var
    
    // t_user findByFirstNamUser(String firstNane);// ??**özel sorgu. Tekrar kurcala

    // @Query("")//database query
    // User getUser(String firstName);//metot
}
