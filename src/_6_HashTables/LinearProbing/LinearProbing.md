Collision Handling
--

Our simple hash table is quite a bare bones implementation of how
one could go about hashing keys to their values. Every time an
employee's last name has the same length as that of another employee,
the hash function fails to accommodate that particular employee in
the hash table. This is obviously suggestive of the fact that we
need to find a strategy which will help us tackle collisions.

Open Addressing
--

With open addressing we will do the following: -

If we try to put an employee into the hash table and discover
that there is already some else who's been hashed to that spot,
then we look for another location in the hash table.
There are a few ways in which one can go about looking for
that different location for the employee but a common technique
which is often put to use is Linear Probing.

With Linear Probing, when we fiqure out a position that has
already been booked for another employee, we increment the hash
value by 1 and then check the resulting index. This process continues
until either an empty index is found or the hash table is assured
to be loaded. This process is known as linear probing because every
time we are incrementing the index, we are doing so in a linear fashion
and every increment of the index is called a probe.

This means that if we had to increment the original index for our
employee twice before finding an empty position for it, we would
be said to have probed twice.

Need less to say that, if the number of probes we are required to
make before correctly inserting an employee's record is lesser, then
the process of insertion will be faster.
