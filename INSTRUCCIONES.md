# Para revisar

1. La base de datos debe estar corriendo

    ```
    cd rolobykes
    docker compose up -d
    ```

2. Java debe estar en versión 17

    ```
    sdk default java 17.0.8.fx-zulu
    ```

3. Para ejecutar las pruebas en el IDE
    - usar el plugin de "Java Server Language" en version 1.21.0


# Sobre el @Transactional

```
// leer un usuario de la base de datos
// carga las colecciones que son EAGER
// pero no carga (de una vez) las colecciones LAZY
Usuario u = usuarios.findById("jaime");

// ver las bicicletas 
List<> bicicletas = u.getBicicletas();

// si esta colección es LAZY
// Spring debe ir a la base de datos y traer las bicicletas
// se necesita una sesión de base de datos

// en este caso, el método que ejecuta este código
// código que "va a ir" hasta la base de datos 
// debería estar anotado con @Transactional
```