package com.movie.script.analysis;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class UniqueWordsMapper extends Mapper<Object, Text, Text, Text> {

    private Text character = new Text();
    private Text word = new Text();

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split(": ");

        character.set(split[0]);

        String line = split[1].replaceAll("[^a-zA-Z ]", "").toLowerCase();
        StringTokenizer tokens = new StringTokenizer(line);

        while (tokens.hasMoreTokens()) {
            word.set(tokens.nextToken());
            context.write(character, word);
        }
    }
}
