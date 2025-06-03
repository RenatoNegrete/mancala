# Reglas de Kalah

## 1. Preparación
- El tablero consta de dos filas (una por jugador), cada fila tiene seis hoyos y a la derecha de cada fila se encuentra un almacén.
- Cada hoyo comienza con un número fijo de semillas, este puede ser 4, 5 o 6.

---

## 2. Turno
- En su turno, el jugador escoge uno de sus hoyos, recoge las semillas de ese hoyo y comienza a sembrarlas una por una en sentido antihorario.
- Se coloca una semilla en cada hoyo, incluyendo el almacén del jugador, pero no en el almacén del rival.

**Ejemplo:**  
Turno Jugador 1: escoge **E**

```text
             a       b       c       d       e       f
  |-------------------------------------------------------------|      
  |      |       |       |   2   |       |   1   |       |      |
  |      |-------|-------|-------|-------|-------|-------|      |
  |      |   4   |   3   |   2   |       |   5   |       |      |
  |-------------------------------------------------------------|
             A       B       C       D       E       F
```

Después de movimiento (Turno Jugador 2):

```text
             a       b       c       d       e       f
  |-------------------------------------------------------------|      
  |      |       |       |   2   |   1   |   2   |   1   |      |
  |      |-------|-------|-------|-------|-------|-------|  1   |
  |      |   4   |   3   |   2   |       |       |   1   |      |
  |-------------------------------------------------------------|
             A       B       C       D       E       F
```

**Comentario:** El Jugador 1 mueve las semillas del hoyo E, va colocando una semilla en cada hoyo en sentido antihorario hasta quedarse sin semillas. En el ejemplo, las semillas pasan por el almacén, por lo que se coloca una en él y luego continúa sembrando en los hoyos del rival.

---

- Si la última semilla cae en el almacén del jugador, este obtiene otro turno.

**Ejemplo:**  
Turno Jugador 1: escoge **E**

```text
             a       b       c       d       e       f
  |-------------------------------------------------------------|      
  |      |       |       |   2   |       |   1   |       |      |
  |      |-------|-------|-------|-------|-------|-------|      |
  |      |   4   |   3   |   2   |       |   2   |       |      |
  |-------------------------------------------------------------|
             A       B       C       D       E       F
```

Después del movimiento (Turno Jugador 1 de nuevo):

```text
             a       b       c       d       e       f
  |-------------------------------------------------------------|      
  |      |       |       |   2   |       |   1   |       |      |
  |      |-------|-------|-------|-------|-------|-------|  1   |
  |      |   4   |   3   |   2   |       |       |   1   |      |
  |-------------------------------------------------------------|
             A       B       C       D       E       F
```

**Comentario:** El Jugador 1 escoge el hoyo E, que tiene dos semillas. La última cae en su almacén, por lo que obtiene un turno adicional.

---

## 3. Captura
- Si la última semilla cae en un hoyo vacío del lado del jugador y el hoyo opuesto del rival tiene semillas, el jugador captura todas las semillas del hoyo opuesto y las coloca en su almacén.

**Ejemplo:**  
Turno Jugador 1: escoge **A**

```text
             a       b       c       d       e       f
  |-------------------------------------------------------------|      
  |      |       |       |   2   |       |   1   |       |      |
  |      |-------|-------|-------|-------|-------|-------|      |
  |      |   2   |   3   |       |       |   5   |       |      |
  |-------------------------------------------------------------|
             A       B       C       D       E       F
```

Después del movimiento (Turno Jugador 2):

```text
             a       b       c       d       e       f
  |-------------------------------------------------------------|      
  |      |       |       |       |       |   1   |       |      |
  |      |-------|-------|-------|-------|-------|-------|  2   |
  |      |       |   4   |   1   |       |   5   |       |      |
  |-------------------------------------------------------------|
             A       B       C       D       E       F
```

**Comentario:** El Jugador 1 mueve las semillas del hoyo A. La última cae en C, que estaba vacío. El hoyo opuesto (c minúscula) tenía 2 semillas, por lo que se capturan y se colocan en el almacén.

---

## 4. Fin del Juego
- El juego termina cuando un jugador no puede hacer más movimientos porque su lado está vacío.
- El jugador rival coloca las semillas restantes de su lado en su almacén.
- Gana el jugador que tenga más semillas en su almacén.

**Ejemplo:**  
Turno Jugador 1: escoge **E**

```text
             a       b       c       d       e       f
  |-------------------------------------------------------------|      
  |      |       |       |   2   |       |   1   |       |      |
  |  10  |-------|-------|-------|-------|-------|-------|  11  |
  |      |       |       |       |       |       |   2   |      |
  |-------------------------------------------------------------|
             A       B       C       D       E       F
```

Después del movimiento:

```text
             a       b       c       d       e       f
  |-------------------------------------------------------------|      
  |      |       |       |   2   |       |   1   |   1   |      |
  |  10  |-------|-------|-------|-------|-------|-------|  12  |
  |      |       |       |       |       |       |       |      |
  |-------------------------------------------------------------|
             A       B       C       D       E       F
```

Como no hay más movimientos posibles para el Jugador 1, el juego termina y se colocan las semillas restantes del Jugador 2 en su almacén.

Resultado final:

```text
             a       b       c       d       e       f
  |-------------------------------------------------------------|      
  |      |       |       |       |       |       |       |      |
  |  14  |-------|-------|-------|-------|-------|-------|  12  |
  |      |       |       |       |       |       |       |      |
  |-------------------------------------------------------------|
             A       B       C       D       E       F
```

Gana el Jugador 2 (14 > 12).