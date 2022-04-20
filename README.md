### Description
This application shows the basic functionalities for managing a database using swagger.

### Prepare environment
The application was coded in IntelliJ IDEA so it would be great to use that environment to run this project.<br>
To run this app you need XAMPP(or any other program that allows to manage local web server) and download database file "company2" from this repo.<br>
After that, place the database file in the right folder in xampp catalog (xampp->mysql->data).

### Change database source in app
Open "application.properties" (src->main->java->templates) and optionally change the line below for your current location of the downloaded database.
```ruby
spring.datasource.url=jdbc:mysql://127.0.0.1/company2?useUnicode=true&characterEncoding=utf-8
```

### Running app
Now you can run this project. After that open your browser and type "http://localhost:8080/swagger-ui.html".<br>
