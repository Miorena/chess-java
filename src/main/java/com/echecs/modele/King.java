package com.echecs.modele;

public class King extends Piece {

	public King(Color colorPiece) {
		super(colorPiece);
	}

	@Override
	public String getPieceName() {
		return "K";
	}

	@Override
	public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
		int deltaCol = endCol - startCol;
		int deltaRow = endRow - startRow;

		if (startRow == endRow && startCol == endCol) {
			return false;
		}

		return (Math.abs(deltaRow) <= 1 && Math.abs(deltaCol) <= 1);
	}
}
