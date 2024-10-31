#!/bin/bash
sleep 10;
mongosh --host mongo1 --port 27017 --eval 'rs.initiate()'