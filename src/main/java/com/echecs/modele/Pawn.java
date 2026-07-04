package com.echecs.modele;

public class Pawn extends Piece {
	public Pawn(String pieceColor) {
		super(pieceColor);
	}

	@Override
	public String getPieceName() {
		return "P";
	}

	@Override
	public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
		int pawnDirection = getPieceColor().equals("BLACK") ? 1 : -1;
		int pawnStartingRow = getPieceColor().equals("BLACK") ? 1 : 6;

		if (startRow == endRow && startCol == endCol) {
			return false;
		}

		boolean isOneStepForward = (startCol == endCol) && (endRow == startRow + pawnDirection);
		boolean isTwoStepForward = (startCol == endCol) && (endRow == startRow + 2 * pawnDirection)
				&& pawnStartingRow == startRow;

		return isOneStepForward || isTwoStepForward;
	}

	public boolean isValidCapture(int startRow, int startCol, int endRow, int endCol) {
		int pawnDirection = getPieceColor().equals("BLACK") ? 1 : -1;

		if (startRow == endRow && startCol == endCol) {
			return false;
		}

		return ((Math.abs(endCol - startCol) == 1) && (endRow == startRow + pawnDirection));
	}
}
