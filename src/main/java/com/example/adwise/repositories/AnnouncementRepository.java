package com.example.adwise.repositories;

import com.example.adwise.entities.Announcement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {
    Iterable<Announcement> findAllByProfileId_ProfileId(Long id);
    Iterable<Announcement> findByProfileIdProfileId(Long profileId);
}
