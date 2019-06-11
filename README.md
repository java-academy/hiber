#Xml configuration

It is possible to configure Hibernate not only by annotations.
Now it is more often used method, but sometimes it's better to have configuration in external file than in code.

Steps:
1. Create method in class Connector to create Session object, by using Configuration class and configure() method
 -> default method looks for file 'hibernate.cfg.xml' in resources directory.
 2. You must create file with configuration: hibernate.cfg.xml
 3. In file set basic configuration properties:
     * driver
     * url
     * username
     * password
     * dialect
     * cache
     * hbm2ddl
     * mapping to tables (in 4.)
 4. Next file will contains structure of database. Name it as you want (but with extension .hbm.xml).
 5. Put in this file entity structure.