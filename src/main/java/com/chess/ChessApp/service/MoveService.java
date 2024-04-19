package com.chess.ChessApp.service;

import com.chess.ChessApp.dto.Coordinates;
import com.chess.ChessApp.model.ChessBoard;
import com.chess.ChessApp.model.StockFish;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class MoveService {
    @Autowired
    private SimpleChessBot simpleChessBot;
    public ChessBoard makeMove(Coordinates coordinates1, Coordinates coordinates2, ChessBoard chessBoard) {
        int[][] board = chessBoard.getChessBoard();
        board[coordinates2.getX()][coordinates2.getY()] = board[coordinates1.getX()][coordinates1.getY()];
        board[coordinates1.getX()][coordinates1.getY()] = 0;

        return new ChessBoard(board);
    }

    public ChessBoard makeStockfishMoveMove(ChessBoard chessBoard) {
        int[][] board = chessBoard.getChessBoard();

        char[] charArray = getMoveFromStockFish(board);
        makeStockFishMove(board, charArray);
        System.out.println("Request Completed");

        return new ChessBoard(board);
    }

    public char[] getMoveFromStockFish(int[][] board) {
        String[][] chessBoardString = new String[8][8];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                //PAWN
                if (board[x][y] == 1) {
                    chessBoardString[x][y] = "P";
                } else if (board[x][y] == -1) {
                    chessBoardString[x][y] = "p";
                }
                //KNIGHT
                if (board[x][y] == 2) {
                    chessBoardString[x][y] = "N";
                } else if (board[x][y] == -2) {
                    chessBoardString[x][y] = "n";
                }
                //BISHOP
                if (board[x][y] == 3) {
                    chessBoardString[x][y] = "B";
                } else if (board[x][y] == -3) {
                    chessBoardString[x][y] = "b";
                }
                //ROOK
                if (board[x][y] == 4) {
                    chessBoardString[x][y] = "R";
                } else if (board[x][y] == -4) {
                    chessBoardString[x][y] = "r";
                }
                //QUEEN
                if (board[x][y] == 5) {
                    chessBoardString[x][y] = "Q";
                } else if (board[x][y] == -5) {
                    chessBoardString[x][y] = "q";
                }
                //KING
                if (board[x][y] == 6) {
                    chessBoardString[x][y] = "K";
                } else if (board[x][y] == -6) {
                    chessBoardString[x][y] = "k";
                }
                //EMPTY
                if (board[x][y] == 0) {
                    chessBoardString[x][y] = "";
                }
            }
        }
        String fentString = simpleChessBot.translateBoardToFEN(chessBoardString);
        return callStockFishAPI(fentString);
    }

    public char[] callStockFishAPI(String fen) {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("111111111\n" + fen);
        RestTemplate restTemplate = new RestTemplate();
        String URI = "https://stockfish.online/api/s/v2.php";
        HttpEntity<String> entity = new HttpEntity<>(fen);
        String urlTemplate = UriComponentsBuilder.fromHttpUrl("https://stockfish.online/api/s/v2.php")
                .queryParam("fen", fen)
                .queryParam("depth", "10").encode().toUriString();
        StockFish stockFish = new StockFish();
        try {
            ResponseEntity<?> resultEntity = restTemplate.exchange(urlTemplate, HttpMethod.GET, entity, String.class);
            stockFish = objectMapper.readValue((String) resultEntity.getBody(), StockFish.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        String[] bodyMap = stockFish.getBestmove().split(" ");
        char[] bestMoveCharArray = bodyMap[1].toCharArray();
        return bestMoveCharArray;
    }

    public void makeStockFishMove(int[][] board, char[] bestMoveArray) {
        board[getXFromCharArray(bestMoveArray[3])][getYFromCharArray(bestMoveArray[2])] =
                board[getXFromCharArray(bestMoveArray[1])][getYFromCharArray(bestMoveArray[0])];
        board[getXFromCharArray(bestMoveArray[1])][getYFromCharArray(bestMoveArray[0])] = 0;
    }

    public int getYFromCharArray(char letter) {
        if (letter == 'a') return 0;
        else if (letter == 'b') return 1;
        else if (letter == 'c') return 2;
        else if (letter == 'd') return 3;
        else if (letter == 'e') return 4;
        else if (letter == 'f') return 5;
        else if (letter == 'g') return 6;
        else if (letter == 'h') return 7;

        return 0;
    }

    public int getXFromCharArray(char letter) {
        if (letter == '1') return 7;
        else if (letter == '2') return 6;
        else if (letter == '3') return 5;
        else if (letter == '4') return 4;
        else if (letter == '5') return 3;
        else if (letter == '6') return 2;
        else if (letter == '7') return 1;
        else if (letter == '8') return 0;

        return 0;
    }
}
