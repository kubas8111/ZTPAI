package com.example.adwise.services;

import com.example.adwise.DTO.TagDTO;
import com.example.adwise.entities.Tag;
import com.example.adwise.exceptions.ResourceNotFoundException;
import com.example.adwise.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Iterable<TagDTO> getAllTags() {
        Iterable<Tag> tags = tagRepository.findAll();
        List<TagDTO> tagDTOs = new ArrayList<>();
        tags.forEach(tag -> tagDTOs.add(convertToDto(tag)));
        return tagDTOs;
    }

    public TagDTO getTagById(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with id: " + id));
        return convertToDto(tag);
    }

    public TagDTO createTag(TagDTO tagDTO) {
        Tag tag = convertToEntity(tagDTO);
        Tag createdTag = tagRepository.save(tag);
        return convertToDto(createdTag);
    }

    public TagDTO updateTag(Long id, TagDTO tagDTO) {
        Tag existingTag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with id: " + id));

        existingTag.setName(tagDTO.getName());

        Tag updatedTag = tagRepository.save(existingTag);
        return convertToDto(updatedTag);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    private TagDTO convertToDto(Tag tag) {
        TagDTO tagDTO = new TagDTO();
        tagDTO.setTagId(tag.getTagId());
        tagDTO.setName(tag.getName());
        return tagDTO;
    }

    private Tag convertToEntity(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setTagId(tagDTO.getTagId());
        tag.setName(tagDTO.getName());
        return tag;
    }
}
