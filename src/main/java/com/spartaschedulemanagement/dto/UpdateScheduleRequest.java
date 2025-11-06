package com.spartaschedulemanagement.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    private String title;
    private String contents;
    private String nickname;
    private String password;
}
