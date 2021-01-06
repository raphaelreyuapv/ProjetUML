# ProjetUML - Compilation

Si votre IDE a un support Gradle,executez le fichier build.gradle pour automatiquement installé les dépendences necessaire,sinon ils vous faudra installez
ces deux librairies dans votre JDK:
Slack2D:https://slick.ninjacave.com/
LWJGL 2.9:http://legacy.lwjgl.org/download.php.html

Meme si vous avez fais une installation avec Gradle,ils font quand meme recuperer le dossier "native" dans la librairie LWJGL,prendre celui qui correspond a votre OS
et le collez dans le ./bin de votre JDK pour Windows,dans le ./lib de votre JDK pour Linux

Si vous exportez le jeu dans un .JAR il faut aussi prendre les assets et les mettres dans le meme dossier que le .JAR du jeu

# Commande

Menu Principal:Start permet de generer une nouvelle grille de jeu,Load permet de charger une grille préaleblement sauvegarder

Selection des personnages:touts les personnages ont leur propre set de stats différents

En Jeu:utiliser les touches fléché pour se déplacer,appuyez sur S a tout moment pour sauvegarder la grille actuel,elle sera mit dans un fichier sauvegarder dans le
meme dossier que le jeu

