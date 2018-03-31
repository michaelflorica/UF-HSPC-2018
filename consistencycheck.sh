#--------------------------------------------------------------------------------------------------------
#A shell script to check consistency of output between two different java solutions for the same problem
#Expected parameters:
#1: path to first solution
#2: path to second solution
#3: problem ID
#--------------------------------------------------------------------------------------------------------

red() { echo "$(tput setaf 1)$*$(tput setaf 9)"; }

javafilePath1=${1}
javafilePath2=${2}
problem=${3}
javafileName1=$(basename $1 .java)
javafileName2=$(basename $2 .java)

#Compile both solutions and put the resulting classes in current directory
javac -d . $javafilePath1
javac -d . $javafilePath2

for i in `seq 1 100`; do

    output1=${problem}${javafileName1}${i}.out
    output2=${problem}${javafileName2}${i}.out

    java ${javafileName1} < in/${problem}${i}.in > ${output1}
    java ${javafileName2} < in/${problem}${i}.in > ${output2}

    DIFF=$(diff ${output1} ${output2})
    if [ "${DIFF}" != "" ]
    then
        red "\nFailed consistency check for test case ${problem}${i}.in\n"
    else
        echo "Passed consistency check for test case ${problem}${i}.in"
    fi
done
echo ""
echo "Removing $javafileName1.class and $javafileName2.class"
rm $javafileName1.class $javafileName2.class

echo "Removing output from solutions"
rm *.out

echo "\nDone!"
