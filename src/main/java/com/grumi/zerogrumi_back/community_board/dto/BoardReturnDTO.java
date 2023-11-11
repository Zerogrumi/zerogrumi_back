package com.grumi.zerogrumi_back.community_board.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardReturnDTO {
    private Long id;
    private String writer;
    private Integer category;
    private String title;
    private String content;
    private LocalDateTime date;
}
