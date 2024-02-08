package mini.mini;

// AuthService class manages user authentication and session
public class AuthService {
    private static AuthService instance; // Singleton instance of AuthService
    private int loggedInUserId = -1; // Default value when no user is logged in

    // Fields to store logged-in user information
    private String loggedINUsername; // Username of the logged-in user
    private String loggedInUsername; // Username of the logged-in user

    // Private constructor to prevent direct instantiation
    private AuthService() {
    }

    // Method to get the singleton instance of AuthService
    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    // Method to log in a user
    public void login(int userId, String loggedInUsername) {
        loggedInUserId = userId;
    }

    // Method to log out a user
    public void logout() {
        loggedInUserId = -1;
    }

    // Method to get the ID of the logged-in user
    public int getLoggedInUserId() {
        return loggedInUserId;
    }

    // Getter method for the loggedINUsername field
    public String getLoggedINUsername() {
        return loggedINUsername;
    }

    // Getter method for the loggedInUsername field
    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    // Setter method for the loggedInUsername field
    public void setLoggedInUsername(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;
    }
}
