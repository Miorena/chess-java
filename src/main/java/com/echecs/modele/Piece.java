package com.echecs.modele;

public abstract class Piece {

	private final Color pieceColor;

	public Piece(Color pieceColor) {
		this.pieceColor = pieceColor;
	}

	public Color getPieceColor() {
		return pieceColor;
	}

	public abstract String getPieceName();

	public abstract boolean isValidMove(int startRow, int startCol, int endRow, int endCol);

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