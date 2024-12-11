# **DSA Project: Memory Allocation and Data Structures**

## **Project Overview**
This project is a simulation of memory allocation and management combined with data structures. It demonstrates how memory is allocated to processes, managed, and reclaimed using key data structures like queues, linked lists, and priority queues.

## **Features**
- **Memory Management**:
  - Allocate memory blocks to processes.
  - Manage a waiting list for processes when memory is unavailable.
  - Reclaim and merge memory blocks after process completion.
- **Data Structures**:
  - Implementation of fundamental data structures:
    - **Linked List**
    - **Queue**
    - **Priority Queue**
- **Random Data Generation**:
  - Generates random process sizes and timeouts.

## **Project Structure**
```plaintext
dsa-project/
├── src/
│   ├── main/
│   │   ├── datastructures/
│   │   │   ├── linkedlist/
│   │   │   │   └── LinkedList.java
│   │   │   ├── queue/
│   │   │   │   └── Queue.java
│   │   │   ├── priorityqueue/
│   │   │   │   └── PriorityQueue.java
│   │   ├── memorymanagement/
│   │   │   ├── MemBlock.java
│   │   │   ├── Process.java
│   │   │   └── MemAlloc.java
│   │   ├── utils/
│   │   │   └── RandomUtils.java
│   │   └── Main.java
├── README.md
└── .gitignore