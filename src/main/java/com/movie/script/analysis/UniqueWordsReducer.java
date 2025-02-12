package com.movie.script.analysis;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashSet;

public class UniqueWordsReducer extends Reducer<Text, Text, Text, Text> {

    static enum UniqueCounter { UNIQUEWORDS, UNIQUECHAR };

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        HashSet<String> unique = new HashSet<>();

        context.getCounter(UniqueCounter.UNIQUECHAR).increment(1);

        for (Text t : values) {
            unique.add(t.toString());

            context.getCounter(UniqueCounter.UNIQUEWORDS).increment(1);
        }

        context.write(key, new Text(unique.toString()));
    }
}
