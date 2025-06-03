# Uso de Minimax con Poda Alpha-Beta en Mancala

Para que el agente sintético pueda tomar decisiones, se implementa un algoritmo clásico de inteligencia artificial conocido como **Minimax con poda Alpha-Beta**. Este algoritmo permite al agente simular múltiples posibles movimientos y sus consecuencias futuras, eligiendo siempre la jugada que maximiza sus posibilidades de victoria, asumiendo que el oponente también jugará de forma óptima.

El **algoritmo Minimax** se basa en un árbol de decisiones donde los nodos representan los estados del tablero y los niveles alternan entre turnos del jugador y del oponente. En cada paso, el algoritmo selecciona el movimiento que ofrece el mejor resultado posible considerando que el oponente intentará minimizar ese resultado.

Para mejorar la eficiencia del algoritmo, se utiliza una técnica llamada **poda Alpha-Beta**, que evita explorar ramas del árbol que no pueden influir en la decisión final. Esto permite reducir significativamente el número de movimientos simulados, logrando tiempos de respuesta razonables incluso con varios niveles de profundidad en el análisis.

Este enfoque es especialmente útil en un juego como Mancala, donde:

- Es un juego de turnos donde después del movimiento de un jugador le toca al otro.
- Hay múltiples opciones en cada turno (hasta 6 jugadas posibles).
- El estado del tablero cambia dinámicamente después de cada movimiento.
- Existen reglas especiales como **capturas** y **turnos extra** que pueden cambiar drásticamente la ventaja.

Combinando **Minimax**, **poda Alpha-Beta** y una función de **heurística** que evalúa la calidad de cada estado del tablero, el agente puede tomar decisiones estratégicas que simulan anticipación y planificación, lo cual mejora su rendimiento frente a oponentes humanos o automatizados.

---

# Heurística para el Agente Inteligente

## 1. ¿Qué se quiere lograr con la heurística?

Con la heurística se busca evaluar el tablero y estimar su estado para determinar qué tan favorable es para el jugador. Esta función **no indica directamente si un jugador ha ganado o perdido**, sino que estima cuán buena es la **posición actual** del jugador en términos estratégicos.

## 2. Factores a considerar

- **Diferencia de semillas en los almacenes**: Si un jugador tiene más semillas en su almacén, está más cerca de ganar. Cuanto mayor sea esta diferencia, mejor es el estado para el jugador.
- **Cantidad de semillas en el lado propio**: Tener más semillas en el propio lado del tablero permite más opciones de jugada en turnos futuros.
- **Turnos extra**: Si la última semilla termina en el almacén del jugador, se gana un turno adicional, lo cual es ventajoso.
- **Capturas**: Si la última semilla cae en un hoyo vacío del jugador frente a un hoyo con semillas del oponente, se capturan esas semillas. Esto representa una ventaja significativa.

## 3. Ecuación de la heurística

```plaintext
H = 8 × (Ap - Ao) + (Sp - So) - penalizaciones
```

**Variables:**
- **Ap:** Cantidad de semillas en el almacén del jugador.
- **Ao:** Cantidad de semillas en el almacén del rival.
- **Sp:** Cantidad de semillas en los hoyos del jugador.
- **So:** Cantidad de semillas en los hoyos del rival.
- **penalizaciones:** Penalizaciones aplicadas por posibles ventajas del oponente o situaciones desfavorables.

Penalizaciones: hasta 6 puntos por hoyos del oponente con posibilidad de turno extra, y posibles pérdidas por hoyos vacíos propios frente a hoyos enemigos con semillas.

**Nota importante:** La bonificación por turno extra se considera aparte en la clase AIPlayer, sumando **+30** al valor heurístico cuando una jugada otorga un turno adicional.
