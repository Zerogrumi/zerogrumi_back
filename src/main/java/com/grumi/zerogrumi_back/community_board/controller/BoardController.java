package com.grumi.zerogrumi_back.community_board.controller;


import com.grumi.zerogrumi_back.community_board.dto.BoardDTO;
import com.grumi.zerogrumi_back.community_board.dto.BoardReturnDTO;
import com.grumi.zerogrumi_back.community_board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    // 목록 조회
    @GetMapping("")
    public ResponseEntity<List<BoardReturnDTO>> getListCommunity() {
        List<BoardReturnDTO> boardReturnDTOS = boardService.getList();
        if (boardReturnDTOS.size()==0) return new ResponseEntity<>(HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(boardReturnDTOS);
    }

    // 상세 조회
    @GetMapping("/{boardID}")
    public ResponseEntity<BoardReturnDTO> getCommunity(@PathVariable("boardID") Long id) {
        BoardReturnDTO boardReturnDTO = boardService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardReturnDTO);
    }

    // 작성
    @PostMapping("")
    public ResponseEntity<HttpStatus> createCommunity(@RequestBody BoardDTO boardDTO, @RequestParam("userId") String userId) {
        boardService.createCommunity(boardDTO, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 수정

    // 삭제
    @DeleteMapping("/{boardID}")
    public ResponseEntity<HttpStatus> deleteCommunity(@PathVariable("boardID") Long id, @RequestParam("userId") String userId) {
        if (boardService.deleteCommunity(id, userId)) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
