## Jenkins simple library
This is a simple example on how to have all the pipelines stored in git and jenkins configured automatically on startup.
### Steps
- clone this repo locally
- start docker-compose
```
docker-compose up -d
```
- login to jenkins using the default credentials from casc file https://127.0.0.1
- run the `_test-dsl-job` to have the pipelines created
> please note that the test pipeline example is designed to run in kubernetes

Every time there will be an update to the repository the jobs will be updated.
