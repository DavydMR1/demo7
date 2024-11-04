package com.example.demo7.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notes {
    private Long id;
    private String Title;
    private String Text;
    private LocalDateTime time;
}
