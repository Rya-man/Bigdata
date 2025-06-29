package sales;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>{
    public void map(LongWritable key,Text value,OutputCollector<Text,IntWritable> o, Reporter r)throws IOException{
        String[] l = value.toString().split(",");
        int p = Integer.parseInt(l[2]);
        String c = l[3];
        String co = l[7];
        o.collect(new Text("Country" + co),new IntWritable(p));
        o.collect(new Text("Card" + c),new IntWritable(1));
    }
}