# Backstage
Workshop Android CRM14

Backstage n'est pas terminé, l'application ne comprend pas le chiffrage du chat mais aussi le hachage des mots de passe qui se trouve encore en clair dans la base de données. Je n'ai pas compris le fonctionnement de cryptage.

La page d'accueil est constituée de 3 fragments. Et d'une toolbar permettant de se déplacer entre le fragment home, register et login.

#Fragment Initial Home

Ce fragment est simplement composé de 2 boutons. Le premier envoie le fragment register, et le deuxième au fragment login.

#S'enregistrer

Pour s'enregister il faut un pseudo, une adresse mail et un mot de passe, une color aléatoire est attribuée à chaque compte.
La classe application permet de faire appel à la base de données (firebase) partout dans l'application.
Une classe User est appelée afin de créer les utilisateurs.
C'est dans la classe authentification que tous se déroulent.
La méthode createUser permet de créer un utilisateur, elle fait appelle à un listener de firebase.
Cette methode est appelé dans le fragment RegisterFragment, au click sur le bouton envoie un listener à main activity qui crée l'utilisateur dans la base de données.

#S'authentifier

L'authentification se déroule à peu près de la même façon, mais dans le fragment LoginFragment et avec la méthode authenticate qui permet de vérifier si le mail et le mot de passe correspondent.
La méthode getUserById dans la classe d'authentification permet de récupérer le user et ainsi récupéré son pseudo, son mail, son mot de passe et sa couleur associé.

#Chat
J'ai suivi un tutoriel pour le chat et je n'ai pas tout compris ce que j'ai réalisé.
Alors voilà ce que j'ai compris.
La classe Chat permet de créer un chat avec un message et un auteur.
ChatListAdapter permet de gérer la vue du chat
FirebaseListAdapter<T> permet de gérer les utilisateurs du chat (j'admet c'est un peu flou)
ChatListFragment le fragment permettant d'afficher le chat dans chat activity qui est composé de deux fragments : ChatListFragment et UserProfilFragment

#Profil
Le profil affiche les donnés de l'utilisateur grace à la classeUser.
Je n'ai pas fait l'update.
