package weather;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
class reducer extends MapReduceBase implements Reducer<Text,DoubleWritable,Text,DoubleWritable> {
    public void reduce(Text key, Iterator<DoubleWritable> value, OutputCollector<Text,DoubleWritable> output, Reporter r) throws IOException{
   	 Double max=-999999.0;
   	 Double min=999999.0;
   	 while(value.hasNext()){
   		 Double temp=value.next().get();
   		 if(temp>max)
		 max=temp;
   		 if(temp<min)
		 min=temp;
   	 }
   	 output.collect(new Text("Max temp at "+ key), new DoubleWritable(max));
   	 output.collect(new Text("Min temp at "+ key), new DoubleWritable(min));
    }    
}