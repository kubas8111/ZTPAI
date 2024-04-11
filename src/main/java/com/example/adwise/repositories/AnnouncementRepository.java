package com.example.adwise.repositories;

import com.example.adwise.entities.Announcement;
import org.springframework.data.repository.CrudRepository;

public interface AnnouncementRepository extends CrudRepository<Announcement, Integer> {
    Announcement findAnnouncementByAnnouncementId(Integer announcementId);
}
