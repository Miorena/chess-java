package com.echecs.modele;

public class Bishop extends Piece {
	public Bishop(String pieceColor) {
		super(pieceColor);
	}

	@Override
	public String getPieceName() {
		return "B";
	}

	@Override
	public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
		return isDiagonal(startRow, startCol, endRow, endCol);
	}
}
