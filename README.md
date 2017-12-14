# cxf-bean

Simple example code that leverages Apache CXF together with Apache Johnzon to automatically marshal and unmarshal an arbitrary Java Bean to and from JSON, using a plain Tomcat servlet container.

- Apache CXF is a JAX-RS provider (aka JSR-339) and has support for JAX-WS and other things.
- Apache Johnzon is a JSON Processing provider (aka JSR-353).

There are many other implementations of these Java standards, but the point of combining these two is that this is what Apache TomEE provides out of the box. So any webapp that uses this combo will automatically have compatibility with TomEE and plain Tomcat. Other servlet containers and Java EE containers should work too, but they will probably need some configuration tweaks.

# How to compile

Just do `mvn clean package`, and then copy the file `target/cxf-bean.war` to your Tomcat webapps directory.

# How to run

To demonstrate marshalling of an instance of the `Customer.java` class:

```bash
curl -v http://{HOSTNAME}:8080/cxf-bean/api/v1.0/customer
```

To demonstrate unmarshalling of the same class:

```bash
curl -v -H Content-type:application/json http://{HOSTNAME}:8080/cxf-bean/api/v1.0/customer -d '{"name":"Foo"}'
```

Replace `{HOSTNAME}` with `localhost` or wherever you are serving Tomcat from.

