package com.example.adwise.repositories;

import com.example.adwise.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Profile findByEmail(String username);
}
