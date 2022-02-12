package com.test.Savant.data;

import com.test.Savant.models.zone.Zone;
import org.springframework.data.repository.CrudRepository;

public interface ZoneRepository extends CrudRepository<Zone, Integer> {
    Zone findByName (String name);

}
