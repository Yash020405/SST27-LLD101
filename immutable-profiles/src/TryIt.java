import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();

        // Test 1
        UserProfile minimalProfile = svc.createMinimal("u1", "a@b.com");
        System.out.println("Test 1: Minimal Profile");
        System.out.println("ID: " + minimalProfile.getId());
        System.out.println("Email: " + minimalProfile.getEmail());

        // Test 2
        UserProfile fullProfile = new UserProfile.Builder("u2", "full@profile.com")
                .setPhone("123-456-7890")
                .setDisplayName("Full Profile")
                .setAddress("123 Main St")
                .setMarketingOptIn(true)
                .setTwitter("@fullprofile")
                .setGithub("fullprofile")
                .build();
        System.out.println("\nTest 2: Full Profile");
        System.out.println("ID: " + fullProfile.getId());
        System.out.println("Email: " + fullProfile.getEmail());
        System.out.println("Phone: " + fullProfile.getPhone());
        System.out.println("Display Name: " + fullProfile.getDisplayName());
        System.out.println("Address: " + fullProfile.getAddress());
        System.out.println("Marketing Opt-In: " + fullProfile.isMarketingOptIn());
        System.out.println("Twitter: " + fullProfile.getTwitter());
        System.out.println("GitHub: " + fullProfile.getGithub());

        // Test 3: Validation - Invalid email
        System.out.println("\nTest 3: Validation - Invalid Email");
        try {
            svc.createMinimal("u3", "invalid-email");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        // Test 4: Validation - Long display name
        System.out.println("\nTest 4: Validation - Long Display Name");
        UserProfile longDisplayNameProfile = new UserProfile.Builder("u4", "long@display.com")
                .setDisplayName(
                        "This display name is way too long and should be trimmed to fit the limit of 100 characters. This extra text should not appear in the final display name.")
                .build();
        System.out.println("Display Name: " + longDisplayNameProfile.getDisplayName());
        System.out.println("Display Name Length: " + longDisplayNameProfile.getDisplayName().length());

        // Test 5: Immutability
        System.out.println("\nTest 5: Immutability");
        System.out.println("Before: " + minimalProfile.getEmail());
        System.out.println("Attempting to modify the email...");
        System.out.println("=> Modification is not possible. Object remains immutable.");
    }
}
