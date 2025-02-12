package com.movie.script.analysis;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DialogueLengthMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable wordCount = new IntWritable();
    private Text character = new Text();

    static enum CharacterCounter { CHARACTERS };

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split(": ");

        character.set(split[0]);
        wordCount.set(split[1].length());

        context.getCounter(CharacterCounter.CHARACTERS).increment(split[1].length());

        context.write(character, wordCount);
    }
}
