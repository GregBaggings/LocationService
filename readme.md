# Location Service

This project is about to try out Spring Boot with JSON background and to create a full test lifecycle for it.

---

## REST Endpoints:

**Add Country:**<br />
_Endpoint:_ /loc-svc/v1/addCountry <br />
_Request Params:_

Parameter name | Type 
------------ | -------------
continent | String 
locale | String
capital | String
country | String

Example: http://localhost:8080/loc-svc/v1/addCountry?continent=Europe&locale=hu_HU&country=Hungary&capital=Budapest
<br />
<br />
**Update Country Service:** <br />
_Endpoint:_ v1/updateCountry/{id} <br />
_Request Params:_

Parameter name | Type
------------ | -------------
continent | String
locale | String
capital | String
country | String

Example: http://localhost:8080/loc-svc/v1/updateCountry/16?continent=Europe&country=Turkey&capital=Ankara&locale=not_defined
<br />
<br />
**Remove Country Service:**<br />
_Endpoint:_ /loc-svc/v1/deleteCountry<br />
_Request Params:_

Parameter name | Type
------------ | -------------
id | Integer

Example: localhost:8080/loc-svc/v1/deleteCountry?id=1
<br />
<br />
**List Coutries Service:**<br />
_Endpoint:_ /loc-svc/v1/listCountries/ <br />
*Example:* http://localhost:8080/loc-svc/v1/listCountries/
<br />
<br />
**Capital Service:**<br />
_Endpoint:_ /loc-svc/v1/capital/ <br />
_Path parameter:_

Parameter name | Type
------------ | -------------
continent | String

Example: http://localhost:8080/loc-svc/v1/capital/Turkey
