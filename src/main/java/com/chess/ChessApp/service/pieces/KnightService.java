package com.chess.ChessApp.service.pieces;

import com.chess.ChessApp.dto.Coordinates;
import com.chess.ChessApp.model.ChessBoard;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class KnightService {
    public ChessBoard getPossibleMoves(int board[][], Coordinates coordinates) {


        return new ChessBoard(board);
    }

    public ChessBoard canMove(int board[][], Coordinates coordinates) {
        
        return null;
    }

    public ChessBoard canTake(int board[][], Coordinates coordinates) {

        return null;
    }
}
