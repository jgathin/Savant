package com.test.Savant.data;

import com.test.Savant.models.layout.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
    Project findByName (int name);
}
