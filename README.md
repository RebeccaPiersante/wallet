# WALLET 

REST API per la gestione delle spese personali.

Questo progetto è un backend sviluppato in Java con Spring Boot che consente di tracciare, salvare e filtrare le proprie spese.

## TECNOLOGIE USATE 
- Java
- Spring Boot
- Spring Web (MVC)
- Spring Data JPA
- PostgreSQL
- Validation
- DevTools

## DATABASE 
Il progetto utilizza un database PostgreSQL con una singola tabella:

CREATE TABLE expense (

	id_expense   SERIAL,
	description  TEXT NOT NULL,
	date_expense DATE NOT NULL,
	amount		 NUMERIC(10, 2),
	categories 	 VARCHAR(30) DEFAULT 'OTHER',

	CONSTRAINT pk_expense PRIMARY KEY(id_expense)
);

## STATO DEL PROGETTO

In sviluppo
Attualmente:

- Setup progetto
- Configurazione database

*Progetto sviluppato a scopo didattico.*
