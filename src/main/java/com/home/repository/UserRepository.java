package com.home.repository;

import com.home.model.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex on 21.01.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<UserDetails, String>{
}
