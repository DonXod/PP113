package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String name1 = "IVAN";
        String name2 = "SASHA";
        String name3 = "MASHA";
        String name4 = "ANNA";
        String lastname1 = "POPOV";
        String lastname2 = "IVANOV";
        String lastname3 = "OSIPOVA";
        String lastname4 = "MHOVA";
        byte age1 = 33;
        byte age2 = 25;
        byte age3 = 40;
        byte age4 = 22;

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser(name1, lastname1, age1);
        System.out.println("User с именем – " + name1 + " добавлен в базу данных");
        userService.saveUser(name2, lastname2, age2);
        System.out.println("User с именем – " + name2 + " добавлен в базу данных");
        userService.saveUser(name3, lastname3, age3);
        System.out.println("User с именем – " + name3 + " добавлен в базу данных");
        userService.saveUser(name4, lastname4, age4);
        System.out.println("User с именем – " + name4 + " добавлен в базу данных");
        List<User> list = userService.getAllUsers();
        for (User user: list) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
