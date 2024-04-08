package com.chess.ChessApp.service;

import com.chess.ChessApp.dto.Coordinates;
import com.chess.ChessApp.model.ChessBoard;
import com.chess.ChessApp.service.pieces.PawnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChessBoardService {
    @Autowired
    PawnService pawnService;
    public ChessBoard getPieceFromChessboard(ChessBoard chessBoard, Coordinates coordinates) {
        int[][] board = chessBoard.getChessBoard();
        int piece = board[coordinates.getX()][coordinates.getY()];

        switch (piece) {
            case 1, -1:
                board = pawnService.getPossibleMoves(chessBoard.getChessBoard(), coordinates).getChessBoard();
                break;
            case 2, -2:

                break;
            case 3, -3:

                break;
            case 4, -4:

                break;
            case 5, -5:

                break;
            case 6, -6:

                break;
            default:
        }

        return new ChessBoard(board);
    }
}
