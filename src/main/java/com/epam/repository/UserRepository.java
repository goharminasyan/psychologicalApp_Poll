package com.epam.repository;

import com.epam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAndPassword(String email, String password);

    User findById(long id);

    boolean existsByEmailAndPassword(String email, String password);


}
