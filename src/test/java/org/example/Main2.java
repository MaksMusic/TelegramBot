package org.example;

import lombok.Builder;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main2 {
    public static void main(String[] args) {
        User user = User.builder().name("Tom").build();
        User user2 = User.builder().name("Tom").strings(new ArrayList<>()).build();

        System.out.println(user.equals(user2));
        System.out.println(user.getStrings());

    }
}
@Data
@Builder
class User{
    private String name;
    private List<String> strings = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}


