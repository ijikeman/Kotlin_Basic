#!/bin/bash
rm -f mydb.sqlite3
sqlite3 mydb.sqlite3 "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE NOT NULL, password TEXT NOT NULL);"
sqlite3 mydb.sqlite3 "INSERT INTO users (name, password) VALUES ('user1', 'password');"
