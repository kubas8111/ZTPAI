package com.example.adwise.services;

import com.example.adwise.DTO.RegionDTO;
import com.example.adwise.entities.Region;
import com.example.adwise.exceptions.ResourceNotFoundException;
import com.example.adwise.repositories.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Iterable<RegionDTO> getAllRegions() {
        Iterable<Region> regions = regionRepository.findAll();
        List<RegionDTO> regionDTOs = new ArrayList<>();
        regions.forEach(region -> regionDTOs.add(convertToDto(region)));
        return regionDTOs;
    }

    public RegionDTO getRegionById(Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + id));
        return convertToDto(region);
    }

    public RegionDTO createRegion(RegionDTO regionDTO) {
        Region region = convertToEntity(regionDTO);
        Region createdRegion = regionRepository.save(region);
        return convertToDto(createdRegion);
    }

    public RegionDTO updateRegion(Long id, RegionDTO regionDTO) {
        Region existingRegion = regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + id));

        existingRegion.setName(regionDTO.getName());

        Region updatedRegion = regionRepository.save(existingRegion);
        return convertToDto(updatedRegion);
    }

    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }

    private RegionDTO convertToDto(Region region) {
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setRegionId(region.getRegionId());
        regionDTO.setName(region.getName());
        return regionDTO;
    }

    private Region convertToEntity(RegionDTO regionDTO) {
        Region region = new Region();
        region.setRegionId(regionDTO.getRegionId());
        region.setName(regionDTO.getName());
        return region;
    }
}
