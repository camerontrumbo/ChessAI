package com.chess.ChessApp.model;

public class Piece<T> {
    final Class<T> pieceClass;

    public Piece(Class<T> pieceClass) {
        this.pieceClass = pieceClass;
    }

    public void mooingBattlePass() {

    }
}
