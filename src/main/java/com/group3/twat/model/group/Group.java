package com.group3.twat.model.group;

import com.group3.twat.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {
    private Long id;
    String name;
    private List<User> users;
}
