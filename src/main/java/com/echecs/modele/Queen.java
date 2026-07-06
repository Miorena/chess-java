package com.echecs.modele;

public class Queen extends Piece {

	public Queen(Color pieceColor) {
		super(pieceColor);
	}

	@Override
	public String getPieceName() {
		return "Q";
	}

	@Override
	public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
		return (isStraightLine(startRow, startCol, endRow, endCol)) || isDiagonal(startRow, startCol, endRow, endCol);
	}
}
