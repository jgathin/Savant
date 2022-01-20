package com.test.Savant.data;

import com.test.Savant.models.Host;
import org.springframework.data.repository.CrudRepository;

public interface HostRepository extends CrudRepository<Host,Integer> {

//    Host findByModel(String model);
    Host findById(int id);
}
