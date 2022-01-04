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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public AuthorModel insert(AuthorModel author) {
        author.setPassword(encoder.encode(author.getPassword()));
        String slug = ((author.getUsername() + "-" + author.getDateCreated()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));
        List<AuthorModel> authors = authorsRepository.findAllBySlug(slug);

        if(authors.size()>0){
            author.setSlug(slug + "-" + authors.size());
        }else{
            author.setSlug(slug);
        }


        List<TagModel> tags = tagsService.getAuthorTags(author);
        author.setTags(tags);

        return authorsRepository.insert(author);
    }

    @Override
    public AuthorModel findOneBySlug(String slug) {
        return authorsRepository.findBySlug(slug);
    }

    @Override
    public AuthorModel findOneByEmail(String email) {
        return authorsRepository.findOneByEmail(email);
    }

    @Override
    public AuthorModel findOneByUsername(String username) {
        return authorsRepository.findOneByUsername(username);
    }
    @Override
    public List<AuthorModel> findAll() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthorModel author = authorsRepository.findOneByUsername(username);
        if(author==null){
            throw  new UsernameNotFoundException("Author not found");
        }

        List authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
        return new User(author.getUsername(),author.getPassword(),authorities);
    }

    @Override
    public AuthorModel findOneByUsernameOrEmail(String username){
        return authorsRepository.findOneByUsernameOrEmail(username,username);
    }
}
