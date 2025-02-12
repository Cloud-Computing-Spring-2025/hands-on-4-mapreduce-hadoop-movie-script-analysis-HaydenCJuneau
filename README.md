# Hands On - Script Analysis Report

## Configuration Steps
1. Build with `mvn install`
1. Move jar into the container: `docker cp <local-path> resourcemanager:<container-path>`
1. Inside the container, create input directory: `hadoop fs -mkdir -p /input/dataset`
1. Copy data into hdfs: `hadoop fs -put <local-file> /input/dataset/`
1. Remove output folder if already existing: `hadoop fs -rm -r /otuput`
1. Run the Job: `hadoop jar <jar-name> <main-class-path> /input/dataset/<input-filename> /output`
1. Extract the output: `hdfs dfs -get /output <local-path>`
1. Copy out of Docker: `docker cp resourcemanager:<docker-path> <local-path>`