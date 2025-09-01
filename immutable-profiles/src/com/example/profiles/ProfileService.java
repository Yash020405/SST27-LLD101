package com.example.profiles;

/**
 * Assembles profiles with centralized validation and immutability.
 */
public class ProfileService {

    // Creates a minimal profile using the Builder
    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    // Creates a profile with additional optional fields
    public UserProfile createFullProfile(String id, String email, String displayName) {
        UserProfile.Builder builder = new UserProfile.Builder(id, email);

        if (displayName != null && displayName.length() > 30) {
            // Trim displayName if it exceeds the limit
            displayName = displayName.substring(0, 30);
        }

        builder.setDisplayName(displayName);
        return builder.build();
    }
}
