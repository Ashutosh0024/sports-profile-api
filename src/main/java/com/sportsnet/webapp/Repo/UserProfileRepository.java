package com.sportsnet.webapp.Repo;

import com.sportsnet.webapp.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}

