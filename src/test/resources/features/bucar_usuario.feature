Feature: Validacion rest para un user

  Scenario Outline: Buscar usurio por id
    When se consume el servicio get con el id <id>
    Then se espera la respuesta <code> y los siguientes datos del usuario <email> <first_name> <last_name>

    Examples:
      | id | code | first_name | email                  | last_name |
      | 3  | 200  | Emma       | emma.wong@reqres.in    | Wong      |
      | 2  | 200  | Janet      | janet.weaver@reqres.in | Weaver    |

  Scenario Outline: Buscar usurio no registrado por id
    When se consume el servicio get con el id <id>
    Then se espera una respuesta erronea con codigo <code>

    Examples:
      | id | code |
      | 23 | 404  |
      | 22 | 404  |