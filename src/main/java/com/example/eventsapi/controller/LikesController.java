package com.example.eventsapi.controller;

import com.example.eventsapi.model.LikeModel;
import com.example.eventsapi.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("likes")
public class LikesController {
    @Autowired
    private LikeService likeService;

    @PostMapping
    public LikeModel save(@RequestBody LikeModel likeModel){
        return likeService.save(likeModel);
    }

    @GetMapping()
    public List<LikeModel> findLikesForCommentByLikeType(@RequestParam("commentId") String commentId, @RequestParam("type") String type){
        return likeService.findLikesForCommentByLikeType(commentId, type);
    }

    @GetMapping(value = "", params = {"commentId","userId"})
    public LikeModel existsByCommentIdAndUserId(@RequestParam("commentId") String commentId, @RequestParam("userId") String userId){
        return likeService.existsByCommentIdAndUserId(commentId, userId);
    }
}
