# solid-octo-broccoli
TP2 - Algo Empires: juego por turnos basado en el clásico juego Age of Empires II.

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build Status](https://travis-ci.org/IgVelasco/solid-octo-broccoli.svg?branch=master)](https://travis-ci.org/IgVelasco/solid-octo-broccoli)
[![codecov](https://codecov.io/gh/IgVelasco/solid-octo-broccoli/branch/master/graph/badge.svg)](https://codecov.io/gh/IgVelasco/solid-octo-broccoli)

### Informe
https://www.overleaf.com/read/cyrypgjrkfmx


# Entrega 1 (Semana del 12 de noviembre)

## Pruebas del espacio mapa
- [x] Tamaño
- [x] Colocar unidades y edificios

## Pruebas de unidades
- [x] Pruebas de movimiento y dirección (1 casillero por turno en las 8 posibles direcciones, siempre y cuando no intenten ir más allá del mapa)
  - [x] Aldeano
  - [x] Arquero
  - [x] Espadachín
  - [x] Arma de asedio
- [x] Pruebas de construcción
  - [x] Aldeano
    - [x] Verificar construcción de cuartel y plaza central
    - [x] Verificar que se haga en los turnos propios al jugador
    - [x] Verificar que no suma oro
- [x] Pruebas de reparación
  - [x] Aldeano
    - [x] Verificar reparación
    - [x] Verificar que finalizada la reparación, sume oro
    
## Pruebas de edificios
- [x] Cuartel crea:
  - [x] Espadachín
  - [x] Arquero
- [x] Plaza central crea aldeano
- [x] Castillo crea arma de asedio

# Entrega 2 (Semana del 19 de noviembre)

## Distribución de los jugadores en el mapa
- [ ] Pruebas de inicio del juego, posición, edificios, aldeanos y oro necesarios

## Reglas de población
- [ ] Crear unidades => sube la población
- [ ] Matar unidades => baja población
- [ ] Matar aldeanos => baja población y baja producción de oro
- [ ] Verificar tope poblacional

## Pruebas de distancia y ataques
- [ ] Unidades
- [ ] Castillo
