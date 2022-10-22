Feature: Eliminar un cliente por su id

  Scenario:   Eliminar un usuario por su id
    When se envia el id 2 de un usuario para eliminar
    Then se espera el codigo de resputes 204