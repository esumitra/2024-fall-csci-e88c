# Kafka Streams Application
The project illustrates how to develop Kafka Streams applications running Kafka in docker.

## Kafka in docker
In the ./docker/kafka directory,

1. To start Kafka

`docker compose up -d`

2. To stop Kafka

`docker compose down`

3. To connect to the running broker

`docker exec -it kafkastreams-broker1-container /bin/bash`

## kcat tool
See https://github.com/edenhill/kcat for more information

To install on Mac OS: `brew install kcat`

### Commands
1. To list topics

`kcat -L -b localhost:9092`

2. To send transactions one at a time

a. start the console producer

`kcat -b localhost:9092 -t transactions-input-topic -K: -P << EOF`

b. send a messages using the format below. Terminate messages with an EOF token

`2:{"number" : 1,"cardType" : "GOLD","amount" : 100.0,"accountNumber" : "x1","expiry" : "2021-08-08T21:27:56.753371", "transactionTime" : "2021-08-08T21:27:56.753371"}`

3. To send messages from a file

`kcat -P -b localhost:9092 -t transactions-input-topic -K: -l data/sample-transactions.txt`

4. To read messages from a topic

`kcat -C -b localhost:9092 -t transactions-output-topic -f 'Topic %t [%p] at offset %o: key %k: %s\n' -q`

## kafka-producer-perf-test tool
1. To connect to broker

`docker exec -it kafkastreams-broker1-container /bin/bash`

2. Send random messages to a topic
`kafka-producer-perf-test --producer-props bootstrap.servers=broker1:9092 --topic orders --throughput 1 --record-size 100 --num-records 10`

3. Send messages from a file to a topic
`kafka-producer-perf-test --producer-props bootstrap.servers=broker1:9092 --topic orders --throughput 1  --num-records 10 --payload-file /opt/kafka-data/sample-transactions.txt`

## Steps to run the kafka streams demo applications

### Word Count Example
1. Start kafka

`docker compose up -d`

2. Start a producer to produce messages to the input topic

`kcat -P -b localhost:9092 -t TextLinesTopic -l data/alice-in-wonderland.txt`

3. Start a consumer to print messages in the result topic

`kcat -C -b localhost:9092 -t WordsWithCountsTopic -f 'Topic %t [%p] at offset %o: key %k: %s\n' -q`

4. Run the kafka streams application

`sbt "runMain org.cscie88c.week11.WordCountApp"`

5. Stop all producers and consumers and exit containers
Ctrl-C on sbt and kcat processes

6. Shutdown all containers

`docker compose down`


## License
Copyright 2023, Edward Sumitra

Licensed under the Apache License, Version 2.0.

