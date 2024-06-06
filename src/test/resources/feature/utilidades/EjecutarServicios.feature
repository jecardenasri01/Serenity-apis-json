@cucumber
Feature: HU_23744

  @1 @post
  Scenario Template: 1 - Ejecutar servicios
    Given iniciar ejecucion servicios
    And ejecutar get usuarios
    When  traer usuario
    Examples:
      | usuario | Clave |
      | usuario | clave  |
