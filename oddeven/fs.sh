source ../bash.sh
javac -d . *.java
jar cfm $1.jar Manifest.txt $1/*.class

hadoop jar $1.jar $2 output1
# hadoop jar $1.jar $1.driver $2 output2

cat output1/*
# cat output2/*


rm -rf output1
# rm -rf output2