package com.movie.script.analysis;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class CharacterWordMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    
    static enum LineWordCounters { LINES, WORDS };

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString().split(": ")[1];
        line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        StringTokenizer tokens = new StringTokenizer(line);

        context.getCounter(LineWordCounters.LINES).increment(1);

        while (tokens.hasMoreTokens()) {
            context.getCounter(LineWordCounters.WORDS).increment(1);

            word.set(tokens.nextToken());
            context.write(word, one);
        }
    }
}
