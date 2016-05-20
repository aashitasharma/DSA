# LeetCodeSolutions
Optimized Leet Code solutions in Java
Also study these:

Determine if a string is valid based on placement of parenthesis. i.e. "123(13(44))" is valid but ")234(12)(" is not.  
 During the job fit interview I was asked how to implement a simple web chat system using object oriented techniques. I was then asked how to figure out if a string was a palindrome. 
 You have two linked lists where each list represents some positive number. The ith node in the list represents the ith digit (0-9) of the number. Return a new linked list which represents the sum of the two linked lists.  
 Implement a queue as a stack.
 Find the kth to last term in a linked list  
 Given a string, return the first NON-repeating character that occurs in the string.
EX: "adzbdcab" returns 'z'. 


1) Given a rotated sorted array, find the first occurrence of a certain number X with the lowest possible complexity(both time and space).

X = 6
Arr = 8,9,9,1,3,4,4,4,6,6,7,7

Ans = 8

2) Given a linked like defined so...

typedef node_t {
int data;
node_t* next;
}Node;

check if the linked list is a palindrome without using any extra space and with the lowest possible complexity(both time and space).

write code for following API

BOOL is_palindrome(node *Head);

3) write an algorithm to find the next largest node in a binary tree.

typedef treenode_t{
int data;
treenode_t *parent;
treenode_t *left;
treenode_t *right;
}TreeNode;

TreeNode* find_next_largest_element(TreeNode *node);

Pls add other computer science related questions as well, but let me know which company's interview and when!



My Amazon questions were fairly simple/classic, as I recall. One was about finding the Nth element of a binary search tree; one was about selecting an optimal sort algorithm for a given type of data - ended up coding radix sort, basically; there was one about validating an expression with parentheses; one was about coding a function for flood-filling a 2D matrix; parallel merge of sorted arrays. As for system design, I was designing a shopping cart.

As for the Microsoft questions, there was some big integer multiplication, counting of palindromes within a string, identifying the possibility to sort a partially sorted linked list with a single swap, Hanoi towers, finding Top K elements of an array and a bunch of other really non-classic interview questions that I don't really remember, but actually suitable for competitive programming. My Microsoft loop was interesting, because it was consisted of a 4-hour written test (5 programming tasks + 2 mathematics) and 5 rounds of interviews, although I don't think this typically happens in Redmond.	



I recently went through a lot of interviews and some questions seemed common across companies so I can list the ones where companies did not bound me with an NDA.

    Given an array of integers, find all the 3 numbers that sum up to a target number? (Variants asked by 3 different companies)
    Given a word which can have wild card characters and a dictionary, find if the word is valid? (Catch is to do in O(1), Variants asked by 2 different companies), "d*g" is valid with dict: {dog, god,foo}
    Find all the combinations of size k of a word which are also palindromes? (Again variants asked by 2 companies)

I have a bunch of questions stashed, I will keep adding a new questions if this answer starts getting views/votes.	





Microsoft (India IDC, Full Time):

    Given 2 sorted arrays on size n, find the median of both of them are merged.

Amazon (Internship, India):

    Deleting element from Linked List. Concurrency issues that might occur. Possible solutions.
    Finding diameter of a tree. The question was a story. Boiled down to this.
    Some basic number recurrence and DP. Like Fibonacci.

Google (Internship, US) :

    Rewrite substring searching function
    Rewrite malloc to allocated 16bit aligned memory
    gets, scanf('%s'), getline difference
    There is a BST with floating point numbers in each node. Given a floating point number, find the node closest to it numerically. Full working code + basic question of stack overflow + pointer aliasing. 1 question for whole interview.

Google (Full Time) :

    Given a set of n points in 2D space and a query point, find K nearest neighbours to the query point. 1 question for whole interview
    Progressive Image rendering algorithm. Basically summing up 2 elements of an array and then storing the mean and difference between numbers and mean instead of storing number itself. Keep doing repeatedly until we have mean of all elements. I was explained the algo and asked to implement it.
    Given a dictionary of words and a query word, determine if the any single letter in the query word can be replaced with another letter such that the new word is in dictionary. This is building block for auto correct technology.
    Given a set of N points in 2D space and a query point + a number d, determine the number of points in the set that are within 'd' distance of query point.
    Finding the number of components in a graph. Question boiled down to this. Possible approximation ideas for Vertex Cover (Open discussion)
    Design - Disaster Management - Using smartphones to identify people who are safe.
    Design - Rate limiter for queries. Different approaches and their advantages / disadvantages. Discussion over OS concepts.
	
	
	
	Microsoft :
