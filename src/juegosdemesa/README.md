# Móviles
## Juegos de mesa
### 1. Contexto
Un club de juegos de mesa lleva años reuniendose
Su colección ha crecido tanto que ya no recuerdan todos los detalles:
- ¿Qué juegos son de cartas y cuales de tablero?
- ¿Cuantos jugadores admite cada uno?
- ¿Cuánto dura una partida?
- ¿Donde se guardan?

**Problema:** A veces compran juegos repetidos o no encuentran el juego adecuado para el grupo

**Necesidad:** Quieren una aplicación que les permita gestionar su colección de juegos de mesa para consultarla y organizarse mejor

### 2. Requisitos mínimos
La aplicación debe permitir:
- Registrar varios juegos de mesa con sus datos básicos:
    - Titulo
    - Autor
    - Número mínimo y máximo de jugadores
    - Duración media (en minutos)
    - Tipos de juego (estrategia, party y familiares) (enum)
- Distinguir entre juegos de cartas y juegos de tablero, con atributos específicos:
    - Cartas: nº de cartas
    - Tablero: Tamaño de tablero
- Mostrar un menú con opciones
    - Alta de juego
    - Listado de juegos
    - Búsqueda por título
    - Salida de programa
- El programa debe ser robusto:
    - Validar que los nº sean correctos
    - No aceptar datos vacíos
### 4. Requisitos opcionales (avanzados)
- Guardar la colección en un archivo TXT legible y cargarla al iniciar el programa. 
- Usar colecciones dinámicas (ArrayList) para almacenar los juegos. 
- Implementar herencia, encapsulación y polimorfismo:
  - Clase abstracta JuegoMesa. 
  - Subclases JuegoCartas y JuegoTablero. 
  - Método getDescripcion() sobrescrito.
- Usar un enum TipoJuego en lugar de cadenas sueltas.
- Seguir principios SOLID en el diseño de clases.