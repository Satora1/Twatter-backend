package com.group3.twat.posts.service;

import com.group3.twat.posts.model.Post;

import java.util.Date;
import java.util.List;

public interface Post_DB {

    public Post getPost(int id);
    public List<Post> getUserPosts(int id);
    public List<Post> getPostsByDate(Date date);

    public void addPost(Post post);
}
