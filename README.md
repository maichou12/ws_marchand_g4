# 🧾 WS Marchand – Microservice Spring Boot

Ce projet est un microservice **Spring Boot** exposant une API (REST / GraphQL) pour la gestion des marchands.  
L’application est **conteneurisée avec Docker** et peut être lancée facilement via **Docker Compose**, sans compilation locale.

---

## Prérequis

Avant de commencer, assurez-vous d’avoir installé :

- Docker (≥ 20.x)
- Docker Compose (v2 recommandé)

Vérification :
```bash
docker --version
docker compose version
```
---

###  Image Docker

L’image de l’application est disponible sur Docker Hub :
```bash
dji7/ws_marchand:dev
```
---

### Lancement de l’application
1.Cloner le projet (ou récupérer le docker-compose.yml)
```bash
git clone git@github.com:maichou12/ws_marchand_g4.git
cd ws_marchand_g4
```
2.Télécharger les images Docker
```bash
docker compose pull
```
3.Démarrer les services
```bash
docker compose -f .\docker-compose_dev.yml up -d
```

##  Accès à l’application

| Fonction | URL |
|----------|-----|
| API / GraphQL | http://localhost:8082/graphql |
| Base PostgreSQL | localhost:5432 |

## Configuration de la base de données

Paramètres PostgreSQL par défaut :

| Paramètre   | Valeur            |
|------------|------------------|
| Database   | ws_marchand_g4    |
| Utilisateur| postgres          |
| Mot de passe | passer          |
| Port       | 5432              |

## Problèmes courants

### Port déjà utilisé

Modifier le `docker-compose_prod.yml` :

```yaml
ports:
  - "8090:8082"
```
---

### Technologies utilisées

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Docker / Docker Compose
- GraphQL
- OpenFeign / WebClient

---

### Note importante
L’application est configurée pour contacter un microservice externe **TRX-ENGINE** à l’adresse `http://localhost:8081`.
Assurez-vous que ce service est opérationnel pour éviter les erreurs de connexion.

##  Auteur

Projet académique – **M2GL 2024–2025**  
Microservice : **WS Marchand**
