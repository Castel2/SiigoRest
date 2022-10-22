Feature: Actualizar cliente

  Scenario: Actualiza un cliente por su id
    When se envia la informacion del usuario 2 para actualizar
      | name   | job      |
      | Castel | Contador |
    Then se espera la respuesta 200 y los mismos datos enviados con la fecha de actualizacion Castel, Contador, 2022-10-22