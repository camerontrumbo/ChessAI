package com.chess.ChessApp.controller;

import com.chess.ChessApp.dto.Coordinates;
import com.chess.ChessApp.model.ChessBoard;
import com.chess.ChessApp.service.ChessBoardService;
import com.chess.ChessApp.service.MoveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class MoveController {
    @Autowired
    private ChessBoardService chessBoardService;
    @Autowired
    private MoveService moveService;

    @RequestMapping(value = "/getMoves/{x}/{y}", method = RequestMethod.POST)
    public ResponseEntity<?> getPossibleMoves(
            @PathVariable String x,
            @PathVariable String y,
            @RequestBody String chessBoard
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ChessBoard chessBoardMapped = objectMapper.readValue(chessBoard, ChessBoard.class);

        ChessBoard newBoard = chessBoardService.getPieceFromChessboard(chessBoardMapped, new Coordinates(Integer.parseInt(x), Integer.parseInt(y)));
        return new ResponseEntity<>(newBoard, HttpStatus.OK);
    }

    @RequestMapping(value = "/makeMove/{x1}/{y1}/{x2}/{y2}", method = RequestMethod.POST)
    public ResponseEntity<?> makeMove(
            @PathVariable String x1,
            @PathVariable String y1,
            @PathVariable String x2,
            @PathVariable String y2,
            @RequestBody String chessBoard
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ChessBoard chessBoardMapped = objectMapper.readValue(chessBoard, ChessBoard.class);

        ChessBoard newChessBoard = moveService.makeMove(new Coordinates(Integer.parseInt(x1), Integer.parseInt(y1)),
                new Coordinates(Integer.parseInt(x2), Integer.parseInt(y2)), chessBoardMapped);
        return new ResponseEntity<>(newChessBoard, HttpStatus.OK);
    }

    @RequestMapping(value = "/makeStockFishMove/", method = RequestMethod.POST)
    public ResponseEntity<?> makeStockFishMove(
            @RequestBody String chessBoard
    ) throws JsonProcessingException {
        System.out.println("Begin");
        ObjectMapper objectMapper = new ObjectMapper();
        ChessBoard chessBoardMapped = objectMapper.readValue(chessBoard, ChessBoard.class);
        System.out.println("Request Recieved");
        ChessBoard newChessBoard = moveService.makeStockfishMoveMove(chessBoardMapped);
        return new ResponseEntity<>(newChessBoard, HttpStatus.OK);
    }
}
