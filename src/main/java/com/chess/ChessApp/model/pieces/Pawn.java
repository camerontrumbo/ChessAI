package com.chess.ChessApp.model.pieces;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pawn {
    private Integer pieceId;
    private boolean isWhite;
    private boolean isPieceCaptured;

    public void canPromote() {
    }
    public void canMove() {
    }
    public void canTake() {
    }
}
