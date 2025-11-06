package com.spartaschedulemanagement.dto;

import lombok.Getter;

@Getter
public class DeleteScheduleRequest {
    private String title;
    private String contents;
    private String nickname;
    private String password;
}
