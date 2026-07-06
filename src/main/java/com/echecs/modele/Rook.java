package com.echecs.modele;

public class Rook extends Piece {

	public Rook(Color pieceColor) {
		super(pieceColor);
	}

	@Override
	public String getPieceName() {
		return "R";
	}

	@Override
	public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
		return isStraightLine(startRow, startCol, endRow, endCol);
	}
}
