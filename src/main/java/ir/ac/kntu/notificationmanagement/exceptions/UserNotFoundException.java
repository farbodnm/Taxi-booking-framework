package ir.ac.kntu.notificationmanagement.exceptions;

public class UserNotFoundException extends ResourceNotFoundException{
    public UserNotFoundException(Long id) {
        super("User with ID: %d is not found".formatted(id));
    }
}
