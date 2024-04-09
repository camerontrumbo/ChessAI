package com.chess.ChessApp.service.moves;

import com.chess.ChessApp.dto.Coordinates;
import com.chess.ChessApp.model.ChessBoard;
import org.springframework.stereotype.Service;

@Service
public class LeftAndRightService {
    public ChessBoard getPossibleMoves(int board[][], Coordinates coordinates) {
        canMove(board, coordinates);

        return new ChessBoard(board);
    }

    public ChessBoard canMove(int board[][], Coordinates coordinates) {
        searchRight(board, coordinates);
        searchLeft(board, coordinates);
        searchBottom(board, coordinates);
        searchTop(board, coordinates);

        return new ChessBoard(board);
    }

    public void searchLeft(int board[][], Coordinates coordinates) {
        //Search Left
        boolean isBlocked = false;
        int x = coordinates.getX() - 1;
        while(x > -1 && !isBlocked) {
            //if square is empty add 15
            if (board[x][coordinates.getY()] == 0) {
                board[x][coordinates.getY()] += 15;
            } else {
                //If the piece can take add 15
                if (board[x][coordinates.getY()] < 0) {
                    board[x][coordinates.getY()] += 15;
                }
                //Stop the search from moving any further
                isBlocked = true;
            }
            x--;
        }
    }
    public void searchRight(int board[][], Coordinates coordinates) {
        //Search Right
        boolean isBlocked = false;
        int x = coordinates.getX() + 1;
        while(x < 8 && !isBlocked) {
            //if square is empty add 15
            if (board[x][coordinates.getY()] == 0) {
                board[x][coordinates.getY()] += 15;
            } else {
                //If the piece can take add 15
                if (board[x][coordinates.getY()] < 0) {
                    board[x][coordinates.getY()] += 15;
                }
                //Stop the search from moving any further
                isBlocked = true;
            }
            x++;
        }
    }
    public void searchBottom(int board[][], Coordinates coordinates) {
        //Search Bottom
        boolean isBlocked = false;
        int y = coordinates.getY() + 1;
        while(y < 8 && !isBlocked) {
            //if square is empty add 15
            if (board[coordinates.getX()][y] == 0) {
                board[coordinates.getX()][y] += 15;
            } else {
                //If the piece can take add 15
                if (board[coordinates.getX()][y] < 0) {
                    board[coordinates.getX()][y] += 15;
                }
                //Stop the search from moving any further
                isBlocked = true;
            }
            y++;
        }
    }
    public void searchTop(int board[][], Coordinates coordinates) {
        //Search Top
        boolean isBlocked = false;
        int y = coordinates.getY() - 1;
        while(y > -1 && !isBlocked) {
            //if square is empty add 15
            if (board[coordinates.getX()][y] == 0) {
                board[coordinates.getX()][y] += 15;
            } else {
                //If the piece can take add 15
                if (board[coordinates.getX()][y] < 0) {
                    board[coordinates.getX()][y] += 15;
                }
                //Stop the search from moving any further
                isBlocked = true;
            }
            y--;
        }
    }
}
