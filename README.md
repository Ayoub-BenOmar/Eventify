# 🎉 Eventify – Secured Event Management API

Eventify est une application **Spring Boot REST API** permettant de gérer des événements avec une **sécurité basée sur Spring Security (Basic Auth)** et des **rôles stockés en base de données**.

---

## 🚀 Fonctionnalités

- Inscription des utilisateurs
- Gestion des rôles (USER, ORGANIZER, ADMIN)
- Création, modification et suppression d’événements
- Inscription des utilisateurs aux événements
- Sécurisation complète des endpoints par rôle
- Architecture **stateless** (API REST)

---

## 🧑‍💻 Rôles et permissions

| Rôle | Permissions |
|------|------------|
| ROLE_USER | Consulter son profil, s’inscrire à un événement, voir ses inscriptions |
| ROLE_ORGANIZER | Créer, modifier et supprimer ses événements |
| ROLE_ADMIN | Gérer les utilisateurs et supprimer n’importe quel événement |

📌 Chaque utilisateur possède **un seul rôle**.

---

## 🔐 Sécurité

- Authentification : **HTTP Basic Authentication**
- Password Encoder : **BCryptPasswordEncoder**
- Utilisateurs et rôles stockés en base de données
- `CustomAuthenticationProvider`
- `UserDetailsService` personnalisé
- API Stateless :
    - `SessionCreationPolicy.STATELESS`
    - CSRF désactivé

### Règles d’accès

- /api/public/** → accès libre
- /api/user/** → ROLE_USER
- /api/organizer/** → ROLE_ORGANIZER
- /api/admin/** → ROLE_ADMIN

---

## 📦 Endpoints

### 🟢 Public
| Méthode | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/public/users | Inscription utilisateur |
| GET | /api/public/events | Liste des événements publics |

### 🔵 User
| Méthode | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/user/profile | Profil utilisateur |
| POST | /api/user/events/{id}/register | Inscription à un événement |
| GET | /api/user/registrations | Mes inscriptions |

### 🟠 Organizer
| Méthode | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/organizer/events | Créer un événement |
| PUT | /api/organizer/events/{id} | Modifier un événement |
| DELETE | /api/organizer/events/{id} | Supprimer un événement |

### 🔴 Admin
| Méthode | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/admin/users | Liste des utilisateurs |
| PUT | /api/admin/users/{id}/role | Modifier le rôle d’un utilisateur |
| DELETE | /api/admin/events/{id} | Supprimer un événement |

---

## 🧪 Tests avec Postman

Tous les endpoints sécurisés utilisent **Basic Auth**.

- Authorization → Basic Auth
- Username: client@test.com
- Password: 123456


---

## 🧪 Profil de test

Un profil Spring `test` est configuré pour :
- Bypasser la vérification du mot de passe
- Faciliter les tests Postman et automatisés

Activation :
spring.profiles.active=test

---

## ⚙️ Technologies utilisées

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- H2 / PostgreSQL / MySQL
- Maven

---

## ▶️ Lancer le projet
- mvn clean install
- mvn spring-boot:run


---

## 👨‍🎓 Contexte pédagogique

Projet conçu pour :
- Comprendre Spring Security
- Implémenter une sécurité par rôles
- Créer une API REST sécurisée
- Tester les accès avec Postman

---

## ✨ Auteur

Ayoub Ben Omar  
Projet Spring Boot – Sécurité & API REST

