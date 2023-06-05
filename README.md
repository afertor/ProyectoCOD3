# ProyectoCOD3
En esta rama esta el programa inicial y a base de pull request e issues iremos implementando las nuevas funciones


## Diagrama de flujo 

```mermaid
classDiagram
    class Casilla {
        -abierta: boolean
        -mina: boolean
        -valor: int
        -marcada: boolean
        -imagenBandera: ImageIcon
        -imagenMina: ImageIcon
        -tablero: Tablero
        +Casilla(Tablero)
        +abrir()
        +marcar()
        +isAbierta(): boolean
        +isMina(): boolean
        +setMina(boolean)
        +getValor(): int
        +setValor(int)
        +isMarcada(): boolean
        +setMarcada(boolean)
    }
    
    class Interfaz {
        -tablero: Tablero
        -tiempoLabel: JLabel
        -cronometro: Timer
        +Interfaz(Tablero)
        +mostrarResultado(boolean)
    }
    
    class Tablero {
        -casillas: Casilla[][]
        -filas: int
        -columnas: int
        -minas: int
        -interfaz: Interfaz
        -tiempo: int
        +Tablero(int, int, int)
        +colocarMinas()
        +calcularValores()
        +estadoJuego(): boolean
        +mostrarMensajeDerrota()
        +todasLasCasillasAbiertas()
        +mostrarMensajeVictoria()
        +algunaMinaExplotada(): boolean
        +actualizarTiempo()
        +guardarPuntuacion(String)
        +setInterfaz(Interfaz)
        +getTiempo(): int
    }
    
    class ClasificacionException {
        +ClasificacionException(String)
    }
    
    class MenuPrincipal {
        -frame: JFrame
        -panel: JPanel
        -buscaminasButton: JButton
        -snakeButton: JButton
        -clasificacionButton: JButton
        +MenuPrincipal()
        +show()
        +showClasificacion(String)
        +mostrarClasificacion(String): void
        +obtenerClasificacion(String): String
    }
    
    class Juego {
        -obj: PanelJuego
        +Juego()
    }
    
    class PanelJuego {
        -SCREEN_WIDTH: int
        -SCREEN_HEIGHT: int
        -UNIT_SIZE: int
        -GAME_UNITS: int
        -DELAY: int
        -x: int[]
        -y: int[]
        -bodyParts: int
        -manzanasComidas: int
        -manzanasX: int
        -manzanasY: int
        -direction: char
        -running: boolean
        -timer: Timer
        -random: Random
        +PanelJuego()
        +inicioJuego()
        +paintComponent(Graphics)
        +Dibujo(Graphics)
        +ManzanaN()
        +movimientos()
        +checkManzanas()
        +checkChoques()
        +finJuego(Graphics)
        +actionPerformed(ActionEvent)
        +MyKeyAdapter
        +guardarPuntuacionEnBaseDeDatos(String, int, String)
    }
    
    class Connection {
        ...
    }
    
    class PreparedStatement {
        ...
    }
    
    class ResultSet {
        ...
    }
    
    class DriverManager {
        ...
    }
    
    Casilla "1" -- "1" Tablero : contienen
    Interfaz "1" -- "1" Tablero : contiene
    Tablero "1" -- "1" Interfaz : asociación
    Tablero "1" -- "1..n" Casilla : contiene
    MenuPrincipal "1" -- "1" Juego : asociación
    Juego "1" -- "1" PanelJuego : contiene
    PanelJuego "1" -- "1" Timer : asociación
    PanelJuego "1" -- "1" Random : asociación
    PanelJuego "1..n" -- "1..n" Graphics : asociación
    ClasificacionException "1" -- "1" MenuPrincipal : asociación
    MenuPrincipal "1" -- "1" JFrame : contiene
    MenuPrincipal "1" -- "1" JPanel : contiene
    MenuPrincipal "1" -- "1" JButton : contiene
    JFrame "1" -- "1" JPanel : contiene
    JFrame "1" -- "1" JLabel : contiene
    JPanel "1" -- "1" JButton : contiene
    JButton "1" -- "1" ActionListener : contiene
    JPanel "1" -- "1" JLabel : contiene
    JPanel "1" -- "1" KeyListener : contiene
    Timer "1" -- "1" ActionListener : contiene
    Connection "1" -- "1" DriverManager : asociación
    PreparedStatement "1" -- "1" Connection : asociación
    ResultSet "1" -- "1" PreparedStatement : asociación
    DriverManager "1" -- "1" SQLException : contiene
  ```
  
  
  ## Diagrama de secuencia

```mermaid

sequenceDiagram
    participant BuscaminasGame
    participant Interfaz
    participant Tablero
    participant Casilla

    BuscaminasGame->>+Interfaz: new Interfaz(tablero)
    activate Interfaz
    Interfaz->>+Tablero: new Tablero(8, 8, 10)
    activate Tablero
    Tablero-->>-Interfaz: tablero creado
    deactivate Tablero
    Interfaz->>+JFrame: setVisible(true)
    activate JFrame
    JFrame-->>-Interfaz: ventana visible
    deactivate JFrame
    Interfaz-->>-BuscaminasGame: Interfaz creada
    deactivate Interfaz
```




















