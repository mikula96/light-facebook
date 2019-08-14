package com.consulteer.facebook.repository;

import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.user = ?1 ORDER BY  p.text asc")
    Page<Post> findAllByUserSorted(User user, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.user = ?1")
    Page<Post> findAllByUser(User user, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.user = ?1 AND SUBSTRING(p.time, 1, 4) = CAST(?2 as text)")
    Page<Post> findAllByUserAndYear(User user, int year, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.user = ?1")
    List<Post> findAllPostsByUser(User user);

}