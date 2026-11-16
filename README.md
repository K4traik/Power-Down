# ⚡ Power Down

Power Down es un videojuego acerca de "apagar" todos los electrodomésticos que han perdido el control. Es desarrollado por Eric Quintana (K4traik) y Adriano Benito.

## 🏷️ Versión

Prototipo final. 46 commits.

## 📥 Instrucciones de instalación

1. Descargar e instalar Eclipse.
2. Descargar e instalar MySQL y MySQLWorkbench.
3. Crear una conexión con host "localhost", usuario "root" y contraseña "root" en el puerto "3306".
4. Importar la base de datos a la conexión usando el archivo "Power_Down.sql" del repositorio.
5. Mantener la conexión de MySQL abierta mientras se ejecuta el juego (últimos 3 pasos).
6. Abrir el proyecto del repositorio en el IDE. Si no lo reconoce intenten File -> Import -> Maven -> Existing Maven Projects -> pom.xml.
7. Buscar y entrar a la clase "Launcher" en el paquete "gui".
8. Presionar el botón "Run" con el símbolo de reproducir.
9. Disfrutar.


## 🎮 Controles

* **`W`**: Moverse una casilla arriba.

* **`S`**: Moverse una casilla abajo.

* **`D`**: Moverse una casilla a la derecha.

* **`A`**: Moverse una casilla a la izquierda.

* Usa el ratón para tocar los botones en las otras interfaces.

## 🕶️ Personaje principal

Es el personaje que parece tener pelo color verde y lleva gafas de sol. Que tengas solo una vida es intencional. Puede "apagar" los dispositivos pisando los cables que los conectan.

## 🤖 Enemigos

* **🌀 Ventilador:** Te empujará hasta la pared hacia donde esté mirando. Su alcance es todas las casillas que tenga enfrente.

* **🔥 Horno:** Prenderá fuego las tres casillas que tiene delante todos los turnos.

* **❄️ Heladera:** Congelará las tres casillas que tiene enfrente, si el jugador es alcanzado entonces no podrá moverse en el siguiente turno.

* **🍞 Tostadora:** Lanzará una tostada en línea recta en el turno siguiente al detectar al jugador. Su alcance es todas las casillas que tenga enfrente.

* **💻 Laptop:** Se moverá erráticamente cada 3 turnos, si el jugador está en su alcance lo atacará.

* **🧹 Aspiradora:** Aspirará al personaje hacia ella pero no hace daño. Su alcance es todas las casillas que tenga enfrente.

## 🛠️ Créditos

* Usamos a Gemini (Google AI) para preguntas sobre la librería y en casos específicos para generar trozos de código que sirvan como ejemplo de cómo implementar las funciones.

* El código fue escrito usando Eclipse.

* Los sprites fueron hechos en LibreSprite.

## 💬 Prompts

| Prompt | Motivo | 
| ----- | ----- | 
| ¿Cómo puedo crear un proyecto con JavaFX en Eclipse con Maven? Ya tengo toda una jerarquía de clases para la lógica pero quiero manejar lo visual, decime los pasos para hacer por ejemplo un menú. | Este prompt lo hice por dos cosas. Primero, no sabía cómo aclarar las dependencias en el pom.xml. Segundo, no sabía bien cómo poner en práctica lo que había investigado sobre Scene Builder así que Gemini creó básicamente un menú muy básico muy similar al menú principal del juego. | 
| ¿Cómo puedo "dibujar" una animación de un sprite con varias Image? Dame el método más simple. | Esto lo pregunté para animar las explosiones, el tema es que luego me di cuenta de que sería más complejo. | 
| ¿Qué podría poner en drawExplosions() teniendo en cuenta que LevelManager tiene un ArrayList<Position> para saber dónde renderizar? El tema es que no sé cómo hacer que ocurra la explosión 1 sola vez y con un tiempo perfecto. | Este prompt fue el segundo para ver lo de las explosiones. | 