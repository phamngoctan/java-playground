# Domain Driven Design as the core idea used inside a rest client only project
Specification:

- Using jakarta-ee API
- Calling CoinGecko APi v3
- Using Payara application server

This project is inspired by this repo [https://github.com/Philipinho/CoinGecko-Java]

## Prerequisite

- Required Java 8 at least
- Basic knowledge using Docker

## How to build the application

```
mvn clean install

docker build -t ddd-restclient .
```

## How to start the application

```
docker run -d -p 8080:8080 --name ddd-restclient ddd-restclient

```

## How to test

```
curl localhost:8080/ddd-restclient/coins
```