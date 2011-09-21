This portlet is meant to demonstrate a very basic database
query and then display that information using a JSP file. 

It also introduces the MVC pattern for developing applications
and using database connection pooling. 

To make the portlet work correctly with minimal modifications
you would need a database with matching schema and data that 
this portlet expects to exist. Then you would need to modify
the connection-pool.properties file appropriately for your
database connection requirements.

Otherwise, you may use this as a starting point. Create new
packages and Java classes to match your particular data needs.
Just be sure to update the log4j.properties file to match the 
new packages + class names and still update the connection-pool.properties
file appropriately.

Hope you find this useful.
