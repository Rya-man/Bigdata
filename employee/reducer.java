package employee;
import java.io.*;
import java.util.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
public class reducer extends MapReduceBase implements Reducer<Text,DoubleWritable,Text,DoubleWritable>
{
    public void reduce(Text key,Iterator<DoubleWritable> value,OutputCollector<Text,DoubleWritable> output ,Reporter r) throws IOException
    {
   	 Double sum=0.;
	 int c =0;
   	 while(value.hasNext())
   	 {
   		 sum+=value.next().get();
		 c+=1;
   	 }
   	 output.collect(new Text ("Gender= " + key + "Count= "+c),new DoubleWritable(sum));
   }
}