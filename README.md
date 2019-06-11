
#### @Version and Optimistic Locking

Optimistic locking is a mechanism that prevents an application from being affected by the "lost update"
 phenomenon in a concurrent environment while allowing some high degree of concurrency at the same time. 
 This is achieved without actually resorting to any locks: Optimistic locking relies on checks that are made 
 against the existing data on the data store by transactions during update time.

   The main concept is to check if another existing transaction has made any concurrent changes against 
the same data that a given transaction may be trying to change at a given time. 
If that concurrent changes happen to exist, the current transaction aborts because there is the possibility of the updates made
 by the other transaction being lost (or not taken into account).
 
 To add Version,  just mark the version property’s getter or field in the class with the @Version annotation.

` 
 @Version
 public long getVersion() {
 return version;
 }`
 
 `@Version public long version;`
 
 The version property on the class can be numeric (short, int, or long) or timestamp or calendar. 
 
 Go to App class, read instruction and start task.