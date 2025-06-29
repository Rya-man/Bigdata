package employee;
import java.io.IOException;
import java.util.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.Path;

public class driver{
    public static void main(String args[])throws IOException
    {
        JobConf c = new JobConf(driver.class);
        c.setMapperClass(mapper.class);
        c.setReducerClass(reducer.class);
        c.setOutputKeyClass(Text.class);
        c.setOutputValueClass(DoubleWritable.class);
        FileInputFormat.addInputPath(c,new Path(args[0]));
        FileOutputFormat.setOutputPath(c,new Path(args[1]));
        JobClient.runJob(c);
    }
}