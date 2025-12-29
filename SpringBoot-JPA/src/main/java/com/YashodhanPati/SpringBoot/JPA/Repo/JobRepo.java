package com.YashodhanPati.SpringBoot.JPA.Repo;

import com.YashodhanPati.SpringBoot.JPA.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {


    //List<JobPost> findByPostProfileContainingOrPostDescriptionContaining(String postProfile, String postDescription);

//    List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescriptionContainingIgnoreCase(String postProfile, String postDescription);
//
//    List<JobPost> findByPostProfileContainingPostDescriptionContainingIgnoreCase(String keyword, String keyword1);
    List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescriptionContainingIgnoreCase(String profile, String description);

}
