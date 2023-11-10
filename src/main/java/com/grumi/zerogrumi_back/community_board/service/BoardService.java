package com.grumi.zerogrumi_back.community_board.service;

import com.grumi.zerogrumi_back.community_board.dto.BoardDTO;
import com.grumi.zerogrumi_back.community_board.dto.BoardReturnDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BoardService {
    public List<BoardReturnDTO> getList();
    public BoardReturnDTO getOne(Long id);
    public void createCommunity(BoardDTO boardDTO, String userId);
    public boolean deleteCommunity(Long id, String userId);

}
