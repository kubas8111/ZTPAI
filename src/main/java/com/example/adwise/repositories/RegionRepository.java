package com.example.adwise.repositories;

import com.example.adwise.entities.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Integer> {
    Region findRegionByRegionId(Integer regionId);
}
