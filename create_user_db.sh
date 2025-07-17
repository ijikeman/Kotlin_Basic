#!/bin/bash
rm -f users.db
sqlite3 users.db "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT UNIQUE NOT NULL, password TEXT NOT NULL, email TEXT);"
sqlite3 users.db "INSERT INTO users (username, password, email) VALUES ('user1', 'password', 'user1@example.com');"
