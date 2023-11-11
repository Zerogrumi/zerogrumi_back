package com.grumi.zerogrumi_back.community_board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardRequestDTO {
    private Long id;
    private String writer;
    private Integer category;
    private String title;
    private String content;
    private LocalDateTime date;
    public BoardRequestDTO(BoardDTO boardDTO, String writer) {
        this.writer = writer;
        this.category = boardDTO.getCategory();
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
    }
}
