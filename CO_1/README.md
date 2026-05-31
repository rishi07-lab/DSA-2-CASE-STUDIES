# SkillBridge – Course Enrollment Database Indexing using AVL Tree

## Overview

This project demonstrates how AVL Trees provide efficient storage, retrieval, insertion, and deletion of course enrollment records in the SkillBridge online learning platform.

## Scenario

The SkillBridge platform manages thousands of courses, certifications, and student enrollments.

Each course is identified using a unique Course ID.

To ensure fast access and updates, course records are stored using a self-balancing AVL Tree.

## Key Concepts

* Binary Search Tree (BST)
* AVL Tree
* Height Maintenance
* Balance Factor Calculation
* LL Rotation
* RR Rotation
* LR Rotation
* RL Rotation
* Inorder Traversal
* Logarithmic Search Operations

## Why AVL Tree?

### Without Balancing

* Tree may become skewed
* Search, insertion, and deletion can degrade to **O(n)**

### With AVL Tree

* Automatic balancing through rotations
* Search, insertion, and deletion remain **O(log n)**

## Technologies Used

* Java
* AVL Tree Data Structure
* BST Operations
* Recursive Tree Traversals

## Features

* Course record insertion
* Course record deletion
* Course record search
* AVL balancing using rotations
* Sorted course display using inorder traversal

## Sample Output

In-order Traversal:

20 30 40 50 70

Search Result:

Record Found

After Deletion:

20 40 50 70

## Complexity Analysis

| Operation         | Complexity |
| ----------------- | ---------- |
| Search            | O(log n)   |
| Insertion         | O(log n)   |
| Deletion          | O(log n)   |
| Inorder Traversal | O(n)       |

## Conclusion

The AVL Tree successfully maintained a balanced hierarchical structure for course enrollment records. Self-balancing rotations ensured consistent O(log n) performance for search, insertion, and deletion operations, making the solution suitable for large-scale course catalog management in the SkillBridge platform.
