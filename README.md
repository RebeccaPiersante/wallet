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

## FUNZIONALITÀ PRINCIPALI
- Gestione CRUD (Create, Read, Update, Delete) delle spese.
- Ricerca spese filtrata per data e categoria.
- **Calcolo dei totali:** Somma delle spese per giorno o per intervallo di date, con possibilità di filtrare per categoria.

## DATABASE 
Il progetto utilizza un database PostgreSQL con una singola tabella:

```sql
CREATE TABLE expense (
    id_expense   SERIAL,
    description  TEXT NOT NULL,
    date_expense DATE NOT NULL,
    amount       NUMERIC(10, 2) NOT NULL,
    categories   VARCHAR(30) DEFAULT 'OTHER',

    CONSTRAINT pk_expense PRIMARY KEY(id_expense)
);
```

## STATO DEL PROGETTO

In sviluppo

Attualmente:

- Setup progetto
- Configurazione database
- Implementazione del Repository con query personalizzate
- Implementazione del Service

*Progetto sviluppato a scopo didattico.*
