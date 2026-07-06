package com.echecs.modele;

public class Board {

	private final Piece[][] boardGrid;

	public Board() {
		this.boardGrid = new Piece[8][8];
		initializeBoard();
	}

	private Piece createPiece(String type, Color color) {
		return switch (type) {
			case "R" -> new Rook(color);
			case "N" -> new Knight(color);
			case "B" -> new Bishop(color);
			case "Q" -> new Queen(color);
			case "K" -> new King(color);
			case "P" -> new Pawn(color);
			default -> throw new IllegalArgumentException("Type de piece inconnu: " + type);
		};
	}

	private void initializeBoard() {
		String[] initialRow = { "R", "N", "B", "Q", "K", "B", "N", "R" };

		for (int i = 0; i < 8; i++) {
			boardGrid[7][i] = createPiece(initialRow[i], Color.WHITE);
			boardGrid[0][i] = createPiece(initialRow[i], Color.BLACK);
			boardGrid[6][i] = createPiece("P", Color.WHITE);
			boardGrid[1][i] = createPiece("P", Color.BLACK);
		}
	}

	private boolean isPathClear(int startRow, int startCol, int endRow, int endCol) {
		int deltaRow = endRow - startRow;
		int deltaCol = endCol - startCol;

		if (startCol == endCol) {
			int stepRow = (startRow > endRow) ? -1 : 1;
			for (int currentRow = startRow + stepRow; currentRow != endRow; currentRow += stepRow) {
				if (boardGrid[currentRow][startCol] != null) {
					return false;
				}
			}
		} else if (startRow == endRow) {
			int stepCol = (startCol > endCol) ? -1 : 1;
			for (int currentCol = startCol + stepCol; currentCol != endCol; currentCol += stepCol) {
				if (boardGrid[startRow][currentCol] != null) {
					return false;
				}
			}
		} else if (Math.abs(deltaCol) == Math.abs(deltaRow)) {
			int stepRow = (startRow > endRow) ? -1 : 1;
			int stepCol = (startCol > endCol) ? -1 : 1;
			for (int currentRow = startRow + stepRow, currentCol = startCol
					+ stepCol; currentRow != endRow; currentRow += stepRow, currentCol += stepCol) {
				if (boardGrid[currentRow][currentCol] != null) {
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

	public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
		Piece pieceToMove = boardGrid[startRow][startCol];
		Piece pieceAtDestination = boardGrid[endRow][endCol];

		// Verifie s'il y a bien une piece a deplacer
		if (pieceToMove == null) {
			System.out.println("Erreur: Il n'y a pas de piece sur la case de depart");
			return false;
		}

		if (!isPathClear(startRow, startCol, endRow, endCol)) {
			System.out.println("Deplacement impossible: le chemin est bloque !");
			return false;
		}

		if (pieceAtDestination != null) {
			if (pieceToMove.getPieceColor() == pieceAtDestination.getPieceColor()) {
				System.out.println("Erreur: Case de meme couleur sur la case cible");
				return false;
			}
		}

		boolean isMoveAccepted;
		if (pieceToMove instanceof Pawn pawn && pieceAtDestination != null) {
			isMoveAccepted = pawn.isValidCapture(startRow, startCol, endRow, endCol);
		} else {
			isMoveAccepted = pieceToMove.isValidMove(startRow, startCol, endRow, endCol);
		}

		// On demande a la piece si elle a le droit de faire ce mouvement
		if (!isMoveAccepted) {
			System.out.println("Mouvement invalide pour cette piece");
			return false;
		}

		boardGrid[endRow][endCol] = pieceToMove;
		boardGrid[startRow][startCol] = null;

		System.out.print("Deplacement reussi");
		return true;
	}

	public Piece getPieceAt(int row, int col) {
		return boardGrid[row][col];
	}
}