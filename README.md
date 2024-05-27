[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/bFlAvWr6)

DB Setup
--------

* Run `docker-compose up -d` to set up the database
* Use `mysql -h 127.0.0.1 -P 3306 -u application_user --password=sadf123 boutique_hotel < dbinit.sql` to install the DB schema
* Use `mysql -h 127.0.0.1 -P 3306 -u application_user --password=sadf123 boutique_hotel < dbpopulate.sql` to populate the created schema
* Use `mysql -h 127.0.0.1 -P 3306 -u application_user --password=sadf123 boutique_hotel` to just log in
