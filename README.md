# Mancala (Kalah) 

## Descripción  
Este es un juego de Mancala basado en la variante Kalah.  
El objetivo del juego es capturar más semillas que el oponente siguiendo las reglas tradicionales de Kalah.

## Objetivo del Juego  
- Cada jugador debe recolectar más semillas que su oponente antes de que el tablero se vacíe.  
- El juego termina cuando un jugador no puede hacer más movimientos.  

## Cómo Jugar  
1. El tablero tiene 6 hoyos por jugador y un almacén en cada extremo.  
2. En cada turno, un jugador elige un hoyo de su lado y distribuye las semillas en sentido antihorario.  
3. Si la última semilla cae en su almacén, obtiene un turno extra.  
4. Si cae en un hoyo vacío de su lado, captura las semillas del hoyo opuesto.  
5. El juego termina cuando un jugador no puede mover, y el otro se lleva las semillas restantes.  
**⚠ Nota:** Para ver mása fondo las reglas del juego ver el archivo Reglas de juego en el direcorio Docs.

## Controles en Consola  
- La consola mostrará el estado del tablero después de cada turno.
- Después de mostrar el tablero se pide al jugador que seleccione un hoyo para hacer su movimiento.  

## Fin del Juego  
- El jugador con más semillas en su almacén gana la partida.  

## Instalación y Ejecución
- Para instalar el juego, descarga el `.zip` o clona el repositorio.
- Cuando ya tengas el respositorio localmente ejecuta los siguientes comandos.
```sh
javac src/*.java -d out
java -cp out Mancala
