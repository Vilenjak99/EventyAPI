package com.example.eventsapi.service;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.TagModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class TagsService implements ITagsService {
    private List<TagModel> tags;
    private String name;
    @Override
    public List<TagModel> getAuthorTags(AuthorModel model) {
        tags = new ArrayList<TagModel>();

        name = model.getUsername()+" "+model.getDateOfBirth();
        tags.add(createTag(name));
        return tags;
    }

    @Override
    public List<TagModel> getEventTags(EventModel event) {
        tags = new ArrayList<TagModel>();

        name = event.getEventLocalization().getTitle();
        tags.add(createTag(name));

        name = event.getAuthor().getUsername() + " " + event.getAuthor().getDateOfBirth();
        tags.add(createTag(name));

        name = event.getEventLocalization().getCulture();
        tags.add(createTag(name));

        return tags;
    }

    @Override
    public TagModel createTag(String name){
        String nameSearch = name.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-");
        return new TagModel(name,nameSearch);
    }
}
