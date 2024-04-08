package com.chess.ChessApp.controller;

import com.chess.ChessApp.dto.Coordinates;
import com.chess.ChessApp.model.ChessBoard;
import com.chess.ChessApp.service.ChessBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoveController {
    @Autowired
    private ChessBoardService chessBoardService;
    @RequestMapping(value = "/getMoves/{x}/{y}", method = RequestMethod.GET)
    public ResponseEntity<?> getPossibleMoves(
            @PathVariable String x,
            @PathVariable String y,
            @RequestBody ChessBoard chessBoard
    ) {
        ChessBoard newBoard = chessBoardService.getPieceFromChessboard(chessBoard, new Coordinates(Integer.parseInt(x), Integer.parseInt(y)));
        newBoard.printBoardInNumbers();
        return new ResponseEntity<>(newBoard, HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@RequestBody String test) {
        return test;
    }
}
