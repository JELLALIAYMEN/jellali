# Utilisation d'une image de base pour Java (par exemple, adoptopenjdk)
FROM adoptopenjdk/openjdk11:alpine-slim

# Répertoire de travail à l'intérieur du conteneur
WORKDIR /app

# Copie du fichier JAR de l'application dans le conteneur (assurez-vous que le JAR est déjà construit)
COPY target/your-document-service.jar /app/EcoleDoc.jar

# Commande pour exécuter l'application Spring Boot lorsque le conteneur démarre
CMD ["java", "-jar", "/app/your-document-service.jar"]

# Exposer le port 8080 sur le conteneur (ce port doit correspondre au port exposé dans votre docker-compose.yml)
EXPOSE 8080
