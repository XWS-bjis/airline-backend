 db = new Mongo().getDB('airline');

 db.createCollection('user');

 db.user.insert(
     {
         "name": "jelena",
         "surname": "petric",
         "userName":"Admin",
         "email": "email.com",
         "password":"$2a$10$AmSd1Bo28xit.Cq947HO0exPCnL2VUZ5eTAwgkMP7MfDl6sscz60O", //123
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

 db.user.insert(
     {
         "name": "bojana",
         "surname": "zekanovic",
         "userName":"Regular",
         "email": "emaili.com",
         "password":"$2a$10$AmSd1Bo28xit.Cq947HO0exPCnL2VUZ5eTAwgkMP7MfDl6sscz60O", //123
         "address": {
             "streetNumber": "15",
             "streetName": "ulica",
             "postalCode": "78389",
             "town": "bp",
             "country": "srb"
         },
         "role":{
             "type":"ROLE_REGULAR"
         }
     }
 );

 db.createCollection('flight');

 db.flight.insert(
     {
        "takeOfDate": new ISODate("2023-03-24T10:01:43.161Z"),
         "landingDate": new ISODate("2023-03-24T10:01:43.161Z"),
         "landingPlace": "LONDON",
         "departurePlace": "OSLO",
         "ticketPrice": 90.0,
         "totalSeatsNumber": 50,
        "availableSeatsNumber": 50
     }

 );

 db.flight.insert(
     {
         "takeOfDate": new ISODate("2023-04-12T10:01:43.161Z"),
         "landingDate": new ISODate("2023-04-12T10:01:43.161Z"),
         "landingPlace": "BELGRADE",
         "departurePlace": "TIVAT",
         "ticketPrice": 45.0,
         "totalSeatsNumber": 50,
         "availableSeatsNumber": 50
     }

 );


 db.flight.insert(
     {
         "takeOfDate": new ISODate("2023-04-21T10:01:43.161Z"),
         "landingDate": new ISODate("2023-04-21T10:01:43.161Z"),
         "landingPlace": "MOSCOW",
         "departurePlace": "PARIS",
         "ticketPrice": 60.0,
         "totalSeatsNumber": 50,
         "availableSeatsNumber": 50
     }

 );

db.createCollection('authenticationRole');
db.authenticationRole.insert(
    {
        "type" : "ROLE_REGULAR"
    }

);

 db.createCollection("reservations");
 db.reservations.insert(
     {
         "flightId": "641edb9b04b4acc8f295ad89",
         "userId":"641edb9b04b4acc8f295ad8a",
         "ticketAmount":20,
         "totalTicketPrice": 1500.0
     }
 )


