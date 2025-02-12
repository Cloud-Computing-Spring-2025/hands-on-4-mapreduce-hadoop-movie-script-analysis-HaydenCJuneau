# Hands On - Script Analysis Report

## Project overview
In this hands on assignment, we analyzed a movie script to extract certain features.
We calculated the times each unique word was used, the length of dialogue for each character, and the unique set of words for each character.

## Approach
The program uses three pairs of mapper/reducer.
One pair for each outlined task. They map together the features we want to count, and the reducer acts as a counter for them.

## Execution Steps
1. Build with `mvn install`
1. Move jar into the container: `docker cp <local-path> resourcemanager:<container-path>`
1. Inside the container, create input directory: `hadoop fs -mkdir -p /input/dataset`
1. Copy data into hdfs: `hadoop fs -put <local-file> /input/dataset/`
1. Remove output folder if already existing: `hadoop fs -rm -r /otuput`
1. Run the Job: `hadoop jar <jar-name> <main-class-path> /input/dataset/<input-filename> /output`
1. Extract the output: `hdfs dfs -get /output <local-path>`
1. Copy out of Docker: `docker cp resourcemanager:<docker-path> <local-path>`

## Challenges
This assignment was not too hard after using MapReduce once.
The hardest part about working in this framework is the lack of documentation online for different tools and needs.
The flow of data makes sense after working with it for a while.

## Sample Input
Find the input used for the assignment in the /input directory.
Find sample output for each MapReduce job in the output directory.
The output directory also contains screenshots from the counters used inside of the program.