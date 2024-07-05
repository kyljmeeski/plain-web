[![Java](https://img.shields.io/badge/Java-8%2B-orange)](https://www.oracle.com/java/)
![Lines of Code](https://img.shields.io/badge/lines_of_code-1361-green)
![License](https://img.shields.io/badge/license-MIT-blue)

**Plain Web** is a simple and lightweight web framework.

How to use:
```xml
<dependency>
    <groupId>io.github.kyljmeeski</groupId>
    <artifactId>plain-web</artifactId>
    <version>0.0.1</version>
</dependency>
```

Server start at port 8080 by default:
```java
WebApp app = new PlainWebApp();
app.start();
```

## Lambda-Expression as a Route:
Before starting it, you have to define routes first:
```java
WebApp app = new PlainWebApp();
app.on(HttpMethod.GET, "/", request -> new TextResponse(HttpStatus.OK, "home"));
app.start();
```

## Separate Class for Route
... or you can create a route in separate class (file):
```java
public class HelloRoute implements Route {
    @Override
    public Response handle(Request request) {
        String name = request.params().get("name").orElse("buddy");
        return new TextResponse(HttpStatus.OK, "Hello " + name);
    }
}
```

Then you can add this route:
```java
app.on(HttpMethod.GET, "/hello", new HelloRoute());
```

## Request Params
```java
String name = request.params().get("name").orElse("buddy");
```

## Request Headers
```java
String header = request.headers().get("User-Agent").orElse("");
```

## Request Text Body
```java
Body body = request.body();
if (body.type().equals("text/plain")) {
    System.out.println(new String(body.content()))
}
```

## Request JSON Body
Assume you have a class:
```java
class Player {
    String name;
    int age;
    
    // constructor and methods
}
```
```java
Body body = request.body();
if (body.type().equals("application/json")) {
    Player player = new BodyWrapper(body).content(Player.class);
}
```

## Text Response
```java
Response response = new TextResponse(HttpStatus.OK, "hello");
```

## JSON Response
```java
Response response = new JsonResponse<>(HttpStatus.OK, new Player("messi", 36));
```

## Add Header to Response
```java
Response response = new JsonResponse<>(HttpStatus.OK, new Player("messi", 36))
        .with("Connection", "close");
```