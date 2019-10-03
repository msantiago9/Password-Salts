# Password-Salts
A CSC 4222 Project on MD5 hashed passwords and salts

The task was to:
1. Create a password verifier (a log-in system)
1.1. Convert user input into a hash value (MD5Digest of password|salt concatenation)
1.2. Compare the generated hash with the database's stored hash
1.3. If they are equal, then the password+salt are correct for the given User ID.

2. Create a brute force system
2.1. Take in a user ID
2.2. Iterate through every combination of password and salt
2.3. Generate a hash for each combination
2.4. Match the correct hash with the hash stored in the database
2.5. That match will be the password and salt for the specific UID.
