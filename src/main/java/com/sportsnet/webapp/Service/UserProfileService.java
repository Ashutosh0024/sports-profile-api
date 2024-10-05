package com.sportsnet.webapp.Service;

import com.sportsnet.webapp.Entity.UserProfile;
import com.sportsnet.webapp.Repo.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<UserProfile> getAllProfiles() {
        return userProfileRepository.findAll();
    }

    public Optional<UserProfile> getProfileById(Long id) {
        return userProfileRepository.findById(id);
    }

    public UserProfile createProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile updateProfile(Long id, UserProfile userProfileDetails) {
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));

        userProfile.setName(userProfileDetails.getName());
        userProfile.setBio(userProfileDetails.getBio());
        userProfile.setTagline(userProfileDetails.getTagline());
        userProfile.setProfilePhoto(userProfileDetails.getProfilePhoto());

        return userProfileRepository.save(userProfile);
    }

    public void deleteProfile(Long id) {
        userProfileRepository.deleteById(id);
    }
}

