package com.spartaschedulemanagement.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class CreateScheduleRequest {

    private String title;
    private String contents;
    private String nickname;
    private String password;
}
