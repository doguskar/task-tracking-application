package com.doguskar.tasktrackingapplication.repository;

import com.doguskar.tasktrackingapplication.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

}
