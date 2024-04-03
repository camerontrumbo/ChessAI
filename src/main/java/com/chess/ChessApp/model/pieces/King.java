package com.chess.ChessApp.model.pieces;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class King {
    private Integer pieceId;
    private boolean isWhite;

    public void canMove() {
    }
    public void canTake() {
    }
    public void isCheck() {
    }
}