a) Write a function which simply returns 0X00000000 if input value is 0 else 0XFFFFFFFF. Condition is no branching , no looping and no ternary operators.
Solutions

    int bit(int n)
    {
    return (!n + (n|~n));
    }


b) Infinite bit stream is coming (one bit at a time). At a given time tell whether number is divisible by 3 or not
Solution:

     sum=0;
    while(bit stream is coming)
    {
    sum=sum<<1+1*(current bit);
    if(sum%3==0)
    printf(“divisible\n”);
    else
    printf(“not divisible”);
    }


c) Check whether a given string consists the substring of type “ab*c”
Solution:

      char *str=INPUT STRING
    int i=0,flag=0;
    while(str[i])
    {
    if(str[i++]==’a’)
    {
    while(str[i]==’b’)
    i++;
    if(str[i++]==’c’)
    {
    printf(“substring found”);
    flag=1;
    break;
    }
    }
    }
    if(!flag)
    printf(“substring not found”);
	
	
	
	1. Given a BST and 2 numbers a,b. Find the number of hops to reach from a to b.

2. Given a set of unsorted numbers without a range, find the median. No sort operations should be used. Solution should be of the order n log n.



find the highest salary per department
SQL Queries  
1)- programmingl find the max no from the given set of elements in an array (without using max function)
2)- Find the minimum absolute difference between the set of elements of an array.  

 Create DDL (table and foreign keys) for several tables in a provided ERD. ERD contains at least one many to many relationship.  
Answer Question
Recursively parse a string for a pattern that can be either 1 or 2 characters long.  
Answer Question
Perform a merge-sort with SQL only.  
1 Answer
Given full authority to "make it work", import a large data set with duplicates into a warehouse while meeting the requirements of a business intelligence designer for query speed.  
Answer Question
Query a many to many relationship while not violating the grain of a fact table.  

Must do interview questions
Each topic has some building block questions which end up being used by a lot of solutions. It is
important that you already know solutions to all these problems so you don't waste time thinking
up the solution to these problems and focus on the question interviewer has given you because
you will be judged on that. I have included some of these questions but if you go through
Interview Bit in detail you would eventually come across/cover most of these questions
­ Arrays/Strings:
­ Determine if a string is a palindrome
­ Merge two sorted arrays
­ Reverse an array in place
­ Find substring
­ All sorting algorithms
­ Binary search in a sorted rotated array
­ Max profit stock problem
­ Matrix multiplication
­ Find all duplicates in an array
­ Print a matrix in a spiral manner
­ Linked List:
­ Reverse a singly linked list
­ Delete/Insert a node in a linked list
­ Detect if there is a cycle in the list and return its starting point
­ Merge two sorted lists
­ Split a list into two lists one has even indexes other has odd indexes
­ Trees:
­ Check if tree is balanced
­ All traversals, recursive and iterative implementations
­ BFS/DFS
­ Construct a BST from a sorted array
­ Check if two trees are mirror image of each other
­ Find max path sum in the tree, negative nodes possible
­ Lowest common ancestor of 2 nodes in a tree
­ Backtracking:
­ Find all permutations or combinations
­ Find all possible subsets
­ N queens problem
­ Convert numbers into words according to letters on an old phone keypad
­ Hashtables
­ Questions where you need to keep track of multiple occurences of same object
­ Questions where you want to have a 2 tuple as a key
­ Dynamic programming:
­ Given you can climb 1,2, or 3 stairs in one step, how many ways of reaching the
top
­ How many ways to go from top left of a grid to bottom right of the grid with some
obstacles in between
­ Implement both bottom up and top down solutions for both of the above


num(1)+num(234)+num(12)+num(34)+num(123)+num(4)
num(234)+num(23)+num(34)=4
num(34)=1
num(23)=2
num(2,3,4)=1
