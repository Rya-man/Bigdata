package wordcount;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>{
    public void map(LongWritable key,Text value,OutputCollector<Text,IntWritable> o, Reporter r)throws IOException{
        String[] l = value.toString().split(" ");

        for(String a: l)
        o.collect(new Text(a),new IntWritable(1));
        
    }
}