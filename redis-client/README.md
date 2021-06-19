# Redis client library playground

## Running main class to test the connection
RedisClientDemo

## Using redis-client installed in current running OS

```
kubectl port-forward svc/redis-primary 63799:6379
redis-cli -h localhost -p 63799
get foo
set foo tanpham
```
