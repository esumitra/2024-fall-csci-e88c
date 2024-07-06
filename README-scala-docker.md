# Docker based scala  environment

In project root,

1. Pull docker image
```
docker pull sbtscala/scala-sbt:eclipse-temurin-17.0.4_1.7.1_3.2.0
```

2. Run a terminal in docker
```
docker run -v `pwd`:/workspaces/2024-fall-cscie88c -it --rm sbtscala/scala-sbt:eclipse-temurin-17.0.4_1.7.1_3.2.0 /bin/bash
```

3. cd to the mounted volume

```
cd /workspaces/2024-fall-cscie88c
```

4. Run and test the Scala application
```
sbt "run Harvard"

sbt test
```

5. Exit shell
```
exit
```
