# Install and start database servers

You should install 3 different databases:

* MySQL
* PostgreSQL
* H2 (open in server mode)

1. Download database server.
2. Install.
3. Configure username and password for your user.
4. Create database and name it: DB
5. Add dependencies in pom.xml 
6. Change in Connector classes {database}, {password}, {username}
7. Run main method and check if Author, Book, Bookstore, BookstoreBook tables are created in each DB

## Documentation

Checkout documentation:

* [MySQL](https://dev.mysql.com/doc/refman/8.0/en/binary-installation.html)
* [PostgreSQL](https://www.postgresql.org/docs/11/index.html)
* [H2](https://www.h2database.com/html/installation.html)

## Tips

If you install db for first time (or forget how to do it):

* [MySQL](https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-18-04)
* [PostgreSQL](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-postgresql-on-ubuntu-18-04)
* [H2](https://www.h2database.com/html/installation.html)
