# blackout
Java Spring Boot Backend API to allow persons to subscribe to "blackout" notifications: unexpected or scheduled electricity (or other utility) shortages

Many companies in the public utility sector does not have yet an effiecent way to provide notifications to their clients about planned
or accidental distruption  of their services.

This project is imagned as three main parts:


1. A java restful API to allow users (persons) to register their intent to recieve notifications, store their preferences: exampel street-name, city name, gps coordinates
2. A mobile app that will display and alert the users about service interuptions happening in their region
3. A scraper app that will scrape the websites (or other channels) of major utility companies

