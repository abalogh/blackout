# blackout
Java Spring Boot Backend API to allow persons to subscribe to "blackout" notifications: unexpected or scheduled electricity (or other utility) shortages

NOTE: This is just a POC spring boot application.

Many companies in the public utility sector do not have yet an efficient way to provide notifications to their clients about planned
or accidental distruption of their services.

This project is imagined as three main parts:


1. A java restful API to allow users (persons) to register their intent to recieve notifications, store their preferences: example street-name, city name, gps coordinates
2. A mobile app that will display and alert the users about service interuptions happening in their region
3. A scraper app that will scrape the websites (or other channels) of major utility companies

