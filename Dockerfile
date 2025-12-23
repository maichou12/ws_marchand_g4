# ----------------------------------------------------------------------
# ÉTAPE 1 : Compilation (Build Stage)
# On utilise une image plus lourde mais nécessaire pour compiler le code
FROM eclipse-temurin:17-jdk-focal AS build

# Définir le répertoire de travail à l'intérieur du conteneur
WORKDIR /app

# Copier les fichiers de construction (pom.xml, build.gradle, etc.)
# Ceci permet de mettre en cache les dépendances si seul le code source change
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline

# Copier tout le code source
COPY src src

# Construire l'application Spring (création du JAR)
RUN ./mvnw package -DskipTests

# ----------------------------------------------------------------------
# ÉTAPE 2 : Image d'exécution finale (Runtime Stage)
# On utilise une image légère (JRE seulement) pour l'exécution
FROM eclipse-temurin:17-jre-focal

# Définir des arguments pour la construction (Nom du JAR)
ARG JAR_FILE=target/*.jar

# Définir le répertoire de travail
WORKDIR /app

# Copier le JAR créé à l'étape de compilation vers l'étape finale
COPY --from=build /app/${JAR_FILE} app.jar

# Définir l'utilisateur d'exécution pour améliorer la sécurité
RUN useradd -ms /bin/bash springuser
USER springuser

# Commande à exécuter au lancement du conteneur
# Utilise l'application Spring Boot intégrée au JAR
ENTRYPOINT ["java", "-jar", "app.jar"]