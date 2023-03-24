 db = new Mongo().getDB('airline');

 db.createCollection('user');

 db.user.insert(
     {
         "name": "jeca",
         "surname": "pet",
         "userName":"jecka",
         "email": "emaili.com",
         "password":"$2a$10$NuqVd6VprcL3wB8jxxXQCuV3sryvkyeZtMZegIvJTIhH9kuVm1BZO",
         "address": {
             "streetNumber": "15",
             "streetName": "ulica",
             "postalCode": "78389",
             "town": "bp",
             "country": "srb"
             },
         "role":{
             "type":"ROLE_ADMIN"
         }
     }
 );

 db.createCollection('flight');

 db.flight.insert(
     {
        "takeOfDate": "2023-03-24T10:01:43.161Z",
         "landingDate": "2023-03-24T10:01:43.161Z",
         "landingPlace": "LONDON",
         "departurePlace": "OSLO",
         "ticketPrice": 2.0,
         "totalSeatsNumber": 50,
        "availableSeatsNumber": 50
     }


 );