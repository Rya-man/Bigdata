package employee;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,DoubleWritable>{
    public void map(LongWritable key,Text value,OutputCollector<Text,DoubleWritable> o, Reporter r)throws IOException{
        String[] l = value.toString().split("\\t");

        Double salary = Double.parseDouble(l[8]);

        o.collect(new Text(l[3]),new DoubleWritable(salary));
        
    }
}