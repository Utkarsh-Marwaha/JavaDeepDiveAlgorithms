Another strategy of dealing with hash collisions is that of
chaining. When we use chaining, instead of storing the values
directly in the array, each array index contains a linked list.
So in our example of employees, instead of storing storedEmployees
in each array index, we would be having a linked list.

Since linked lists are not bound by size therefore, we can deal with
as many elements as there exist with the same hash code.

The draw back to this approach is that since there is a linked list
at every index, therefore we need to traverse through it for
retrieving our desired employee (if it is indeed present in the
hash table). This burden of this limitation is not felt as greatly
when we have a good hash function and a good load factor.

