package com.chess.ChessApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockFish {
    String success;
    String evaluation;
    String mate;
    String bestmove;
    String continuation;
}
