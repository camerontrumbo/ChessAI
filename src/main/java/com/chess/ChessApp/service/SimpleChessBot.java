package com.chess.ChessApp.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleChessBot {
    private final String RANK_SEPARATOR = "/";
    public String translateBoardToFEN(String[][] board) {
        String fen = "";
        for (int rank = 0; rank < board.length; rank++) {
            // count empty fields
            int empty = 0;
            // empty string for each rank
            String rankFen = "";
            for (int file = 0; file < board[rank].length; file++) {
                if(board[rank][file].length() == 0) {
                    empty++;
                } else {
                    // add the number to the fen if not zero.
                    if (empty != 0) rankFen += empty;
                    // add the letter to the fen
                    rankFen += board[rank][file];
                    // reset the empty
                    empty = 0;
                }
            }
            // add the number to the fen if not zero.
            if (empty != 0) rankFen += empty;
            // add the rank to the fen
            fen += rankFen;
            // add rank separator. If last then add a space
            if (!(rank == board.length-1)) {
                fen += RANK_SEPARATOR;
            } else {
                fen += " ";
            }
        }
        fen = fen +  "b - - 1 11";
        return fen;
    }
}
