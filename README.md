# Logging SQL

## Basic Logging
Logging sql queries send by Hibernate is important on development stage. It helps to see what exactly happens in the background.
Statistics are additional feature, which shows how many queries was invoked and time of their completion.

First way to add basic sql log is to set property SHOW_SQL on true in configuration. We can also use FORMAT_SQL to divide query
on parts. Documentation provides list of properties to use.

Documentation:
* [hibernate configuration logging docs](http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#configurations-logging)
* [hibernate best practices](http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#best-practices-logging)

## Log4j
Having framework like log4j is much better practice. To configure options new version log4j 2 needs file "log4j2.xml" in resource.
Two parts are needed - appenders and loggers. First tells us about place where our logs will be shown or saved and in what form.
Second defines what we want to log.

`<Logger name=" " level=" " additivity=" ">
    <AppenderRef ref=" " />
 </Logger>`

## Log parameters
Basic logging show us queries but without parameters passed to it. It's because the binded parameters are logged to the 
org.hibernate.type.descriptor.sql category with log level TRACE.

## Statistics
Last thing is statistics. In configuration GENERATE_STATISTICS property must be set to true.

Documentation:
* [hibernate documentation](http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#statistics)

Both of types can be configured in .xml file or programmatically directly at class.

#
Further instructions are available in --> App class.