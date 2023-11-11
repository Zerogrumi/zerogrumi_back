package com.grumi.zerogrumi_back.community_board.service;

import com.grumi.zerogrumi_back.community_board.dao.BoardDAO;
import com.grumi.zerogrumi_back.community_board.dto.BoardDTO;
import com.grumi.zerogrumi_back.community_board.dto.BoardReturnDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardReturnDTO> getList() {
        return boardDAO.getListCommunity();
    }

    @Override
    public BoardReturnDTO getOne(Long id) {
        return boardDAO.getCommunity(id);
    }

    @Override
    public void createCommunity(BoardDTO boardDTO, String userId) {
        if (boardDTO == null || userId == null) {
            // 예외 처리 또는 적절한 조치를 취함
            throw new IllegalArgumentException("boardDTO or userId is null");
        }
        boardDAO.createCommunity(boardDTO, userId);
    }

    @Override
    public boolean deleteCommunity(Long id, String userId) {
        if (boardDAO.deleteCommunity(id, userId)==0) return false;
        else return true;
    }
}
