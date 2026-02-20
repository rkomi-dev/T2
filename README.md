# T2

<p float="left">
  <img alt="Static Badge" src="https://img.shields.io/badge/Backend-Java%20SE%2025-blueviolet?style=for-the-badge&labelColor=rgb(40%2C%2040%2C%2040)">
  &nbsp;
  <img alt="Static Badge" src="https://img.shields.io/badge/Frontend-JavaFX%2025-red?style=for-the-badge&labelColor=rgb(40%2C%2040%2C%2040)">
  &nbsp;  
  <img alt="Static Badge" src="https://img.shields.io/badge/Database-MySQL%208.4.8-lightblue?style=for-the-badge&labelColor=rgb(40%2C%2040%2C%2040)">
  &nbsp;
  <img alt="Static Badge" src="https://img.shields.io/badge/Test-JUnit%204-lightgreen?style=for-the-badge&labelColor=rgb(40%2C%2040%2C%2040)">
  &nbsp;
  <img alt="Static Badge" src="https://img.shields.io/badge/IDE-Eclipse%20-yellow?style=for-the-badge&labelColor=rgb(40%2C%2040%2C%2040)">
</p>

## Requisiti per l'installazione del software

Per far eseguire il sotware in locale bisogna disporre di:

* **JDK 25**
* **JavaFX SDK 25**
* **MYSQL version 8.4.8**
* **JUnit4**
* **JDBC: mysql-connector-j-9.5.0**

## Istruzioni di installazione

* **Clonare la repository**
```bash
git clone https://github.com/rkomi-dev/T2.git
```
* **Creare il database**
1. Spostati nella cartella clonata
```bash
cd T2
```
2.  Eseguire lo script sul terminale
```bash
mysql -u root -p < T2/src/Resources/script_sql/TicketTwo.sql
```
