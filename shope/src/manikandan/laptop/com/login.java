package manikandan.laptop.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class login {
    private final Map<String, String> users = new HashMap<>();
    private final List<User> userList = new ArrayList<>();

    public void addAdmin(String username, String password) {
        users.put(username, password);
        userList.add(new User(username, "admin"));
    }

    public void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
        } else {
            users.put(username, password);
            userList.add(new User(username, "user"));
            System.out.println("User registered successfully.");
        }
    }

    public User authenticate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        if (users.containsKey(username) && users.get(username).equals(password)) {
            for (User user : userList) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
        }
        System.out.println("Authentication failed.");
        return null;
    }

    public void showUsers() {
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
