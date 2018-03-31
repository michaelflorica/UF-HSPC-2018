#--------------------------------------------------------------------------------------------------------
#A shell script to generate output for a problem using a java solution
#Expected parameters:
#1: path to java solution
#2: problem ID
#--------------------------------------------------------------------------------------------------------


javafilePath=${1}
problem=${2}
javafileName=$(basename $1 .java)

#compile passed java file
javac -d . $javafilePath

mkdir -p out
for i in `seq 1 100`; do

    echo "Generating output for $problem$i.in using $javafileName.java"
    out=${problem}${i}.out
    java $javafileName < in/$problem$i.in > out/$out

done
echo "\nRemoving $javafileName.class"
rm $javafileName.class
echo "\nDone!"
