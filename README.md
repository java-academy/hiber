### Info
Relation database __does not__ support inheritance known in java world.
Therefore  **J**ava **P**ersistence **A**PI defines three core strategies 
helping convert class hierarchy into entities:
- Single Table - creates one table for each class hierarchy.
- Joined Table - each class in the hierarchy is mapped to its table.
- Table Per Class - table is defined for each concrete class in the inheritance hierarchy 
to store all the attributes of that class and all of its superclasses.

#### Examples
Let's assume we have hierarchy as shown on the diagram below:

![alt text](PNGs/ExampleOfHierarchy.png)

then the presentations of the strategies in database gonna look like that:

single table strategy in database looks:

![alt text](PNGs/SingleTableExample.png)

joined table strategy:

![alt text](PNGs/JoinedTableDiagram.png)

table per class:

![alt text](PNGs/TablePerClass-Diagram.png)



_You should read:_ 
- [wikibooks](https://en.wikibooks.org/wiki/Java_Persistence/Inheritance)
- [devglan](https://www.devglan.com/hibernate/hibernate-inheritance-example)
- [baeldung](https://www.baeldung.com/hibernate-inheritance)

----
### TASK

So now you know (more or less) how inheritance strategies are converted into database.
Right below you have another simple class diagram. Your task is to implement all of the classes 
(create them in ``model`` package) and put it into database using each of the strategy.

![alt text](PNGs/ClassDiagram.png)


Check how each particular strategy is presented in database.

Have fun.

_PS: you can use my wrapper in App menu to save entities into database. Remember to set proper driver configs
and add class marked as @entity in ``SessionConnector`` class._
