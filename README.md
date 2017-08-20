# jersey-rest-authentication-filters
A simple Jersey REST Service using Basic Auth Authentication

Open Postman and click on Authorization

select Basic Auth, and enter user and password in the username and password fields and click on update request
Now the Authorization header has been set for your request. This will be used by the server to authenticate the incoming request.

Use the Url - http://localhost:8080/jersey-rest-authentication-filters/webapi/simple/login

Login also uses the ContainerRequestFilter to filter the incoming request before accessing the actual service

1.download the zip file

2.unzip and import it as existing maven project

3.right click the project and select run of server

4.select tomcat
