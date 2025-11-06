package com.spartaschedulemanagement.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    @Column(length = 50, nullable = false)
    private String nickname;
    @Column(unique = true, nullable = false)
    private String password;

    public Schedule (String title, String contents, String name, String password) {
        this.title = title;
        this.contents = contents;
        this.nickname = name;
        this.password = password;
    }

    public void update(String title, String contents, String name, String password) {
        this.title = title;
        this.contents = contents;
        this.nickname = name;
        this.password = password;
    }
}
