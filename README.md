# Compiling

    - Run with the command "./run.sh".
        - Make sure when you run "ls" you see the following output, if not "cd" into the folder.
            - "pom.xml  README.md  resources  run.sh  src  target"
    - Runs with maven.

# Contributors
    - Yatin Kare yk72286@uga.edu
        - Insert, Delete, Delete Alternate, Print, Print Length.
    - Rohan Kansal rk66433@uga.edu
        - Search, Find Intersection, Merge, Quit, and command line management.

# Merge Discussion
    ## Psuedocode

    merge()
        String Array [] with all values of numbers
        NodeType temp = head;
        for (String s in array)
            temp.insert(s)

    ## Discussion
        The complexity of this operation is O(n) because the string array and temp are declarations that are done once. There is a for loop that goes over the whole array, of size n where a number is inserted into the current Linked List. This is of size n therefore, the whole function has complexity of n.

# Intersection
    ## PsuedoCode

    intersection()
        String Array [] with all values of user numbers
        NodeType n = head
        String final list;

        for each num in array:
            if this.search(num) > 0
                final list += num


    ## Discussion
        The complexity of this operations is O(n) because the string array, temp node, and string of final list are all constant time operations. There is a for loop that loops over each num in the array, n times and a if condition is ran n times. The statement inside the if conditional is a constant time operation. Overall this means that the total time complexity falls under O(n)
