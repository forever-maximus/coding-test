# Services Vic Coding Test

This is a Mule API which takes the input person details json payload, transforms the data, queries an external weather service and then returns a combined json payload.

## Usage

The API exposes one endpoint /api/v1/transform which can be called via HTTP on port 8081 to process and transform the input. Below is a guide on how to set this up on your local machine and example usage.

### Requirements

* Mule 4.2.0
* Anypoint Studio 7.3.3 (or higher)

### Installation

1. Clone the repo down to your local machine and import into Anypoint Studio (ensure using compatible version). 
2. After import completes, right-click and run the project. 
3. Once running you will be able to send HTTP requests to the API (see below example usage).

### Example Usage

Use any HTTP client to send POST request to /api/v1/transform endpoint (curl used below)

Input:
```sh
curl -X POST -H "Content-Type: application/json" -d '{
  "Header": [
    "firstName",
    "lastName",
    "dateTime",
    "city",
    "country"
  ],"Items": [
    "Gary",
    "Oak",
    "31012019T1900Z",
    "Darwin",
    "Australia"
  ]
}' http://localhost:8081/api/v1/transform
```

Output:
```sh
{
  "lastName": "Oak",
  "firstName": "Gary",
  "timezone": "UTC+09:30",
  "offset": "+09:30",
  "fullName": "Gary Oak",
  "temperatureCelsius": 25.34,
  "dateTime": "2019-06-23T11:39:21+09:30",
  "city": "Darwin",
  "country": "Australia"
}
```

## Assumptions

Due to ambiguous requirements the datetime/timezone/offset in the json output is based on the location you are querying from the external openweather api. So if the input json has a location of Darwin, the output will include the datetime/timezone/offset for Darwin when this weather reading was taken (which should be current).

## Improvements

* Add a security policy via Anypoint Platform such as client id/secret or OAuth to lock down usage.
* Use HTTPS so traffic between API is encrypted.
* Add MUnit tests.