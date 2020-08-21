package com.sample.sampleapp.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.sampleapp.Model.User;

/**
 * @author roundsquare
 */
public interface UserRepo extends JpaRepository<User,Long>  {
}
