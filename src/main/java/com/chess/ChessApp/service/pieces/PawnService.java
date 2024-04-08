package com.chess.ChessApp.service.pieces;

import com.chess.ChessApp.dto.Coordinates;
import com.chess.ChessApp.model.ChessBoard;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class PawnService {

    public ChessBoard getPossibleMoves(int board[][], Coordinates coordinates) {
        canMoveForward(board, coordinates);
        canTake(board, coordinates);
        canEnPassant(board, coordinates);

        return new ChessBoard(board);
    }

    private void canMoveForward(int board[][], Coordinates coordinates) {
        //Can Pawn move 2 spaces
        if (coordinates.getX() == 6) {
            //If nothing is in front of pawns when they have not moved, they can move two squares forward
            if (board[coordinates.getX() - 1][coordinates.getY()] == 0 && board[coordinates.getX() - 2][coordinates.getY()] == 0) {
                board[coordinates.getX() - 1][coordinates.getY()] += 15;
                board[coordinates.getX() - 2][coordinates.getY()] += 15;
            }
        } else {
            //If the pawn has moved
            //TODO If pawn is at end of the board call canPromote
            if (board[coordinates.getX() - 1][coordinates.getY()] == 0) {
                board[coordinates.getX() - 1][coordinates.getY()] += 15;
            }
        }
    }

    private void canTake(int board[][], Coordinates coordinates) {
        //Check to see if pawn is at middle of board
        if (coordinates.getY() > 0 && coordinates.getY() < 7) {
            //Check to see if piece with value less than 10 is able to take
            if (board[coordinates.getX() - 1][coordinates.getY() - 1] < 0) {
                board[coordinates.getX() - 1][coordinates.getY() - 1] += 15;
            }
            if (board[coordinates.getX() - 1][coordinates.getY() + 1] < 0) {
                board[coordinates.getX() - 1][coordinates.getY() + 1] += 15;
            }
        } else if (coordinates.getY() == 0) {
            //Pawn at left end of board
            if (board[coordinates.getX() - 1][coordinates.getY() + 1] < 0) {
                board[coordinates.getX() - 1][coordinates.getY() + 1] += 15;
            }
        } else if (coordinates.getY() == 7) {
            //Pawn at right end of board
            if (board[coordinates.getX() - 1][coordinates.getY() - 1] < 0) {
                board[coordinates.getX() - 1][coordinates.getY() - 1] += 15;
            }
        }
    }

    private void canEnPassant(int board[][], Coordinates coordinates) {

    }

    public void checkToSeeIfPinned() {
        //TODO Write method
    }

    private void canPromote() {
        //TODO Write method
    }
}
