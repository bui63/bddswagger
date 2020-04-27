package com.demo.swagger.users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String dob;

	public User(int id, String name, String dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }
}


