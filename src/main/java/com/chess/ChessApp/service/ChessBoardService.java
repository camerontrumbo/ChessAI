package com.chess.ChessApp.service;

import com.chess.ChessApp.dto.Coordinates;
import com.chess.ChessApp.model.ChessBoard;
import com.chess.ChessApp.service.moves.DiagonalService;
import com.chess.ChessApp.service.moves.KnightService;
import com.chess.ChessApp.service.moves.LeftAndRightService;
import com.chess.ChessApp.service.moves.PawnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChessBoardService {
    @Autowired
    PawnService pawnService;
    @Autowired
    DiagonalService diagonalService;
    @Autowired
    LeftAndRightService leftAndRightService;
    @Autowired
    KnightService knightService;
    public ChessBoard getPieceFromChessboard(ChessBoard chessBoard, Coordinates coordinates) {
        int[][] board = chessBoard.getChessBoard();
        int piece = board[coordinates.getX()][coordinates.getY()];

        switch (piece) {
            case 1, -1:
                board = pawnService.getPossibleMoves(chessBoard.getChessBoard(), coordinates).getChessBoard();
                break;
            case 2, -2:
                board = knightService.getPossibleMoves(board, coordinates).getChessBoard();
                break;
            case 3, -3:
                board = diagonalService.getPossibleMoves(board, coordinates).getChessBoard();
                break;
            case 4, -4:
                board = leftAndRightService.getPossibleMoves(board, coordinates).getChessBoard();
                break;
            case 5, -5:
                board = diagonalService.getPossibleMoves(board, coordinates).getChessBoard();
                board = leftAndRightService.getPossibleMoves(board, coordinates).getChessBoard();
                break;
            case 6, -6:

                break;
            default:
        }

        return new ChessBoard(board);
    }
}
