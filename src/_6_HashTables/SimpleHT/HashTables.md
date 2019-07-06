
Introduction
------------

A Hash table is an abstract data type just as lists, stacks,
queues and sets and you may have worked with a hash table before
without even realizing it.

A hash table provides access to data using keys which means that
they basically contain key-values pairs. This means that when
we add a value into our hash table it needs to get a corresponding
key which will be used later on to retrieve the item.

Associative Arrays can be thought of as a type of hash table
where in the array indices are the keys and the array elements are
the values. Having said this, the keys for a hash table need not
be an integer always, they can be a string, a character or any
other object of our choice.


Hashing
----------

The keys, as mentioned above can be any be object data type in java
although the truth is that under the bonnet those keys are being
represented as integers. So, to convert the keys (objects) to integers
we hash the keys. This process is known as hashing.

So, hashing maps keys of any data type to integers which means
that a hash function essentially maps these keys to an int.
In java the implicit hash method is Object.hashCode()

It is possible that the there is more than key which get hashed
to the same integer hashcode. This process is known as collision.

Hashing is used in every day life when unique item identifiers like
studentID, employeeID and productID which often don't just
have plain integer values are to be implemented. In all these
situations we write a hash function which converts the unique
identifiers into their usable integer representations.

Load Factor
-----------
An important concept in hash tables is the load factor.
The load factor tells us how filled a hash table is.
Let's say we are backing a table with an array and so the load
factor will tell us how full the array is. This can be simply
computed as

Load Factor = # of items / capacity = size / capacity

It gets used in deciding when should an array (backing the hash
table) be resized. If the load factor is too low, it would suggest
that there is a lot of empty space which is being wasted.
On the other hand if it is too high, the probability of hash code
collisions will increase. This plays a crucial role determining
the complexity of item-retrieval from our hash table.


Summary
-------

 1. Provide a key/value pair
 2. Use a hash function to hash the key to an int value
 3. Store the value at the hashed key value - this is teh index
    into the array