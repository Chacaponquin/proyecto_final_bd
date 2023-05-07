<p align="center"><img align="center" src="https://res.cloudinary.com/chaca-sa/image/upload/v1679027493/328169508_122397193933692_2960493904923070018_n_vxtlez.jpg" style="width: 300px"/></p>

# 👧 Proyecto Analla

> ### 😹 Chistecillo
> Qué es la piedad? Tener 3,1416 año

## 😀 Objetivo principal
Este trabajo tiene como único objetivo el **5** del compañero José para que termine con 5 la asignatura y le pueda hacer el siguiente baile a Baster.

<p align="center"><img align="center" src="https://res.cloudinary.com/chaca-sa/image/upload/v1682915008/95bc112f-b9d9-44f9-9a29-b8157a92506f_jmkats.webp" style="width: 300px"/></p>

> ### 😹 Chistecillo
> Cuál es el Pokemon más tonto? Pikachu porque Pika Pika y no se rasca

## 📜 Requisitos del código
Aquí están todos los requisitos que los queridos profesores quien ver implementados
- Los nombres de las entidades, atributos, métodos, interfaces, etc. deben ser descriptivos y en inglés.
- El diseño de la interfaz debe ser sencillo, consistente y atractivo para el usuario.
- El usuario debe manipular directamente los componentes teniendo el control de la aplicación.
- Las acciones del usuario deben ser reversibles.
- Debe existir una correcta manipulación de los errores.
- La entrada a la aplicación debe ser a través de una interfaz gráfica de autenticación **(por definir)**.
- Hacer uso de los comentarios en la codificación. Al menos las funcionalidades deben tener comentarios en su encabezado.
- Se debe garantizar la gestión (creación, lectura, eliminación y modificación) de todas las entidades del problema.
- Los reportes deben ser parametrizables.

> ### 😹 Chistecillo
> Has entrado alguna vez en un laberinto? Pues no sabes lo que te pierdes


## 🕐 Antes de empezar
Debido a que cada uno tiene una configuración distinta de la base de datos en su máquina y estamos usando NetBeans (que ya lo odio y eso que sólo he movido dos carpetas). Hay que crear variables de entorno para cada uno de nosotros.

### ¿Para qué son?
Son básicamente variables que se declaran desde un IDE o un archivo de configuración que vayan a ser usadas en la aplicación. Pero estas a diferencia de cualquier otro tipo de variable no son las mismas en todas las computadoras.

### ¿Cómo se declaran en NetBeans? (que lo odio)
Se debe dar click derecho en el proyecto e ir a `Properties -> Run`, crear una nueva configuración para que siempre que se de play se inicie el programa se arranque la clase Main, con las siguientes variables de entorno:
- `DATABASE_NAME`
- `DATABASE_PASSWORD`
- `DATABASE_USERNAME`
- `DATABASE_PORT`

> ### ⚠️ Aclaración
> Al definirlas todas deben tener la `D` delante. No tengo idea por qué

Debe quedar algo así
<img src="https://res.cloudinary.com/chaca-sa/image/upload/v1683324255/Screenshot_94_ffmhib.png"/>

Esto permite que se pueda acceder a ellas de la forma:
```java
System.getProperty('DATABASE_NAME');
System.getProperty('DATABASE_USERNAME');
System.getProperty('DATABASE_PASSWORD');
System.getProperty('DATABASE_PORT');
```

> ### ⚠️ Aclaración
> Añadir la librería de postgres que se encuentra dentro de la carpeta `lib`. Investigar como hacerlo en NetBeans (que lo odio) que es de forma diferente a Eclipse (que lo odio también) aunque es muy parecida.

## 📚 Estructura 

```bash
  |--- src
    |--- dto
    |--- exceptions
    |--- services
    |--- utils
    |--- visual
```

> ### ⚠️ Aclaración sobre la estructura
> Menos la carpeta `utils` y `services` todas estan separadas por módulos, o sea cada una representa una entidad del proyecto y en ella van a estar las clases correspondinetes a las funcionalidades de la carpeta en la que se encuentren

