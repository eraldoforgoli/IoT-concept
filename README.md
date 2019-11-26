# IoT Proof of concept.

IoT proof of concept, using Spring Boot, MongoDB and Stomp.
Upon a gadget creation, the system publishes the topic

## Application tree

````
── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── IoT
    │   │           ├── IoTApplication.java
    │   │           ├── config
    │   │           │   ├── AppConfig.java
    │   │           │   └── WebSocketConfig.java
    │   │           ├── controller
    │   │           │   └── GadgetController.java
    │   │           ├── model
    │   │           │   ├── Gadget.java
    │   │           │   ├── GadgetType.java
    │   │           │   ├── Message.java
    │   │           │   ├── Room.java
    │   │           │   └── RoomType.java
    │   │           └── repository
    │   │               ├── Config.java
    │   │               ├── GadgetDAO.java
    │   │               ├── IConfig.java
    │   │               └── IGadgetDAO.java
    │   └── resources
    │       └── application.properties
    └── test
        └── java
            └── com
                └── IoT
                    └── ApplicationTest.java
````