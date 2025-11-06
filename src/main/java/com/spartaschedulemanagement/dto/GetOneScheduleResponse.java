package com.spartaschedulemanagement.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetOneScheduleResponse {

    // API 응답에는 password가 제외해야 하므로 password는 없앤다.
    private final Long id;
    private final String title;
    private final String contents;
    private final String nickname;
    //    private final String password;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetOneScheduleResponse(Long id, String title, String contents, String nickname, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.nickname = nickname;
//        this.password = password;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
