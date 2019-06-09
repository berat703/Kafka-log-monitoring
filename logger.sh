#!/bin/sh

LOGGING_LEVELS=("INFO" "FATAL" "WARN" "ERROR" "DEBUG")
LOCATION=("Istanbul" "Tokyo" "Moskow" "Beijing" "London")

DIRECTORY_NAME="logs"
FILENAME="log_"$(date "+%Y%m%d%H%M%S")".log"
MAX_FILESIZE=2000000
FULLPATH=$DIRECTORY_NAME/$FILENAME

function checkLogFilesize(){
	if (( $(wc -c $FULLPATH | awk '{print $1}') > $MAX_FILESIZE ))
	then
		createNewLogFile
	fi
}

function createNewLogFile(){
	zip $FULLPATH".zip" $FULLPATH
	rm $FULLPATH
	FILENAME="log_"$(date "+%Y%m%d%H%M%S")".log"
	FULLPATH=$DIRECTORY_NAME/$FILENAME
	touch $DIRECTORY_NAME/$FILENAME
	echo "New log file created: "$FILENAME
}

mkdir -p $DIRECTORY_NAME
touch $DIRECTORY_NAME/$FILENAME
echo "Log file created: "$DIRECTORY_NAME/$FILENAME
echo "starting..."
while :
do
	CHOSEN_LOCATION=${LOCATION[RANDOM%5]}
	echo $(date "+%Y-%m-%d %H:%M:%S:%3N") ${LOGGING_LEVELS[RANDOM%5]}  $CHOSEN_LOCATION "Hello-from-"$CHOSEN_LOCATION >> $DIRECTORY_NAME/$FILENAME
	checkLogFilesize
	#sleep .5
done

