package com.hotel.utp.project.infrastructure.__mockdata__;

import com.hotel.utp.project.domain.User;

import java.util.ArrayList;
import java.util.List;

public class MockUser {

    public static List<User> users = new ArrayList<>();

    public MockUser() {
        users.add(new User(1, "8a4f20c1-9fbd-4c49-9df3-01c3b28b1f23", "98765432", "John Doe", "john.doe@example.com", "pass123"));
        users.add(new User(1, "8a4f20c1-9fbd-4c49-9df3-01c3b28b1f23", "98765432", "John Doe", "john.doe@example.com", "pass123"));
        users.add(new User(2, "c2b3ae93-7dc7-4f6b-8ff4-a1f0e9e1c771", "98765493", "Jane Smith", "jane.smith@example.com", "secure456"));
        users.add(new User(3, "91c05887-2620-4dcb-b9fd-d4d2e4a68c4c", "98765433", "Robert Johnson", "robert.j@example.com", "123pass"));
        users.add(new User(4, "bce413b0-0e4d-47b7-ae60-ec6c0a028932", "98765434", "Emily Davis", "emily.d@example.com", "password1"));
        users.add(new User(5, "e9a1b6e3-2f01-4012-a46a-dc7fd15f44ec", "98765435", "Michael Brown", "michael.b@example.com", "letmein"));
        users.add(new User(6, "a2b04c42-bc02-49ee-8a3a-3cd5a2e7c8f3", "98765438", "Linda Garcia", "linda.g@example.com", "qwerty123"));
        users.add(new User(7, "7a1499a3-cb38-4088-8b6f-9296c9f3422d", "98765439", "William Martinez", "will.m@example.com", "admin123"));
        users.add(new User(8, "ce54396e-7cb7-4ae6-a447-1973fa6d5537", "98765442", "Elizabeth Rodriguez", "liz.r@example.com", "pass789"));
        users.add(new User(9, "9d0b8e26-4105-4379-b320-4c32b3cbf210", "98765443", "David Lee", "david.l@example.com", "zxcvbn"));
        users.add(new User(10, "643f9a9a-b80c-4e84-9a9c-f5fd77b83c4b", "98765344", "Susan White", "susan.w@example.com", "abc123"));
        users.add(new User(11, "4321fd3b-ea92-40b5-9f28-51ab8f2f8dc3", "92265433", "Thomas Harris", "thomas.h@example.com", "thomaspass"));
        users.add(new User(12, "d8c7c3a4-d86c-4a3f-a81b-d49f3c40db38", "91165455", "Jessica Clark", "jessica.c@example.com", "mypassword"));
        users.add(new User(13, "c84f40e3-e456-4d3f-b182-650c7f6e3b33", "94465455", "Christopher Lewis", "chris.l@example.com", "hunter2"));
        users.add(new User(14, "8f42c79b-4c62-43a4-b37b-527fcbf02b8b", "95565455", "Patricia Robinson", "patricia.r@example.com", "pw123456"));
        users.add(new User(15, "85d0aef0-e093-4ce1-9c3e-dac25a77609d", "96665455", "Daniel Walker", "daniel.w@example.com", "123qwe"));
        users.add(new User(16, "1aa20f37-67b7-4fd4-a14b-8f2b90b016cb", "97765455", "Sarah Young", "sarah.y@example.com", "sarah2021"));
        users.add(new User(17, "c8a47f6c-1b01-430b-9896-1c3e3c93c813", "98865455", "Matthew King", "matthew.k@example.com", "kingpass"));
        users.add(new User(18, "bce7cf1c-3d62-4de3-9dc1-f09abcc0bebb", "99965455", "Karen Wright", "karen.w@example.com", "wrightpwd"));
        users.add(new User(19, "3a3ae88e-092e-4723-9db0-d5e7a2bfc2e1", "94365455", "Joshua Lopez", "joshua.l@example.com", "jlo123"));
        users.add(new User(20, "e23968e7-630f-45cc-93b2-8f33c90ee6fc", "93165455", "Nancy Hill", "nancy.h@example.com", "nancyhill"));
    }

    public static List<User> createMockUser() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }
    public static void removeUser(User user) {
        users.remove(user);
    }

    public User searchUserById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
    public User searchUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }
    public User searchUserByDocumentNumber(String documentNumber) {
        return users.stream().filter(user -> user.getDocumentNumber().equals(documentNumber)).findFirst().orElse(null);
    }


}
