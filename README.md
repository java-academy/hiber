# Existence of hibernate collections

1. Prepare H2 connection (configure Connector).
2. Go to CollectionsTest class:
* Fill the tests methods in CollectionsTest class to prove that a set of authors in the Book is a java.util.HashSet
   and after persistence is an org.hibernate.collection.internal.PersistentSet (use Author and Book classes).

## Documentation

Checkout documentation:

* [docs.jboss](https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/collections.html)