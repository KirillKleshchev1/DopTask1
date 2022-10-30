package org.example;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Дима", "1234@mail.ru", "12".getBytes());
        User user2 = new User("Дима", "1234@mail.ru", "12".getBytes());
        User user3 = new User("Миша", "1234@mail.ru", "1234".getBytes());
        User user4 = new User("Миша", "123456@mail.ru", "1234".getBytes());
        Collection<User> collA = new ArrayList<>();
        Collection<User> collB = new ArrayList<>();

        collA.add(user1);
        collA.add(user2);
        collA.add(user3);
        collB.add(user1);
        collB.add(user2);
        collB.add(user3);
        collB.add(user4);

        System.out.println(findDuplicates(collA, collB));
    }

    private static List findDuplicates(Collection collA, Collection collB) {
        Stream<Collection> combinedCollection = Stream.concat(
                collA.stream(),
                collB.stream());

        Set<Object> lump = new HashSet();
        List<String> duplicate = new ArrayList<>();

        for (Object i : (Iterable<Collection>) () -> combinedCollection.iterator())
        {
            if (lump.contains(i)) {
                duplicate.add(
                        "Имя: " + User.class.cast(i).getUsername() +
                                " Почта: " + User.class.cast(i).getEmail() +
                                " Пароль: " + User.class.cast(i).getPasswordHash()
                );
            }
            lump.add(i);
        }
        return duplicate;
    }
}