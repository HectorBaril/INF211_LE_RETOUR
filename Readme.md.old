

# Environnement Dockerisé pour le FilRouge


## Contenu du répertoire
- *compose.yaml* fichier de configuration pour *docker compose*
- *Data/* contient les données pour peupler la base de données (*cabinet_recrutement_bd*) et la configuration de *pg_admin*
- *dev/* contient à l'application de gestion du cabiinet de recrutement
  - *Dockerfile* pour construire l'image qui constrituera votre environnement de développement pour modifier l'application.
  - *cabinet_recrutement/* est le répertoire contenant l'application composée :
    - *cabinet_recrutement-ear/* qui n'est que le réceptacle pour l'application à générer
    - *cabinet_recrutement-ejb/* qui contient le code source des objets métiers
    - *cabinet_recrutement-web/* qui contient le code source de le partie frontend de l'application (*servlets*, pages *jsp*, etc.)
- *servapp/* contient le fichier *Dockerfile* de configuration de l'image du serveur d'application *wildfly* utilisé et les fichers de configuration pour la liaison avec la base de données *PostgreSQL*

## Routine de construction
Construction de l'archetype Maven pour un projet J2EE complet de type ear (war + ejb.jar), vous n'avez pas à utiliser cette commande. C'est juste une indication sur la façon dont la structure du répertoire de développement est généré par Maven à partir d'un template :
- `mvn archetype:generate -DgroupId=eu.telecom_bretagne.cabinet_recrutement -DartifactId=cabinet_recrutement -DarchetypeArtifactId=wildfly-javaee8-webapp-ear-archetype -DarchetypeGroupId=org.wildfly.archetype -DinteractiveMode=false`

Construction des images (depuis le répertoire *FilRouge/*):
- `docker compose build` pour créer les images *servapp* et *envdev_inf211*
Gestion des services (depuis le répertoire *FilRouge/*):
- `docker compose up` démarre les services (containers) de nom *pgadmin4*, *servapp_wildfly* et *serv_postgres*
- `docker compose down` arrête les services (containers) de nom *pgadmin4*, *servapp_wildfly* et *serv_postgres*
- `docker container prune` supprime les containers des services (containers) de nom *pgadmin4*, *servapp_wildfly* et *serv_postgres*

Gestion de l'application (depuis le répertoire *FilRouge/dev/cabinet_recrutement/*) :
- `mvn clean install` pour supprimer le répertoire de destination des compilations (*clean*) et compiler l'application afin de générer une archive *ear* de l'application  (*install*).
- `mvn wildfly:deploy` pour déployer l'application dans le serveur d'application *wildfly* (container *servapp_wildfly*)
 - `mvn wildfly:undeploy` pour retirer l'application du serveur d'application *wildfly* (container *servapp_wildfly*)


### Accès aux services 

Une fois les images construites (`docker compose build`) puis les services démarrés (`docker compose up`), vous pouvez accéder :

- à l'interface de (*PgAdmin4*)[http://127.0.0.1:8080] (Authentification : pguser@admin.com / pgpwd)
- au gestionnaire du serveur d'application (*Wildfly*)[http://127.0.0.1:9990] (Authentification : admin / Admin#007)


### Utilisation de l'environnement de développement (programmation)

Positionné dans le répertoire *FilRouge/*, vous pouvez démarrer un conteneur qui vous servira de lanceur d'application. Ce conteneur est démarré à partir de l'image *envdev_inf211* construite précédemment en exécutant la commande suivante :
- `docker run --network=filrouge_vnet_filrouge --ip 10.5.0.9 -it --mount type=bind,source=$(pwd)/dev/cabinet_recrutement/,target=/app envdev_inf211 /bin/bash`

 Pour information, elle permet de connecter le conteneur au réseau virtuel nommé *filrouge_vnet_filrouge* dans lequel se trouvent également les conteneurs *PostgreSQL* et *PgAdmin4*. L'option *mount* permet de monter le répertoire *./dev/cabinet_recrutement* de votre machine dans l'arborescense du conteneur à l'emplacement */app*. Utilisez l'éditeur de programmation de votre choix (Eclipse, Visual Code, emacs, notepad++, etc.) pour visualiser et modifier le code de l'application.

Si le démarrage du conteneur a fonctionné, vous devez vous retrouver dans un *bash* au sein du conteneur de développement.
- déplacez-vous dans le répertoire */app*.
Ce répertoire contient un projet *maven* avec son fichier de configuration *pom.xml* et les sources de l'application dans le répertoire *src/*
- compilez les sources avec la commande `mvn clean install`. Le résultat de la compilation se trouve dans les répertoires *target/* des différents modules (*ejb*, *war*, *ear*)
- exécutez le code avec la commande `mvn wildfly:deploy` pour déployer l'application et `mvn wildfly:undeploy` pour la retirer du serveur d'application


Une approche bottom-up est utilisée pour générer le code des classes *Java* (*MOJOs*) à partir de la base de données. Le plugin *maven* *org.hibernate* permet d'effectuer cette génération. Pour utiliser ce plugin, vous devez vous placer dans le répertoire *cabinet_recrutement-ejb/* et utiliser la commande suivante :
- `mvn hibernate-tools:hbm2java`
Le plugin est notamment configuré dans le fichier *xml* disponible à l'emplacement suivant :
- *FilRouge/cabinet_recrutement-ejb/src/main/resources/META-INF/hibernate.reveng.xml*
Vous pouvez consulter la documentation du plugin à l'adresse suivante (ICI)[https://docs.jboss.org/tools/3.3.0.Final/en/hibernatetools/html/reverseengineering.html#hibernaterevengxmlfile]