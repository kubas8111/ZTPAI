package com.example.adwise.repositories;

import com.example.adwise.entities.Announcement;
import com.example.adwise.entities.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
    Optional<Image> findByAnnouncementId_AnnouncementId(Long announcementId);
    void deleteByAnnouncementId_AnnouncementId(Long announcementId);
}
