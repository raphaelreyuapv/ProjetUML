# ProjetUML - Compilation

Si votre IDE a un support Gradle, executez le fichier build.gradle pour automatiquement installer les dépendences necessaire, sinon ils vous faudra installer
ces deux librairies dans votre JDK:
Slack2D:https://slick.ninjacave.com/
LWJGL 2.9:http://legacy.lwjgl.org/download.php.html

Même si vous avez fais une installation avec Gradle, il faut quand même récupérer le dossier "native" dans la librairie LWJGL,prendre celui qui correspond a votre OS
et le collez dans le ./bin de votre JDK pour Windows,dans le ./lib de votre JDK pour Linux

Si vous exportez le jeu dans un .JAR il faut aussi prendre les assets et les mettre dans le meme dossier que le .JAR du jeu

# Commande

Menu Principal : Start permet de générer une nouvelle grille de jeu, Load permet de charger une grille préalablement sauvegardé

Sélection des personnages : Tous les personnages ont leur propre set de stats différent

En Jeu : Utilisez les touches fléchées pour se déplacer, appuyez sur S a tout moment pour sauvegarder la grille actuel, elle sera mise dans un fichier sauvegarder dans le
même dossier que le jeu

