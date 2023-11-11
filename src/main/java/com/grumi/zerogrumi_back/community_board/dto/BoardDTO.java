package com.grumi.zerogrumi_back.community_board.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class BoardDTO {
    private Integer category;
    private String title;
    private String content;
}
