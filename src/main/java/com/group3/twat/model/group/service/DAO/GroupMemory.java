package com.group3.twat.model.group.service.DAO;

import com.group3.twat.model.group.Group;
import com.group3.twat.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Repository
public class GroupMemory implements GroupDao {
    private List<Group> groups;

    public GroupMemory() {
        this.groups = new ArrayList<>(Arrays.asList(
                Group.builder().id(1L).name("G 101").users(new ArrayList<>()).build()
        ));
    }

    @Override
    public List<Group> getGroup() {
        return groups;
    }


    @Override
    public void addGroup(Group newGroup) {
        groups.add(newGroup);
    }

    @Override
    public Group getGroupById(Long groupId) {
        return groups.stream()
                .filter(group -> group.getId().equals(groupId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteGroupById(Long groupId) {
        Iterator<Group> iterator = groups.iterator();
        while (iterator.hasNext()) {
            Group group = iterator.next();
            if (group.getId().equals(groupId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }


    @Override
    public void addUserToGroup(Long groupId, User user) {
        Group group = getGroupById(groupId);
        if (group != null) {
            group.getUsers().add(user);
        }
    }

    @Override
    public boolean removeUserFromGroup(Long groupId, Long userId) {
        Group group = getGroupById(groupId);
        if (group != null) {
            Iterator<User> iterator = group.getUsers().iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                if (user.getId()==(userId)) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }
}
