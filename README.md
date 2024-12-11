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

---

## **Installation Guide**

### **Prerequisites**
Ensure you have the following installed on your system:
- **Java Development Kit (JDK)**: Version 8 or higher. [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Git**: To clone the repository. [Download Git](https://git-scm.com/downloads)
- **Text Editor/IDE**: Recommended options include VS Code, IntelliJ IDEA, or Eclipse.

---

### **Setup Instructions**

#### **Step 1: Clone the Repository**
Use Git to clone the project repository:
```bash
git clone git@github.com:ahmedbahy2026/DSA-Project.git
cd DSA-Project```

#### **Step 2: Recreate Ignored Files and Directories**
Certain files and directories are ignored by .gitignore (e.g., compiled .class files, IDE configurations). Here’s how to restore them:

1. Compiled Files (.class)

```bash
javac -d bin src/main/**/*.java
```

2. IDE-Specific Configurations
- VS Code: 
    - Open the project folder in VS Code.
    - Install the “Java Extension Pack” if prompted.
    - The .vscode/ directory will be generated automatically for debugging and build settings.

- IntelliJ IDEA:
    - Open the project folder in IntelliJ IDEA.
    - The IDE will prompt you to set up the project and create .idea/ configuration files.
