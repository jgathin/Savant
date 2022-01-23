package com.test.Savant.data;

import com.test.Savant.models.SavControl;
import org.springframework.data.repository.CrudRepository;

public interface SavControlRepository extends CrudRepository<SavControl, Integer> {
    SavControl findById(int Id);
}
