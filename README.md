# cxf-bean

Simple example code that leverages Apache CXF together with Apache Johnzon to automatically marshal and unmarshal an arbitrary Java Bean to and from JSON, using a plain Tomcat servlet container.

- Apache CXF is a JAX-RS provider (aka JSR-339) and has support for JAX-WS and other things.
- Apache Johnzon is a JSON Processing provider (aka JSR-353).

There are many other implementations of these Java standards, but the point of combining these two is that this is what Apache TomEE provides out of the box. So any code that uses this combo will automatically have compatibility between TomEE and plain Tomcat. The packaging and configuration of CXF and Johnzon will be slightly different of course, but the business code and functionality will be the same. Other servlet containers and Java EE containers should work too, but some might need their own configuration tweaks, especially if they don't have CXF and Johnzon bundled.

# How to compile

Just do `mvn clean package`, and then copy the file `target/cxf-bean.war` to your Tomcat webapps directory.

# How to run

To demonstrate marshalling of an instance of the `Customer.java` bean:

```bash
curl -v http://{HOSTNAME}:8080/cxf-bean/api/v1.0/customer
```

To demonstrate unmarshalling of the same bean:

```bash
curl -v -H Content-type:application/json http://{HOSTNAME}:8080/cxf-bean/api/v1.0/customer -d '{"name":"Foo"}'
```

Replace `{HOSTNAME}` with `localhost` or wherever you are serving Tomcat from.

# TomEE

To run the same code in TomEE, you just need to change three things:

- Replace all dependencies in `pom.xml` with `javax/javaee-api`.
- Remove the servlet configuration from `web.xml`. You can even delete it if your webapp doesn't need it.
- Remove the `getClasses()` method from `Service.java`. Instead add the following annotation:
```java
@Stateless
@ApplicationPath("/api")
public class Service extends Application {
    ...
}
```

The WAR file will now only be a couple of kilobytes since all dependencies are provided by the container.
