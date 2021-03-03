# blackout
Java Spring Boot Backend API to allow persons to subscribe to "blackout" notifications: unexpected or scheduled electricity (or other utility) shortages

NOTE: This is just a POC spring boot application.


Many companies in the public utility sector do not have yet an efficient way to provide notifications to their clients about planned
or accidental distruption of their services.
This project is imagined as three main parts:

1. A java restful API to allow users (persons) to register their intent to recieve notifications, store their preferences: example street, city, state
2. A mobile app that will display and alert the users about service interuptions happening in their region
3. A scraper app that will scrape the websites (or other channels) of major utility companies

Running the REST APIs

1. Install keycloak (https://www.keycloak.org/downloads) locally and start it with:
```
standalone.bat -Djboss.socket.binding.port-offset=100
```
Setup the a new Realm "Blackout" and a client and a user to it

2. Start usersApi with 
```
mvn spring-boot:run
```
3. Obtain an access token from 
```
POST http://localhost:8180/auth/realms/Blackout
Content-Type: application/x-www-form-urlencoded

client_id=<YOUR_OUATH_CLIENT>&username=<OUATH_USER>&password=<OUATH_PASSWORD>&grant_type=password

```

4. Call any API endpoint with Authorization Bearer ... Header or use swagger-ui to inspect any try the api
```
http://localhost:8080/swagger-ui.html
```  