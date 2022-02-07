package com.test.Savant.data;

import com.test.Savant.models.layout.LayoutForm;
import org.springframework.data.repository.CrudRepository;

public interface LayoutRepository extends CrudRepository<LayoutForm, Integer> {
    LayoutForm findById(int Id);
}
