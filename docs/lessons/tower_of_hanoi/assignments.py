""" MILD assignment: Move n rings from tower source to tower destination and
print the moves of each ring. """

def hanoi_mild(n, source, destination, parking):
    """ Move n rings from tower source to tower destination """
    if n == 0:
        # No more rings to move        
        return None
    
    # move n-1 rings from source to parking
    # you should complete the following line
    # hanoi_mild(n-1, )
    print("Move ring %s from source %s to destination %s" % (n, source, destination))
    
    # move n-1 rings from parking to destination
    # you should complete the following line
    # hanoi_mild(n-1, )

# Call the function like this:
# n = 3 you may try with other number of rings as well 4, 5, 6, ....
# hanoi_mild(n, "A", "C", "B")


""" MEDIUM assignment: Move n rings from tower source to tower destination,
print the moves of each ring and the total number of moves. 
Check if your solution used the least possible number of moves. """

def hanoi_medium(n, source, destination, parking):
    """ Move n rings from tower source to tower destination """
    """ Return the total number of moves """
    if n == 0:
        # No more rings to move
        return 0
    
    # move n-1 rings from source to parking
    # you should complete the following line
    # count_b = hanoi_medium(n-1, )
    print("Move ring %s from source %s to destination %s" % (n, source, destination))
    
    # move n-1 rings from parking to destination
    # you should complete the following line
    # count_a = hanoi_medium(n-1, )
    
    # fix the following line, you should return the total number of moves
    return 0

# Call the function like this:
# n = 3 you may try other numbers of rings as well 4, 5,6, ....
# count = hanoi_medium(n, "A", "C", "B")
# print("Total number of moves: %s" % count)
# print("Total number of moves equal to the formula 2**n - 1: %s" % (count == (2**n -1)))


""" SPICY assignment: Move n rings from tower source to tower destination,
print the moves of each ring, the list of rings on each tower after each move
and the total number of moves. Check if your solution used the least possible
number of moves. """

def hanoi_spicy(n, source, destination, parking):
    """ Move n rings from tower source to tower destination """
    """ Return the total number of moves """
    """ List rings on each tower """
    if n == 0:
        # No more rings to move
        return 0
    
    # move n-1 rings from source to parking
    # you should complete the following line
    # count_b = hanoi_spicy(n-1, )
    print("Move ring %s from source %s to destination %s" % (n, source[0], destination[0]))
    
    # move the ring from source list to destination list
    # HINT: source and destination lists should reflect the move of the ring
    # HINT: you should remove the ring from one list and add it to the other one
    # ADD YOUR CODE HERE
    
    # print the lists to see how the rings and towers look like
    print("A: %s, B: %s, C: %s" % (A[1], B[1], C[1]))
    
    # move n-1 rings from parking to destination
    # you should complete the following line
    # count_a = hanoi_spicy(n-1, )
    
    # fix the following line, you should return the total number of moves
    return 0
    
# n = 3 you may try other numbers as well 4, 5,6, ....
# A = ["A", list(range(n,0,-1))]
# B, C = ["B", []], ["C", []]
# print("A: %s, B: %s, C: %s" % (A[1], B[1], C[1]))
# count = hanoi_spicy(n, A, C, B)
# print("Total number of moves: %s" % count)
# print("Total number of moves equal to the formula 2**n - 1: %s" % (count == (2**n -1)))
