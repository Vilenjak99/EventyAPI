package com.example.eventsapi.controller;

import com.example.eventsapi.model.CommentModel;
import com.example.eventsapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("")
    public CommentModel insert(@RequestBody CommentModel commentModel){
        return commentService.insert(commentModel);
    }

    @GetMapping("")
    public List<CommentModel> findAll(){
        return commentService.findAll();
    }

    @GetMapping(value = "", params = "eventId")
    public List<CommentModel> findAllByEventId(@RequestParam ("eventId") String eventId){
        return commentService.findAllByEventId(eventId);
    }
    @GetMapping(value = "", params = "parentCommentId")
    public List<CommentModel> findAllByParentCommentId(@RequestParam String parentCommentId){
        return commentService.findAllByParentCommentId(parentCommentId);
    }
    @PutMapping
    public CommentModel update(@RequestBody CommentModel model){
        return commentService.update(model);
    }

}
