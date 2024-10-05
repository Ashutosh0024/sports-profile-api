package com.sportsnet.webapp.Controller;

import com.sportsnet.webapp.Entity.UserProfile;
import com.sportsnet.webapp.Service.FileUploadService;
import com.sportsnet.webapp.Service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private FileUploadService fileUploadService;

    // Create profile with photo upload
    @PostMapping
    public UserProfile createProfile(
            @RequestParam("name") String name,
            @RequestParam("bio") String bio,
            @RequestParam("tagline") String tagline,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        String profilePhotoUrl = fileUploadService.uploadFile(file);

        UserProfile userProfile = new UserProfile();
        userProfile.setName(name);
        userProfile.setBio(bio);
        userProfile.setTagline(tagline);
        userProfile.setProfilePhoto(profilePhotoUrl);

        return userProfileService.createProfile(userProfile);
    }

    // Get all profiles
    @GetMapping
    public List<UserProfile> getAllProfiles() {
        return userProfileService.getAllProfiles();
    }

    // Get profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getProfileById(@PathVariable Long id) {
        return userProfileService.getProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update profile
    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateProfile(@PathVariable Long id, @RequestBody UserProfile userProfileDetails) {
        return ResponseEntity.ok(userProfileService.updateProfile(id, userProfileDetails));
    }

    // Delete profile
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        userProfileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}

