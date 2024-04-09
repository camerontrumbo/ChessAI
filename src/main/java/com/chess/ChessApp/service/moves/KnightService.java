package com.chess.ChessApp.service.moves;

import com.chess.ChessApp.dto.Coordinates;
import com.chess.ChessApp.model.ChessBoard;
import org.springframework.stereotype.Service;

@Service
public class KnightService {
    public ChessBoard getPossibleMoves(int board[][], Coordinates coordinates) {
        canMove(board, coordinates);

        return new ChessBoard(board);
    }

    public ChessBoard canMove(int board[][], Coordinates coordinates) {
        checkUp(board, coordinates);
        checkDown(board, coordinates);
        checkLeft(board, coordinates);
        checkRight(board, coordinates);

        return new ChessBoard(board);
    }

    public void checkUp(int board[][], Coordinates coordinates) {
        //Check up and to the right
        //Check to see if knight is at the edge of the board
        if (coordinates.getX() > 1 && coordinates.getY() < 7) {
            //If the square is empty or enemy piece
            if (board[coordinates.getX() - 2][coordinates.getY() + 1] < 1) {
                board[coordinates.getX() - 2][coordinates.getY() + 1] += 15;
            }
        }
        //Check up and to the left
        //Check to see if knight is at the edge of the board
        if (coordinates.getX() > 1 && coordinates.getY() > 0) {
            //If the square is empty or enemy piece
            if (board[coordinates.getX() - 2][coordinates.getY() - 1] < 1) {
                board[coordinates.getX() - 2][coordinates.getY() - 1] += 15;
            }
        }
    }

    public void checkDown(int board[][], Coordinates coordinates) {
        //Check down and to the right
        //Check to see if knight is at the edge of the board
        if (coordinates.getX() < 6 && coordinates.getY() < 7) {
            //If the square is empty or enemy piece
            if (board[coordinates.getX() + 2][coordinates.getY() + 1] < 1) {
                board[coordinates.getX() + 2][coordinates.getY() + 1] += 15;
            }
        }

        //Check down and to the left
        //Check to see if knight is at the edge of the board
        if (coordinates.getX() < 6 && coordinates.getY() > 0) {
            //If the square is empty or enemy piece
            if (board[coordinates.getX() + 2][coordinates.getY() - 1] < 1) {
                board[coordinates.getX() + 2][coordinates.getY() - 1] += 15;
            }
        }
    }

    public void checkLeft(int board[][], Coordinates coordinates) {
        //Check left and up
        //Check to see if knight is at the edge of the board
        if (coordinates.getX() > 0 && coordinates.getY() > 1) {
            //If the square is empty or enemy piece
            if (board[coordinates.getX() - 1][coordinates.getY() - 2] < 1) {
                board[coordinates.getX() - 1][coordinates.getY() - 2] += 15;
            }
        }
        //Check left and down
        if (coordinates.getX() < 7 && coordinates.getY() > 1) {
            //If the square is empty or enemy piece
            if (board[coordinates.getX() + 1][coordinates.getY() - 2] < 1) {
                board[coordinates.getX() + 1][coordinates.getY() - 2] += 15;
            }
        }
    }

    public void checkRight(int board[][], Coordinates coordinates) {
        //Check right and down
        if (coordinates.getX() > 0 && coordinates.getY() < 6) {
            //If the square is empty or enemy piece
            if (board[coordinates.getX() - 1][coordinates.getY() + 2] < 1) {
                board[coordinates.getX() - 1][coordinates.getY() + 2] += 15;
            }
        }
        //Check right and up
        if (coordinates.getX() < 7 && coordinates.getY() < 6) {
            //If the square is empty or enemy piece
            if (board[coordinates.getX() + 1][coordinates.getY() + 2] < 1) {
                board[coordinates.getX() + 1][coordinates.getY() + 2] += 15;
            }
        }
    }
}
