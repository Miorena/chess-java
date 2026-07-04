package com.echecs.modele;

public class Piece {
	private final String pieceName;
	private final String pieceColor;

	public Piece(String pieceName, String pieceColor) {
		this.pieceName = pieceName;
		this.pieceColor = pieceColor;
	}

	public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
		// Si la piece ne bouge pas du tout, le mouvement est refuse
		if (startRow == endRow && startCol == endCol) {
			return false;
		}

		// La Tour R ne peut bouger que si elle reste sur la meme ligne ou colonne
		if (pieceName.equals("R")) {
			return (startRow == endRow) || (startCol == endCol);
		}

		// Le Pion P ne peut bouger que si elle reste sur la meme colonne
		if (pieceName.equals("P") && pieceColor.equals("WHITE")) {
			return (startCol == endCol) && (endRow == startRow - 1);
		}

		if (pieceName.equals("P") && pieceColor.equals("BLACK")) {
			return (startCol == endCol) && (endRow == startRow + 1);
		}

		return true;
	}

	public String getPieceName() {
		return pieceName;
	}

	public String getPieceColor() {
		return pieceColor;
	}
}
