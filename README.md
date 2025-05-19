# 🌲 Dictionnaire : Arbre Binaire de Recherche vs Liste Chaînée

Projet réalisé dans le cadre du TP Algo & Prog 5 — Université du Havre  
Encadré par : Eric Sanlaville

---

## 👨‍💻 Auteur

**Baouche Mohamed Djaouad**

---

## 🎯 Objectif du projet

L’objectif est d’implémenter le **type abstrait dictionnaire** sous deux formes :

1. Avec une **liste chaînée**
2. Avec un **arbre binaire de recherche (ABR)**

Puis de **comparer leur efficacité** (temps d’insertion et de suppression) sur de grands ensembles de données.

---

## 🧱 Structure des éléments

Chaque élément du dictionnaire est une paire :

- `clé` : entier (int)
- `valeur` : flottant (float)

Toutes les clés sont **distinctes** (comportement de dictionnaire).

---

## 🧩 Fonctionnalités à implémenter

- `ajouter` : ajoute un élément au dictionnaire
- `chercher` : retourne un élément à partir de sa clé, ou `null` s’il n’existe pas
- `afficher` :
  - **ABR** : affichage dans l’ordre croissant des clés (infixe)
  - **Liste** : affichage dans l’ordre d’insertion
- `supprimer` : supprime un élément donné (par clé)

Les méthodes `chercher`, `afficher`, `supprimer` sont récursives pour l'ABR.
