package com.group3.twat.posts.model;

import java.util.Date;

public record Post(int id, int user_id, String text, Date date) {
}
