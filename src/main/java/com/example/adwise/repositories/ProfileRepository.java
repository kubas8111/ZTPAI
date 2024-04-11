package com.example.adwise.repositories;

import com.example.adwise.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
    Profile findProfileByProfileId(Integer profileId);
}
