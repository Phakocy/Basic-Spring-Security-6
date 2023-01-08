package com.phakocy.springbootsecurity.controller;

import com.phakocy.springbootsecurity.model.Parent;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ParentController {

    List<Parent> parentList = new ArrayList<>();
    @GetMapping("/parents")
    public List<Parent> parents(){

        Parent parent1 = new Parent();
        parent1.setId(1);
        parent1.setFirstName("Warith");
        parent1.setLastName("Omojola");

        Parent parent2 = new Parent();
        parent2.setId(2);
        parent2.setFirstName("Opeyemi");
        parent2.setLastName("Jimoh");

        parentList.add(parent1);
        parentList.add(parent2);

        return parentList;
    }

    @PreAuthorize("hasRole('ADMIN')") // authorize admin only
    @PostMapping("/parents")
    public Parent createParent(@RequestBody Parent parent){

        parentList.add(parent);
        return parent;
    }
}
