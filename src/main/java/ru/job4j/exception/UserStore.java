package ru.job4j.exception;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equalsIgnoreCase(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException(String.format("User with login '%s' not found", login));
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Invalid user");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Lu", true)
        };
        User user;
        try {
            user = findUser(users, "Lu");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
