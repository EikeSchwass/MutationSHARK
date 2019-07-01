#!/bin/bash

current=`pwd`
mkdir -p /tmp/mutationSHARK/
cp -R ../src /tmp/mutationSHARK
cp * /tmp/mutationSHARK
cd /tmp/mutationSHARK/

tar -cvf "$current/mutationSHARK_plugin.tar" --exclude=*.tar --exclude=build_plugin.sh *
