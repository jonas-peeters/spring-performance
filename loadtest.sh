echo "Warming up"
ab -n 10 -d -S -q "http://localhost:8080/original/0?startTime=1980-01-01T00:00:00Z&endTime=2080-01-01T00:00:00Z" > /dev/null
ab -n 10 -d -S -q "http://localhost:8080/json/0?startTime=1980-01-01T00:00:00Z&endTime=2080-01-01T00:00:00Z" > /dev/null
ab -n 10 -d -S -q "http://localhost:8080/mapping/dto/0?startTime=1980-01-01T00:00:00Z&endTime=2080-01-01T00:00:00Z" > /dev/null
ab -n 10 -d -S -q "http://localhost:8080/mapping/jsonignore/0?startTime=1980-01-01T00:00:00Z&endTime=2080-01-01T00:00:00Z" > /dev/null
ab -n 10 -d -S -q "http://localhost:8080/query/0?startTime=1980-01-01T00:00:00Z&endTime=2080-01-01T00:00:00Z" > /dev/null
ab -n 10 -d -S -q "http://localhost:8080/timestamp/0?startTime=0&endTime=1628543823703" > /dev/null
ab -n 10 -d -S -q "http://localhost:8080/optimised/0?startTime=0&endTime=1628543823703" > /dev/null


echo "Running tests"
ab -n 1000 -q "http://localhost:8080/original/0?startTime=1980-01-01T00:00:00Z&endTime=2080-01-01T00:00:00Z"
ab -n 1000 -q "http://localhost:8080/json/0?startTime=1980-01-01T00:00:00Z&endTime=2080-01-01T00:00:00Z"
ab -n 1000 -q "http://localhost:8080/mapping/dto/0?startTime=1980-01-01T00:00:00Z&endTime=2080-01-01T00:00:00Z"
ab -n 1000 -q "http://localhost:8080/mapping/jsonignore/0?startTime=1980-01-01T00:00:00Z&endTime=2080-01-01T00:00:00Z"
ab -n 1000 -q "http://localhost:8080/query/0?startTime=1980-01-01T00:00:00Z&endTime=2080-01-01T00:00:00Z"
ab -n 1000 -q "http://localhost:8080/timestamp/0?startTime=0&endTime=1628543823703"
ab -n 1000 -q "http://localhost:8080/optimised/0?startTime=0&endTime=1628543823703"
