# My Chess Game

Un projet personnel de jeu d'échecs en Java, développé d'abord en mode terminal, avec une interface graphique prévue dans un second temps.

## ⚠️ Statut du projet : EN COURS DE DÉVELOPPEMENT (WIP)

**Ce projet n'est pas encore fonctionnel de bout en bout.** Une refactorisation majeure de l'architecture des pièces est en cours, et le module `Board` n'a pas encore été mis à jour pour s'adapter aux nouvelles classes.

### Ce qui est fait ✅

- `Piece` a été transformée en classe **abstraite** avec deux méthodes abstraites (`getPieceName()`, `isValidMove()`) et deux méthodes partagées (`isStraightLine()`, `isDiagonal()`).
- Chaque type de pièce a désormais sa propre classe, héritant de `Piece` :
  - `Rook` (Tour)
  - `Bishop` (Fou)
  - `Queen` (Dame)
  - `King` (Roi)
  - `Knight` (Cavalier)
  - `Pawn` (Pion) — inclut en plus une méthode `isValidCapture()` dédiée à la prise en diagonale, séparée du déplacement classique.

### Ce qui reste à faire 🚧

- **`Board.java` n'est PAS encore adapté** : `initializeBoard()` utilise encore `new Piece(...)`, ce qui ne compile plus puisque `Piece` est désormais abstraite. **Le projet ne compile pas en l'état.**
- `movePiece()` doit être mis à jour pour gérer le cas particulier du Pion (appeler `isValidMove()` ou `isValidCapture()` selon que la case cible est vide ou occupée par une pièce adverse).
- Pas encore de gestion des tours de jeu (alternance blanc/noir).
- Pas encore de détection d'échec / échec et mat.
- Pas encore de roque, ni de prise en passant, ni de promotion du pion.
- Interface graphique (JavaFX ou Swing) : pas commencée, prévue une fois la logique de jeu en terminal stabilisée.

## Architecture

```
com.echecs
├── Main.java              # Point d'entrée, boucle de jeu en terminal
└── modele
    ├── Piece.java          # Classe abstraite mère
    ├── Rook.java
    ├── Bishop.java
    ├── Queen.java
    ├── King.java
    ├── Knight.java
    ├── Pawn.java
    └── Board.java          # ⚠️ Pas encore à jour avec les sous-classes
```

## Prochaines étapes

1. Adapter `Board.initializeBoard()` pour instancier les bonnes sous-classes.
2. Adapter `Board.movePiece()` pour distinguer déplacement et capture du Pion.
3. Étendre `isPathClear()` pour gérer les diagonales (Fou, Dame).
4. Ajouter la gestion de l'alternance des tours.
5. Détection d'échec et échec et mat.
6. Interface graphique.
