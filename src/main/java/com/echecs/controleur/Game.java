package com.echecs.controleur;
import com.echecs.modele.Board;
import com.echecs.modele.Color;
import com.echecs.modele.Piece;

public class Game {
	private Color playerTurn;
	private Board board;

	public Game(Board board) {
		this.board = board;
		this.playerTurn = Color.WHITE;
	}

	public boolean playerMove(int startRow, int startCol, int endRow, int endCol) {
		Piece pieceToMove = board.getPieceAt(startRow, startCol);
		
		if (pieceToMove == null) {
			System.out.println("Erreur: Il n'y a pas de piece sur la case de depart");
			return false;
		}

		if (pieceToMove.getPieceColor() != playerTurn) {
			System.out.println("Erreur: Ce n'est pas le tour de ce joueur");
			return false;
		}

		boolean moveSuccesful = board.movePiece(startRow, startCol, endRow, endCol);

		if (moveSuccesful) {
			playerTurn = (playerTurn == Color.WHITE ? Color.BLACK : Color.WHITE);
		}

		return moveSuccesful;
	}
}
