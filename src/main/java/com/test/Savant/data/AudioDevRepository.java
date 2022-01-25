package com.test.Savant.data;

import com.test.Savant.models.AudioDevice;
import org.springframework.data.repository.CrudRepository;

public interface AudioDevRepository extends CrudRepository<AudioDevice, Integer> {
    AudioDevice findById(int id);
}
