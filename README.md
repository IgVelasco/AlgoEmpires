# solid-octo-broccoli
TP2 - Algo Empires: juego por turnos basado en el clásico juego Age of Empires II.

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build Status](https://travis-ci.org/iPetrignani/solid-octo-broccoli.svg?branch=master)](https://travis-ci.org/iPetrignani/solid-octo-broccoli)
[![codecov](https://codecov.io/gh/iPetrignani/solid-octo-broccoli/branch/master/graph/badge.svg)](https://codecov.io/gh/iPetrignani/solid-octo-broccoli)

# Entrega 1 (Semana del 12 de noviembre)

## Pruebas del espacio mapa
- [ ] Tamaño
- [ ] Colocar unidades y edificios

## Pruebas de unidades
- [ ] Pruebas de movimiento y dirección (1 casillero por turno en las 8 posibles direcciones, siempre y cuando no intenten ir más allá del mapa)
  - [ ] Aldeano
  - [ ] Arquero
  - [ ] Espadachín
  - [ ] Arma de asedio
- [ ] Pruebas de construcción
  - [ ] Aldeano
    - [ ] Verificar construcción de cuartel y plaza central
    - [ ] Verificar que se haga en los turnos propios al jugador
    - [ ] Verificar que no suma oro
- [ ] Pruebas de reparación
  - [ ] Aldeano
    - [ ] Verificar reparación
    - [ ] Verificar que finalizada la reparación, sume oro
    
## Pruebas de edificios
- [ ] Cuartel crea:
  - [ ] Espadachín
  - [ ] Arquero
- [ ] Plaza central crea aldeano
- [ ] Castillo crea arma de asedio
