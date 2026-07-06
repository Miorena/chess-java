package com.echecs;

import com.echecs.controleur.Game;
import com.echecs.modele.Board;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== My Chess Game ===");

		Board board = new Board();
		Game game = new Game(board);
		Scanner scanner = new Scanner(System.in);
		boolean isRunning = true;

		while(isRunning) {
			board.display();
			
			System.out.println("--- c'est votre tour (Format: Ligne Colonne)");

			System.out.print("Ligne de depart (0-7): ");
			int startRow = scanner.nextInt();
			System.out.print("Colonne de depart (0-7): ");
			int startCol = scanner.nextInt();

			System.out.print("Ligne d'arrivee (0-7): ");
			int endRow = scanner.nextInt();
			System.out.print("Colonne d'arrivee (0-7): ");
			int endCol = scanner.nextInt();

			System.out.println("\nAction enregistree...");
			game.playerMove(startRow, startCol, endRow, endCol);

			System.out.println("==============================================");
		}
		scanner.close();
	}
}