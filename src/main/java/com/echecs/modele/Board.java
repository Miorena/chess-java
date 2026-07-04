package com.echecs.modele;

public class Board {
	private final Piece[][] boardGrid;

	public Board() {
		this.boardGrid = new Piece[8][8];
		initializeBoard();
	}

	private void initializeBoard() {
		String[] initialRow = { "R", "N", "B", "Q", "K", "B", "N", "R" };

		for (int i = 0; i < 8; i++) {
			boardGrid[7][i] = new Piece(initialRow[i], "WHITE");
			boardGrid[0][i] = new Piece(initialRow[i], "BLACK");
			boardGrid[6][i] = new Piece("P", "WHITE");
			boardGrid[1][i] = new Piece("P", "BLACK");
		}
	}

	private boolean isPathClear(int startRow, int startCol, int endRow, int endCol) {
		if (startCol == endCol) {
			int step = (startRow > endRow) ? -1 : 1;
			for (int currentRow = startRow + step; currentRow != endRow; currentRow += step) {
				if (boardGrid[currentRow][startCol] != null) {
					return false;
				}
			}
		} else if (startRow == endRow) {
			int step = (startCol > endCol) ? -1 : 1;
			for (int currentCol = startCol + step; currentCol != endCol; currentCol += step) {
				if (boardGrid[startRow][currentCol] != null) {
					return false;
				}
			}
		}
		return true;
	}

	public void display() {
		System.out.println("\n  0 1 2 3 4 5 6 7"); // Index des colonnes
		for (int i = 0; i < 8; i++) {
			System.out.print(i + " "); // Index des lignes
			for (int j = 0; j < 8; j++) {
				if (boardGrid[i][j] == null) {
					System.out.print(". "); // Case vide
				} else {
					System.out.print(boardGrid[i][j].getPieceName() + " "); // Piece presente
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void movePiece(int startRow, int startCol, int endRow, int endCol) {
		Piece pieceToMove = boardGrid[startRow][startCol];
		Piece pieceAtDestination = boardGrid[endRow][endCol];

		// Verifie s'il y a bien une piece a deplacer
		if (pieceToMove == null) {
			System.out.println("Erreur: Il n'y a pas de piece sur la case de depart");
			return;
		}

		// On demande a la piece si elle a le droit de faire ce mouvement
		if (!pieceToMove.isValidMove(startRow, startCol, endRow, endCol)) {
			System.out.println("Mouvement invalide pour cette piece");
			return;
		}

		if (!isPathClear(startRow, startCol, endRow, endCol)) {
			System.out.println("Deplacement impocible: le chemin est bloqué !");
			return;
		}

		if (pieceAtDestination != null) {
			if (pieceToMove.getPieceColor().equals(pieceAtDestination.getPieceColor())) {
				System.out.println("Erreur: Case de même couleur sur la case cible");
				return;
			}
		}

		boardGrid[endRow][endCol] = pieceToMove;
		boardGrid[startRow][startCol] = null;

		System.out.print("Deplacement reussi");
	}
}