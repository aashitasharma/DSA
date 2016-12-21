# LeetCodeSolutions
Optimized Leet Code solutions in Java

Must do interview questions
Each topic has some building block questions which end up being used by a lot of solutions. It is
important that you already know solutions to all these problems so you don't waste time thinking
up the solution to these problems and focus on the question interviewer has given you because
you will be judged on that. I have included some of these questions but if you go through
Interview Bit in detail you would eventually come across/cover most of these questions

1) Determine if a string is valid based on placement of parenthesis. i.e. "123(13(44))" is valid but ")234(12)(" is not.  During the job fit interview I was asked how to implement a simple web chat system using object oriented techniques. I was then asked how to figure out if a string was a palindrome.

2) You have two linked lists where each list represents some positive number. The ith node in the list represents the ith digit (0-9) of the number. Return a new linked list which represents the sum of the two linked lists.

3) Implement a queue as a stack.

4) Find the kth to last term in a linked list

5) Given a string, return the first NON-repeating character that occurs in the string.
EX: "adzbdcab" returns 'z'.

6) Given a rotated sorted array, find the first occurrence of a certain number X with the lowest possible complexity(both time and space).

	X = 6
	Arr = 8,9,9,1,3,4,4,4,6,6,7,7
	Ans = 8

7) Given a linked like defined so...

	typedef node_t {
	int data;
	node_t* next;
	}Node;

8) check if the linked list is a palindrome without using any extra space and with the lowest possible complexity(both time and space).

9) write code for following API

	BOOL is_palindrome(node *Head);

10) write an algorithm to find the next largest node in a binary tree.

	typedef treenode_t{
	int data;
	treenode_t *parent;
	treenode_t *left;
	treenode_t *right;
	}TreeNode;

	TreeNode* find_next_largest_element(TreeNode *node);

� Arrays/Strings:

	� Determine if a string is a palindrome
	� Merge two sorted arrays
	� Reverse an array in place
	� Find substring
	� All sorting algorithms
	� Binary search in a sorted rotated array
	� Max profit stock problem
	� Matrix multiplication
	� Find all duplicates in an array
	� Print a matrix in a spiral manner

� Linked List:

	� Reverse a singly linked list
	� Delete/Insert a node in a linked list
	� Detect if there is a cycle in the list and return its starting point
	� Merge two sorted lists
	� Split a list into two lists one has even indexes other has odd indexes

� Trees:

	� Check if tree is balanced
	� All traversals, recursive and iterative implementations
	� BFS/DFS
	� Construct a BST from a sorted array
	� Check if two trees are mirror image of each other
	� Find max path sum in the tree, negative nodes possible
	� Lowest common ancestor of 2 nodes in a tree

� Backtracking:

	� Find all permutations or combinations
	� Find all possible subsets
	� N queens problem
	� Convert numbers into words according to letters on an old phone keypad
	� Hashtables
	� Questions where you need to keep track of multiple occurences of same object
	� Questions where you want to have a 2 tuple as a key
	� Dynamic programming:
	� Given you can climb 1,2, or 3 stairs in one step, how many ways of reaching the

top

	� How many ways to go from top left of a grid to bottom right of the grid with some
	obstacles in between
	� Implement both bottom up and top down solutions for both of the above

Database:

	1) programming find the max no from the given set of elements in an array (without using max function)
	2) Find the minimum absolute difference between the set of elements of an array.
	3) find the highest salary per department
	4) Create DDL (table and foreign keys) for several tables in a provided ERD. ERD contains at least one many to many relationship.
	5) Recursively parse a string for a pattern that can be either 1 or 2 characters long.
	6) Perform a merge-sort with SQL only.
	7) Given full authority to "make it work", import a large data set with duplicates into a warehouse while meeting the requirements of a business intelligence designer for query speed.
	8) Query a many to many relationship while not violating the grain of a fact table.

