package com.example.eventsapi.service;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.TagModel;
import com.example.eventsapi.repository.IAuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class AuthorService implements IAuthorService, UserDetailsService {
    @Autowired
    private IAuthorsRepository authorsRepository;
    @Autowired
    private TagsService tagsService;

    @Override
    public AuthorModel insert(AuthorModel author) {
        String slug = ((author.getFirstname() + "-" + author.getLastname()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));
        List<AuthorModel> authors = authorsRepository.findAllBySlug(slug);

        if(authors.size()>0){
            author.setSlug(slug + "-" + authors.size());
        }else{
            author.setSlug(slug);
        }

        author.setUsername(author.getSlug());

        List<TagModel> tags = tagsService.getAuthorTags(author);
        author.setTags(tags);

        return authorsRepository.insert(author);
    }

    @Override
    public AuthorModel findOneBySlug(String slug) {
        return authorsRepository.findBySlug(slug);
    }

    @Override
    public List<AuthorModel> findAll() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthorModel author = authorsRepository.findByUsername(username);
        if(author==null){
            throw  new UsernameNotFoundException("Author not found");
        }

        List authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
        return new User(author.getUsername(),author.getPassword(),authorities);
    }
}