### `services`
Basicamente son las funciones que concentrarán toda la lógica de cada entidad `crear`, `eliminar`, `modificar`, `leer`, etc. **Utilizando los DTO como argumentos para los que sean necesarios**. Un ejemplo de implementación sería:
```java
// UserServices.java

public class UserServices{
    public void createUser(CreateUserDTO createUserDTO){
        // logica de crear usuario
    }

    public void deleteUser(DeleteUserDTO deleteUserDTO){
        // logica para eliminar un usuario
    }

    public void updateUser(UpdateUserDTO updateUserDTO){
        // logica para actualizar un usuario
    }

    public List<ReadUserDTO> getAllUser(){
        // logica para leer los usuario de la base de datos
    }
}
```

> ### ⚠️ Aclaraciones sobre `services`
> - Todos los nombres de los archivos deber terminar en **Services**
> - Todos los servicios deben ser importados desde una clase ya escrita que se llama `ServicesLocator` **(porque les salió del tubo a los profesores)**
>   ```java
>   import src.cu.edu.cujae.structbd.services.ServicesLocator
>   
>   ServicesSelector.UserServices.readUsers()
>   ```

### `dto`
En este proyecto nos piden que utilicemos el patrón DTO (Data Transfer Object) que aunque suene a un patrón utilizado en facebook es bastante easy. En esta carpeta irán en cada módulo o carpeta las clases que tendrán los parámetros necesarios para realizar cierta operación

#### Ejemplo
Antes implementabamos de forma errónea las funciones de la lógica de esta forma
```java
public void createUser(String username, int age){
    // logica para crear el usuario
}
```

🎵 **Insertar música de comercial** 🎵 Pero ahora con el grande y único patrón DTO podrás tener más orden a la hora de declarar tus funciones de mierda, como por ejemplo lo que viste anteriormente lo podrás hacer de esta forma:
```java
// CreateUserDTO.java
public class CreateUserDTO{
    private String username;
    private int age;
}

// UserServices.java
public class UserServices{
    public void createUser(CreateUserDTO createUserDTO){
        // logica
    }
}
```

> ### ⚠️ Aclaraciones sobre `dto`
> - Todos los nombres de archivos deben terminar en `DTO`

### `exceptions`
Aquí estarán todas las excepciones pertenecientes a cada módulo. **Preferiblemente dedicadas a validaciones de formularios o de parámetros**

> ### ⚠️ Aclaraciones sobre `exceptions`
> - Todos los nombres de archivos deben terminar en `Exception`
> - **LAS EXCEPCIONES EN CUANTO A VALIDACIONES DEBEN ESTAR EN LA LÓGICA NO SE DEBE ESPERAR A QUE LA BASE DE DATOS DISPARE UN ERROR DEBIDO A QUE ESTE SE HACE MUY DIF�?CIL DE IDENTIFICAR**. Ejemplos: nombres vacios, edades menores que 0, etc.

### `utils`
Hasta este momento el compañero Héctor no tiene mucha idea de que va aquí. Lo más probable es que sean clases dedicadas a la conexión con las bases de datos, modificación de textos, etc.

### `visual`
Contiene las ventanas de la UI

> ### ⚠️ Aclaraciones sobre `visual`
> - Todos los nombres de archivos deben terminar en `UI`
> - **NO DEBE HABER LÓGICA EN LOS ARCHIVOS UI, SÓLO LLAMADAS A SERVICIOS**

> ### 😹 Chistecillo
> Cómo convertir un burro en una burra? Guardarlo en el garaje, hasta que se aburra

## 💻 Tareas 
Como somos un equipo sexy y democrático vamos a repartir de forma justa los módulos asi cada uno se puede encargar de cada entidad sin necesidad de estar tocando código de otro. Como hay 11 entidades y yo soy el único negro del equipo voy a coger 3 pero cogere el `Team` que considero que es el más difícil.
Cada uno va a tener que implementar de cada entidad que le toque:
- dto
- services
- visual
- exceptions

> ### ⚠️ **LEAN LOS [REQUISITOS](#-requisitos-del-código) COÑO**

### 🧑‍⚕️ Tareas de José 
- ⭕ Phase
- ⭕ Coach
- ⭕ Player
- ⭕ Province

### 🐈 Tareas de Amaya 
- ⭕ Game
- ⭕ Position
- ⭕ Team_member
- ⭕ Pitcher

### 🐵 Tareas de Héctor
- ⭕ Team
- ⭕ Batter
- ⭕ Stadium

> ### 😹 Chistecillo
> Will Smith antes era Was Smith ?