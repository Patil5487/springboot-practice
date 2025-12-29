package com.YashodhanPati.SpringBoot.JPA.Model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobPost{

    @Id
    private int postId;
    private String postProfile;
    private String postDescription;
    private int postExperience;
    private List<String> postTechStacks;

}
