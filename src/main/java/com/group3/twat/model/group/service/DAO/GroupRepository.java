package com.group3.twat.model.group.service.DAO;

import com.group3.twat.model.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long> {
}
