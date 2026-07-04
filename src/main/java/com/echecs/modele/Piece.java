package com.echecs.modele;

public abstract class Piece {
	// Attribut
	private final String pieceColor;

	// Constructeur
	public Piece(String pieceColor) {
		this.pieceColor = pieceColor;
	}

	// Getter concrète
	public String getPieceColor() {
		return pieceColor;
	}

	// Getter abstraite
	public abstract String getPieceName();

	// Methode abstraite
	public abstract boolean isValidMove(int startRow, int startCol, int endRow, int endCol);

	// Method concrète
	protected boolean isStraightLine(int startRow, int startCol, int endRow, int endCol) {
		if (startRow == endRow && startCol == endCol) {
			return false;
		}
		return (startRow == endRow) || (startCol == endCol);
	}

	protected boolean isDiagonal(int startRow, int startCol, int endRow, int endCol) {
		int deltaRow = endRow - startRow;
		int deltaCol = endCol - startCol;

		if (startRow == endRow && startCol == endCol) {
			return false;
		}

		return (Math.abs(deltaCol) == Math.abs(deltaRow));
	}
}