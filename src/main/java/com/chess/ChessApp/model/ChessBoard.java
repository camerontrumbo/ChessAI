package com.chess.ChessApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChessBoard {
    int[][] chessBoard;

    public void printBoardInNumbers() {
        System.out.printf("\n\n\n");
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (chessBoard[x][y] > -1 && chessBoard[x][y] < 10) {
                    System.out.printf(" " + chessBoard[x][y]);
                } else {
                    System.out.printf(String.valueOf(chessBoard[x][y]));
                }
                System.out.printf(" | ");
            }
            System.out.printf("\n---------------------------------\n");
        }
    }
}
