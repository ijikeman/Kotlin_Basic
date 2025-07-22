#!/bin/bash
sqlite3 mydb.sqlite3 "INSERT INTO users (name, password) VALUES ('admin', 'adminpass');"
sqlite3 mydb.sqlite3 "INSERT INTO users (name, password) VALUES ('testuser', 'testpass');"
