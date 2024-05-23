package com.example.adwise.repositories;

import com.example.adwise.entities.Comment;
import com.example.adwise.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Iterable<Comment> findCommentsByCommentedProfileProfileId(Long commentedProfile_profileId);
}
