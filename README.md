# Implementación de la Base de Datos en la clase PanelJuego

En la clase PanelJuego, se encuentra la implementación de la funcionalidad de la base de datos para guardar la puntuación del jugador al finalizar el juego. A continuación, se detalla cómo se realiza esta implementación.

## Método guardarPuntuacionEnBaseDeDatos(String nombreJugador, int puntuacion, String nombreJuego)

Este método se encarga de guardar la puntuación del jugador en la base de datos del juego. Utiliza una conexión JDBC para establecer la conexión con la base de datos y ejecuta una consulta preparada para insertar los datos del jugador en la tabla de puntuaciones.


# Parámetros

nombreJugador: Cadena que representa el nombre del jugador.
puntuacion: Entero que indica la puntuación obtenida por el jugador.
nombreJuego: Cadena que indica el nombre del juego.
