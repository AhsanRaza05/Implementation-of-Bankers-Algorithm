# Implementation of Banker's and Resource Request Algorithm in Java

 Table Of Contents

* <a href = "#Intro" > Introduction </a> 

* <a href = "#Req" > Requirememnts </a> 

* <a href = "#Desc" > Description </a> 

  * <a href = "#BFS_Head" > Banker's Algorithm </a>
  
  * <a href = "#BFS_Head" > Resource-Request Algorithm </a>
  
* <a href = "#Demon" > Demonstration </a> 

  
## Introduction

In this project we have implemented two algorithms related to deadlock.

1. Banker's Algorithm
2. Resource-Request Algorithm

## Requirements: 
Install JDK 11.0.9 or higher version.

## Description: 
  This project is about avoiding the deadlock using Java programming language with the help of well-known concepts in Operating Systems. 
  
  We have taken Banker's algorithm and Resource Request algorithm here to detect deadlocks and allocation of resources to avoid deadlock.

1. ### Banker's Algorithm
  * Banker's algorithm deals with various concepts like safe sequence. When a new process enters the system, it must declare the maximum number of instances of each resource type that it may need. This number may not exceed the total number of resources in the system. When a user requests a set of resources, the system must determine whether the allocation of these resources will leave the system in a safe state. If it will, the resources are allocated; otherwise, the process must wait until some other process releases enough resources. Several data structures must be maintained to implement the banker's algorithm. There data structures encode the state of the resource-allocation system. We need the following data structures, where **n** is the number of processes in the system and **m** is the number of resource types:

- **Available:** A vector of length m indicates the number of available resources of each type. If **Available[j]** equals k, then k instances of resource type Rj are available.
- **Max:** An n × m matrix defines the maximum demand of each process. If Max[i][j] equals k, then process Pi may request at most k instances of resource type Rj.
- **Allocation:** An n × m matrix defines the number of resources of each type currently allocated to each process. If **Allocation[i][j]** equals k, then process Pi is currently allocated k instances of resource type Rj.
- **Need:** An n × m matrix indicates the remaining resource need of each process. If Need[i][j] equals k, then process Pi may need k more instances of resource type Rj to complete its task. Note that **Need[i][j]** equals to **Max[i][j]** − **Allocation[i][j]**

2. ## Resource-Request Algorithm:
This algorithm for determining whether requests can be safely granted. Let **Request** **i** be the request vector for process Pi. If **Request** **i** [j] == k, then process Pi wants k instances of resource type Rj. When a request for resources is made by process Pi, the following actions are taken:

1. If **Request** **i** **≤ Need** **i**, go to step 2. Otherwise, raise an error condition, since the process has exceeded its maximum claim.

2. If **Requesti** ≤ Available, go to step 3. Otherwise, Pi must wait, since the resources are not available.

3. Have the system pretend to have allocated the requested resources to process Pi by modifying the state as follows:

<img src = "Readme Screenshots/Fig_X.png">

   **Available = Available–Request**** i** ;

   **Allocation**** i **** = Allocation ****i**  **+ Request**** i**;

   **Need**** i **** = Need ****i**  **–Request**** i** ;

If the resulting resource-allocation state is safe, the transaction is completed, and process Pi is allocated its resources. However, if the new state is unsafe, then Pi must wait for **Request**** i**, and the old resource-allocation state is restored.

3. ## Demonstration of Program: ![](RackMultipart20220824-1-6h9rdt_html_b3f7ff1742633898.png)

To demonstrate the program, let us consider a system with 5 processes and 3 resource types as shown in Fig X [1]:

![Shape2](RackMultipart20220824-1-6h9rdt_html_cf8866ddf2b5f29d.gif)

_Figure X_

**Step – 01:** Now executing the program and entering the data will result in the following Fig A.

![Shape3](RackMultipart20220824-1-6h9rdt_html_5b1cfccc9c6b7ffd.gif)

_Figure A_

**Note:** In this program we must provide the numbers/digits.This program restricts the unwanted type of data, example: String, Characters etc., except numbers/digits, as shown as Fig A.1.

![Shape4](RackMultipart20220824-1-6h9rdt_html_c6166db7a30ff23f.gif)

_Figure A.1: The error will arise as a result of entering wrong type of data._

**Step – 02:** After clicking on Enter button, the following window will pop-up as shown in Fig B.

![Shape5](RackMultipart20220824-1-6h9rdt_html_17d67bfdb7b84518.gif)

_Figure B_

Now we will enter the data into this table, as shown in Fig B.1.

![Shape6](RackMultipart20220824-1-6h9rdt_html_41bacced27007412.gif)

_Figure B.1_

**Step – 03:** After clicking on check button, the program will generate need matrix as shown in Fig C.

![Shape7](RackMultipart20220824-1-6h9rdt_html_70d9a1b62cf3116d.gif)

_Figure C_

**Step – 04:** After generating the need matrix, the program will apply the Banker's algorithm and check the system state. As we can see in Fig D, the system is in the safe state with the safe sequence.

![Shape9](RackMultipart20220824-1-6h9rdt_html_ad13f77380df341a.gif) ![Shape8](RackMultipart20220824-1-6h9rdt_html_2b94531167c67b8c.gif) ![Shape10](RackMultipart20220824-1-6h9rdt_html_867b98566fea27.gif)

_Figure D_

**Step – 05:** After clicking the "OK" button, the program will ask whether there is a Process Request or not, as shown in Fig E.

![Shape11](RackMultipart20220824-1-6h9rdt_html_ccb33400f1676669.gif)

_Figure E_

**Step – 06:** Suppose now that the process P1 requests one additional instance of resource type A and two instances of resource type C, so _Request__1_ = (1,0,2), As shown as Fig F.

![Shape12](RackMultipart20220824-1-6h9rdt_html_fa5e4c609119993e.gif)

_Figure F_

**Step – 07:** After clicking on the check button, the program first executes the process request algorithm and then generate the need matrix and result, as shown in Fig G and Fig H.

![Shape13](RackMultipart20220824-1-6h9rdt_html_7bd2e07a411a2bc5.gif)

_Figure G_

![Shape14](RackMultipart20220824-1-6h9rdt_html_57cbb6a7aea3ffa0.gif)

_Figure H_

**Note:** The answer is same as of the book. It can be checked from given reference book.

**References:**

[1] The problem is taken from example of the book named "Abraham-Silberschatz-Operating-System-Concepts 9th edition" on page no # 332.
