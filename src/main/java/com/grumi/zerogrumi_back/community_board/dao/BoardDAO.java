package com.grumi.zerogrumi_back.community_board.dao;

import com.grumi.zerogrumi_back.community_board.dto.BoardDTO;
import com.grumi.zerogrumi_back.community_board.dto.BoardReturnDTO;

import java.util.List;

public interface BoardDAO {
    // 작성
    public int createCommunity(BoardDTO boardDTO, String userId);

    // 조회
    public List<BoardReturnDTO> getListCommunity();

    // 상세조회
    public BoardReturnDTO getCommunity(Long id);

    // 수정
    public int editCommunity(BoardReturnDTO boardReturnDTO);

    // 삭제
    public int deleteCommunity(Long id, String userId);
}
