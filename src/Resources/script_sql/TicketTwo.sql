-- Creazione del Database
CREATE DATABASE IF NOT EXISTS TicketTwo;
USE TicketTwo;

-- 1. Tabella Utente (Indipendente)
CREATE TABLE Utente (
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    email VARCHAR(191) PRIMARY KEY, 
    password VARCHAR(255) NOT NULL,
    data_nascita DATE NOT NULL,
    nome_organizzazione VARCHAR(255) DEFAULT NULL 
) ENGINE=InnoDB;

-- 2. Tabella Sede (Indipendente)
CREATE TABLE Sede (
    id_sede INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    indirizzo VARCHAR(255) NOT NULL,
    CONSTRAINT unique_sede UNIQUE(nome, indirizzo)
) ENGINE=InnoDB;

-- 3. Tabella Artista (Indipendente - Spostata qui per permettere il riferimento in Evento)
CREATE TABLE Artista (
    id_artista INT AUTO_INCREMENT PRIMARY KEY,
    nome_darte VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

-- 4. Tabella Settore (Dipende da Sede)
CREATE TABLE Settore (
    id_settore INT AUTO_INCREMENT PRIMARY KEY,
    id_sede INT NOT NULL,
    nome_settore ENUM('Platea', 'Parterre', 'Tribuna', 'Curva') NOT NULL,
    tipo_posti ENUM('numerato', 'non_numerato') NOT NULL,
    capienza_max INT NOT NULL,
    CONSTRAINT fk_settore_sede FOREIGN KEY (id_sede) 
        REFERENCES Sede(id_sede) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 5. Tabella Posto (Dipende da Settore)
CREATE TABLE Posto (
    id_posto INT AUTO_INCREMENT PRIMARY KEY,
    id_settore INT NOT NULL,
    fila INT NOT NULL,
    colonna INT NOT NULL,
    prefisso VARCHAR(10),
    CONSTRAINT fk_posto_settore FOREIGN KEY (id_settore) 
        REFERENCES Settore(id_settore) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 6. Tabella Evento (Dipende da Sede, Utente e Artista)
CREATE TABLE Evento (
    id_evento INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_ora DATETIME NOT NULL,
    tipologia ENUM('concerto', 'teatro', 'sport') NOT NULL,
    id_sede INT NOT NULL,
    email_organizzatore VARCHAR(191) NOT NULL,
    id_artista INT,
    CONSTRAINT fk_evento_sede FOREIGN KEY (id_sede) 
        REFERENCES Sede(id_sede),
    CONSTRAINT fk_evento_organizzatore FOREIGN KEY (email_organizzatore) 
        REFERENCES Utente(email),
    CONSTRAINT fk_evento_artista FOREIGN KEY (id_artista) 
        REFERENCES Artista(id_artista)
) ENGINE=InnoDB;

-- 7. Tabella Tariffa (Dipende da Evento e Settore)
CREATE TABLE Tariffa (
    id_tariffa INT AUTO_INCREMENT PRIMARY KEY,
    id_evento INT NOT NULL,
    tipologia_biglietto ENUM('VIP', 'STANDARD', 'VISIBILITA_LIMITATA') NOT NULL,
    prezzo_finale DECIMAL(10,2) NOT NULL,
    id_settore INT,
    CONSTRAINT fk_tariffa_evento FOREIGN KEY (id_evento) 
        REFERENCES Evento(id_evento) ON DELETE CASCADE,
    CONSTRAINT fk_tariffa_settore FOREIGN KEY (id_settore)
        REFERENCES Settore(id_settore)
) ENGINE=InnoDB;

-- 8. Tabella Biglietto (Dipende da Evento, Posto, Settore e Utente)
CREATE TABLE Biglietto (
    id_biglietto INT AUTO_INCREMENT PRIMARY KEY,
    id_evento INT NOT NULL,
    id_posto INT DEFAULT NULL, 
    id_settore INT NOT NULL,    
    email_cliente VARCHAR(191),
    nominativo VARCHAR(255),
    stato ENUM('nel_carrello', 'acquistato') DEFAULT 'nel_carrello',
    qr_code VARCHAR(191),
    CONSTRAINT fk_biglietto_evento FOREIGN KEY (id_evento) REFERENCES Evento(id_evento),
    CONSTRAINT fk_biglietto_posto FOREIGN KEY (id_posto) REFERENCES Posto(id_posto),
    CONSTRAINT fk_biglietto_settore FOREIGN KEY (id_settore) REFERENCES Settore(id_settore),
    CONSTRAINT fk_biglietto_cliente FOREIGN KEY (email_cliente) REFERENCES Utente(email)
) ENGINE=InnoDB;
