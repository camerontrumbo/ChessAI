package com.chess.ChessApp.service.moves;

import com.chess.ChessApp.dto.Coordinates;
import com.chess.ChessApp.model.ChessBoard;
import org.springframework.stereotype.Service;

@Service
public class DiagonalService {
    public ChessBoard getPossibleMoves(int board[][], Coordinates coordinates) {
        canMove(board, coordinates);

        return new ChessBoard(board);
    }

    public ChessBoard canMove(int board[][], Coordinates coordinates) {
        searchTopLeft(board, coordinates);
        searchTopRight(board, coordinates);
        searchBottomRight(board, coordinates);
        searchBottomLeft(board, coordinates);

        return new ChessBoard(board);
    }

    public void searchTopRight(int board[][], Coordinates coordinates) {
        //Search top right
        boolean isBlocked = false;
        int x = coordinates.getX() - 1;
        int y = coordinates.getY() + 1;
        while(x > -1 && y < 8 && !isBlocked) {
            //if square is empty add 15
            if (board[x][y] == 0) {
                board[x][y] += 15;
            } else {
                //If the piece can take add 15
                if (board[x][y] < 0) {
                    board[x][y] += 15;
                }
                //Stop the search from moving any further
                isBlocked = true;
            }
            x--;
            y++;
        }
    }
    public void searchTopLeft(int board[][], Coordinates coordinates) {
        //Search top left
        boolean isBlocked = false;
        int x = coordinates.getX() - 1;
        int y = coordinates.getY() - 1;
        while(x > -1 && y > -1 && !isBlocked) {
            //if square is empty add 15
            if (board[x][y] == 0) {
                board[x][y] += 15;
            } else {
                //If the piece can take add 15
                if (board[x][y] < 0) {
                    board[x][y] += 15;
                }
                //Stop the search from moving any further
                isBlocked = true;
            }
            x--;
            y--;
        }
    }
    public void searchBottomRight(int board[][], Coordinates coordinates) {
        //Search bottom right
        boolean isBlocked = false;
        int x = coordinates.getX() + 1;
        int y = coordinates.getY() + 1;
        while(x < 7 && y < 7 && !isBlocked) {
            //if square is empty add 15
            if (board[x][y] == 0) {
                board[x][y] += 15;
            } else {
                //If the piece can take add 15
                if (board[x][y] < 0) {
                    board[x][y] += 15;
                }
                //Stop the search from moving any further
                isBlocked = true;
            }
            x++;
            y++;
        }
    }
    public void searchBottomLeft(int board[][], Coordinates coordinates) {
        //Search bottom left
        boolean isBlocked = false;
        int x = coordinates.getX() + 1;
        int y = coordinates.getY() - 1;
        while(x < 7 && y > -1 && !isBlocked) {
            //if square is empty add 15
            if (board[x][y] == 0) {
                board[x][y] += 15;
            } else {
                //If the piece can take add 15
                if (board[x][y] < 0) {
                    board[x][y] += 15;
                }
                //Stop the search from moving any further
                isBlocked = true;
            }
            x++;
            y--;
        }
    }
}
