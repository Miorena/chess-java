# My Chess Game
Un projet personnel de jeu d'échecs en Java, développé d'abord en mode terminal, avec une interface graphique prévue dans un second temps.
## ⚠️ Statut du projet : EN COURS DE DÉVELOPPEMENT (WIP)
Le cœur du jeu (règles de déplacement, plateau, tours) est fonctionnel et testé en terminal. Il manque encore des règles avancées (échec, roque, promotion) et l'interface graphique.
### Ce qui est fait ✅
- `Piece` est une classe **abstraite** avec deux méthodes abstraites (`getPieceName()`, `isValidMove()`) et deux méthodes partagées (`isStraightLine()`, `isDiagonal()`).
- Chaque type de pièce a sa propre classe, héritant de `Piece` :
- `Rook` (Tour)
- `Bishop` (Fou)
- `Queen` (Dame)
- `King` (Roi)
- `Knight` (Cavalier)
- `Pawn` (Pion) — avec en plus `isValidCapture()`, dédiée à la prise en diagonale, séparée du déplacement classique.
- La couleur des pièces utilise désormais un `enum Color` (`WHITE`/`BLACK`) plutôt qu'un `String`.
- `Board.createPiece()` instancie la bonne sous-classe selon le type de pièce.
- `Board.initializeBoard()` peuple correctement le plateau avec les vraies sous-classes.
- `Board.isPathClear()` gère les 3 cas de déplacement : vertical, horizontal, et diagonal.
- `Board.movePiece()` vérifie qu'une pièce est bien présente sur la case de départ, que le chemin est dégagé, empêche de capturer une pièce de sa propre couleur, distingue le déplacement classique du Pion (`isValidMove()`) de sa capture en diagonale (`isValidCapture()`), et renvoie un `boolean` indiquant si le coup a été accepté.
- `Game.playerMove()` orchestre une partie complète : vérifie que c'est bien le tour du joueur propriétaire de la pièce, délègue le coup à `Board.movePiece()`, et alterne le tour (`WHITE`/`BLACK`) si le coup est accepté.
- `Main.java` utilise désormais `Game` (et non plus `Board` directement) pour jouer un coup — le flux complet a été testé en terminal avec succès (déplacements, captures, alternance des tours).
### Ce qui reste à faire 🚧
- Pas encore de détection d'échec / échec et mat.
- Pas encore de roque, ni de prise en passant, ni de promotion du pion.
- Pas encore de validation empêchant un joueur de se mettre lui-même en échec.
- Interface graphique (JavaFX ou Swing) : pas commencée, prévue une fois la logique de jeu en terminal stabilisée.
## Architecture
```
com.echecs
├── Main.java              # Point d'entrée, boucle de jeu en terminal
├── controleur
│   └── Game.java          # Gestion des tours, orchestre les coups
└── modele
    ├── Piece.java          # Classe abstraite mère
    ├── Color.java          # Enum WHITE / BLACK
    ├── Rook.java
    ├── Bishop.java
    ├── Queen.java
    ├── King.java
    ├── Knight.java
    ├── Pawn.java
    └── Board.java          # Plateau, création des pièces, validation des coups
```
## Prochaines étapes
1. Détection d'échec et échec et mat (nécessite de simuler un coup et vérifier si le Roi est menacé).
2. Empêcher un joueur de jouer un coup qui le mettrait lui-même en échec.
3. Roque, prise en passant, promotion du pion.
4. Interface graphique.