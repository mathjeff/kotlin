#!/usr/bin/env bash

ALL_PARAMS="$konanCompilerArgs"
MEMORY_MODEL=$1

if [ $MEMORY_MODEL = "New" ]; then
  ALL_PARAMS="$ALL_PARAMS -memory-model experimental"
fi

echo "##teamcity[setParameter name='env.konanCompilerArgs' value='$ALL_PARAMS']"
