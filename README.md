# School

# Prudence - Gestion Scolaire

Ce projet est une application de gestion scolaire développée en Java avec Maven.

## Structure du Projet

- `src/main/java/com/prudence/` : Code source de l'application.
- `src/test/java/com/prudence/tests/` : Tests unitaires.
- `src/main/resources/` : Fichiers de configuration et de logs.

## Dépendances

- MySQL Connector
- Log4j2
- JUnit 5
- Mockito

## Exécution

1. Clonez le dépôt.
2. Configurez la base de données dans `config.properties`.
3. Exécutez `mvn clean install` pour compiler le projet.
4. Exécutez `mvn test` pour lancer les tests unitaires.
5. Exécutez `mvn exec:java -Dexec.mainClass="com.prudence.Main"` pour démarrer l'application.
