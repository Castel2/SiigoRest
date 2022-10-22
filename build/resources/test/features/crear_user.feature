Feature: Crear usuario

  Scenario: Crear Usuario
    When se envia la informacion del usuario
      | name   | job                       |
      | Castel | Ing.Sistemas Informaticos |
    Then se espera la respuesta 201 y los mismos datos enviados con la fecha de creacion Castel, Ing.Sistemas Informaticos, 2022-10-22