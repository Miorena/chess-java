package com.echecs.modele;

public class Knight extends Piece {
	public Knight(String pieceColor) {
		super(pieceColor);
	}

	@Override
	public String getPieceName() {
		return "N";
	}

	@Override
	public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
		int deltaCol = endCol - startCol;
		int deltaRow = endRow - startRow;

		if (startRow == endRow && startCol == endCol) {
			return false;
		}

		return ((Math.abs(deltaRow) == 2 && Math.abs(deltaCol) == 1) || (Math.abs(deltaRow) == 1 && Math.abs(deltaCol) == 2));
	}
}
