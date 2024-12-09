# **Futbol Fan** 🏆  

¡Bienvenido a **Futbol Fan**, una app hecha en android studio, a la cual todavía le falta mucho por mejorar!  

---

## **Características principales**  

- **Registro e inicio de sesión**
  - Puedes registrarte como usuario con un username, email y contraseña
  - Puedes iniciar sesión con tu username y contraseña

- **Gestión de ligas**  
  - Crea y borra ligas tanto personalizadas como profesionales(si quieres tener guardados tus equipos favoritos).

- **Gestión de equipos**  
  - Al pinchar sobre una liga te aparecerán los equipos de dicha liga
  - Puedes crear y borrar equipos(aunque hay un fallo que no refresca la pagina de los equipos) 

- **Gestión de jugadores**  
  - Registra jugadores con datos como nombre, número, posición, nacionalidad y fecha de nacimiento
  - Crea y borra a tu gusto(tiene el mismo fallo que los equipos parece que hay algun fallo ya que al tener que filtrar para volver a hacerlo es complicado) 

- **Implementaciones varias y cosas por resolver en un futuro**  
  - Gracias a dataStore Preferences podemos cambiar el tema de la app(claro y oscuro) 
  - Tiene un Interceptor para añadir un mensaje a la solicitud si esta lleva un token consigo
  - Hay navegación entre fragmentos de una manera casi perfecta
  - Se ha casi arreglado el problema del timeout al iniciar la app usando un client(okHttpClient) que añade un tiempo de espera de 30 segs(mas/menos), aunque a veces suele fallar
  - Para resolver tenemos el perfil del usuario porque esta casi implementado faltaria poder actualizar el usuario en si, hay un boton que hace un logout
  - Los detalles del jugador fallan porque al hacer la petición devuelve un jugador en null y no se arreglarlo
        
 
