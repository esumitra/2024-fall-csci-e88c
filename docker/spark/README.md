# Spark Cluster in Docker
This section contains instructions on using a spark standalone cluster with 1 master and 1 or more worker nodes.

**Spark version**: 3.2.1

**Scala version**: 2.13.x

**Java version**: Java 17.x

## Work with the Spark shell interactively
Change directory to the `docker/spark` folder,

1. Start the spark cluster
```
docker compose up -d
```

2. Connect to the master node container. Exit the container at any time by typing in ```exit``` at the command line
```
docker exec -it spark-spark-master-1  /bin/bash
```

3. Start the interactive shell and run commands
```
bin/spark-shell

scala> spark.range(1000 * 1000 * 1000).count()
```

4. View the container logs
```
docker logs <container name>
```
For more logging options see: https://docs.docker.com/engine/reference/commandline/logs/


5. Stop spark clusters
```
docker compose down
```


## Submit a Spark job to the Docker cluster
1. Compile and package the scala application
```
sbt compile assembly
```

2. Copy the application to the Docker shared volume
```
cp target/scala-2.13/SparkAdvancedApp.jar docker/spark/apps
```

3. Start the spark cluster
```
docker compose up -d
```

4. Connect to the master node container. Exit the container at any time by typing in ```exit``` at the command line
```
docker exec -it spark-spark-master-1  /bin/bash
```

5. Submit the spark job
```
./bin/spark-submit --class "com.example.sparkadvanced.SparkAdvancedApp" --master local[4] /opt/spark-apps/AdvancedSparkApp.jar
```

6. Review results
```
ls docker/spark/data/output OR
search for 'XXX' prefix in logs
```

7. Exit terminal
```
exit
```

8. Shutdown Docker
```
docker compose down
```

9. Scaling workers

To scale the job horizontally by using more workers use the `--scale <service>=<n>` option to start the cluster with more workers.

```
docker compose up --scale spark-worker=3
```

## License
Copyright 2024, Edward Sumitra

Licensed under the MIT License.