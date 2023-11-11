package com.grumi.zerogrumi_back.community_board.dao;

import com.grumi.zerogrumi_back.community_board.dto.BoardDTO;
import com.grumi.zerogrumi_back.community_board.dto.BoardRequestDTO;
import com.grumi.zerogrumi_back.community_board.dto.BoardReturnDTO;
import com.grumi.zerogrumi_back.community_board.service.BoardService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    private SqlSession sqlSession;
    private BoardService boardService;


    @Override
    public int createCommunity(BoardDTO boardDTO, String userId) {

        BoardRequestDTO boardRequestDTO = new BoardRequestDTO(boardDTO, userId);
        int id = sqlSession.insert("board.insertCommunity", boardRequestDTO);
        return id;
    }

    @Override
    public List<BoardReturnDTO> getListCommunity() {
        return sqlSession.selectList("board.getListCommunity");
    }

    @Override
    public BoardReturnDTO getCommunity(Long id) {
        return sqlSession.selectOne("board.getCommunity", id);
    }

    @Override
    public int editCommunity(BoardReturnDTO boardReturnDTO) {
        return sqlSession.update("board.updateCommunity", boardReturnDTO);
    }

    @Override
    public int deleteCommunity(Long id, String userId) {
        if (getCommunity(id).getWriter().equals(userId)) return sqlSession.delete("board.deleteCommunity", id);
        else return 0;
    }
}
