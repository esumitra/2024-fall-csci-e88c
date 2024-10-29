#!/bin/bash
ROOT_FOLDER=$(pwd)/../../../
echo "ROOT_FOLDER: $ROOT_FOLDER"

# Variables
SOURCE_FILE="$ROOT_FOLDER/docker/beam/data/taxi_tripdata.csv"
DEST_FOLDER="$ROOT_FOLDER/target/taxicab-stream"
# SOURCE_FILE="$ROOT_FOLDER/src/main/resources/data/alice-in-wonderland.txt"
# DEST_FOLDER="$ROOT_FOLDER/target/streaming-word-count-input"
BATCH_SIZE=10              # Number of lines to copy per batch
PAUSE_DURATION=30           # Pause duration in seconds

# Create the destination folder if it doesn't exist
mkdir -p "$DEST_FOLDER"

# Initialize the line counter
line_count=0

# Read the source file line by line
while IFS= read -r line
do
    # Determine the output file for the current batch
    batch_number=$((line_count / BATCH_SIZE + 1))
    output_file="$DEST_FOLDER/batch_$batch_number.txt"

    # Append the current line to the appropriate batch file
    echo "$line" >> "$output_file"

    # Increment the line counter
    line_count=$((line_count + 1))

    # If we've reached the batch size, pause for the specified duration
    if (( line_count % BATCH_SIZE == 0 )); then
        sleep "$PAUSE_DURATION"
    fi
done < "$SOURCE_FILE"

echo "Done copying in batches of $BATCH_SIZE lines."
