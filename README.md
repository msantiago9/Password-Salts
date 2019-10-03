# Password-Salts
A CSC 4222 Project on MD5 hashed passwords and salts

The task was to:
1) Create a password verifier (a log-in system)
1.1. Convert user input into a hash value (MD5Digest of password|salt concatenation)
1.2. Compare the generated hash with the database's stored hash
1.3. If they are equal, then the password+salt are correct for the given User ID.

2) Create a brute force system
2.1. Take in a user ID
2.2. Iterate through every combination of password and salt
2.3. Generate a hash for each combination
2.4. Match the correct hash with the hash stored in the database
2.5. That match will be the password and salt for the specific UID.

What does each class do?
Database - loads the contents of the text files "Hash.txt" and "UID.txt" into two arrays. It essentially keeps the Hashes and UIDs in RAM for later accessing.
HashController - performs operations involving hash. This includes: generating a hash, comparing two hashes, and also converting a byte array to a hexadecimal string.
PasswordVerified - Performs task 1. It consists of a main method, and a retry method
PasswordCracker - Performs task 2. It brute forces every password and salt combination using an nested for loop. It can either brute force one password + salt, or all of passwords and salts in the database (If the "hacker" inputs 0 into as the UID). It also has a retry method.
