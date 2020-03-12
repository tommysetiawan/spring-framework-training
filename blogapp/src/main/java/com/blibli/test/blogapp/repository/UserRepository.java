package com.blibli.test.blogapp.repository;

import com.blibli.test.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tommy.setiawan on 3/12/2020.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
