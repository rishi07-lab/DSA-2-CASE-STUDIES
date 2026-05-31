# SkillBridge – Range Queries on Student Assessment Scores Using Segment Tree

## Overview

This project demonstrates how Segment Trees efficiently process range queries and score updates for student assessment records in the SkillBridge online skill development and certification platform.

## Scenario

SkillBridge continuously tracks student assessment scores and learning progress across multiple courses and certification programs.

To support real-time analytics and interval-based performance evaluation, assessment scores are stored using a Segment Tree structure that enables efficient range queries and updates.

## Key Concepts

* Segment Tree
* Range Queries
* Point Updates
* Recursive Tree Construction
* Hierarchical Data Storage
* Range Sum Queries
* Time Complexity Optimization
* Learning Analytics

## Why Segment Tree?

### Without Segment Tree

* Range queries require scanning the entire dataset.
* Query processing takes **O(n)** time.

### With Segment Tree

* Fast interval query processing.
* Efficient score updates.
* Query and update operations execute in **O(log n)** time.

## Technologies Used

* Java
* Segment Tree Data Structure
* Recursive Algorithms
* Range Query Processing

## Features

* Student assessment score storage
* Segment Tree construction
* Range sum query processing
* Point update operations
* Efficient interval-based analytics
* Performance optimization for large datasets

## Sample Output

Range Sum = 250

Updated Range Sum = 255

## Complexity Analysis

| Operation                 | Complexity |
| ------------------------- | ---------- |
| Segment Tree Construction | O(n)       |
| Range Query               | O(log n)   |
| Point Update              | O(log n)   |
| Space Complexity          | O(n)       |

## Conclusion

The Segment Tree successfully enabled efficient storage and processing of student assessment scores. By reducing query and update operations from linear complexity to logarithmic complexity, the implementation provides scalable real-time analytics and performance monitoring capabilities for the SkillBridge platform.
