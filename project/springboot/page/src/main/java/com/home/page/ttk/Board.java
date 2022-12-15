package com.home.page.ttk;

import java.time.LocalDateTime;

import lombok.ToString;

@ToString
public class Board {

    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
}
