package com.taxi.framework.user.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDao {
    private Long id;
    private int textSize;
    private String colorThem;
    private String language;
    private int screenReaderEnabled;

    @Override
    public String toString() {
        return "UserDao{" +
                "id=" + id +
                ", textSize=" + textSize +
                ", colorThem='" + colorThem + '\'' +
                ", language='" + language + '\'' +
                ", screenReaderEnabled=" + screenReaderEnabled +
                '}';
    }
}
