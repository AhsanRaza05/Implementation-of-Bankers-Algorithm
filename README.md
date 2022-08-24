# Implementation of Banker's and Resource Request Algorithm in Java

 ## Table Of Contents

* <a href = "#Over" > Overview </a> 

* <a href = "#Req" > Requirements </a> 

* <a href = "#Intro" > Introduction </a> 

  * <a href = "#Banker" > Banker's Algorithm </a>
  
  * <a href = "#Resource" > Resource-Request Algorithm </a>
  
* <a href = "#Demon" > Program Demonstration </a> 

* <a href = "#Refe" > References </a> 
  
## <div id = "Over"> Overview </div>

In this project we have implemented two algorithms related to deadlock.

1. Banker's Algorithm
2. Resource-Request Algorithm

## <div id = "Req"> Requirements </div>
Install JDK 11.0.9 or higher version.

## <div id = "Intro"> Introduction </div>
  This project is about avoiding the deadlock using Java programming language with the help of well-known concepts in Operating Systems. 
  
  We have taken Banker's algorithm and Resource Request algorithm here to detect deadlocks and allocation of resources to avoid deadlock.

1. ### <div id = "Banker"> Banker's Algorithm </div>
  * Banker's algorithm deals with various concepts like safe sequence. When a new process enters the system, it must declare the maximum number of instances of each resource type that it may need. This number may not exceed the total number of resources in the system. When a user requests a set of resources, the system must determine whether the allocation of these resources will leave the system in a safe state. If it will, the resources are allocated; otherwise, the process must wait until some other process releases enough resources. Several data structures must be maintained to implement the banker's algorithm. There data structures encode the state of the resource-allocation system. We need the following data structures, where **n** is the number of processes in the system and **m** is the number of resource types:

- **Available:** A vector of length m indicates the number of available resources of each type. If **Available[j]** equals k, then k instances of resource type Rj are available.
- **Max:** An n × m matrix defines the maximum demand of each process. If Max[i][j] equals k, then process Pi may request at most k instances of resource type Rj.
- **Allocation:** An n × m matrix defines the number of resources of each type currently allocated to each process. If **Allocation[i][j]** equals k, then process Pi is currently allocated k instances of resource type Rj.
- **Need:** An n × m matrix indicates the remaining resource need of each process. If Need[i][j] equals k, then process Pi may need k more instances of resource type Rj to complete its task. Note that **Need[i][j]** equals to **Max[i][j]** − **Allocation[i][j]**

2. ## <div id = "Resource"> Resource-Request Algorithm </div> 
This algorithm for determining whether requests can be safely granted. Let **Request** **i** be the request vector for process Pi. If **Request** **i** [j] == k, then process Pi wants k instances of resource type Rj. When a request for resources is made by process Pi, the following actions are taken:

1. If **Request** **i** **≤ Need** **i**, go to step 2. Otherwise, raise an error condition, since the process has exceeded its maximum claim.

2. If **Requesti** ≤ Available, go to step 3. Otherwise, Pi must wait, since the resources are not available.

3. Have the system pretend to have allocated the requested resources to process Pi by modifying the state as follows:

<p align = "center"> 
 <img src = "Readme%20Screenshots/Fig_X.png" alt = "Fig.X" > 
</p>

<div align = "center">
  <figcaption align = "center">  Fig.X   </figcaption>
 </div>

</br>

If the resulting resource-allocation state is safe, the transaction is completed, and process Pi is allocated its resources. However, if the new state is unsafe, then Pi must wait for **Request**** i**, and the old resource-allocation state is restored.

3. ## <div id = "Demon"> Program Demonstration </div> 

To demonstrate the program, let us consider a system with 5 processes and 3 resource types as shown in Fig Y <a href = "#Ref" > [1]  </a>

<p align = "center"> 
 <img src = "Readme%20Screenshots/Fig_Y.png" alt = "Fig.Y" > 
</p>

<div align = "center">
  <figcaption align = "center">  Fig.Y  </figcaption>
 </div>

</br>

**Step – 01:** Now executing the program and entering the data will result in the following Fig A.

<p align = "center"> 
 <img src = "Readme%20Screenshots/Fig_A.png" alt = "Fig.A"> 
</p>

<div align = "center">
  <figcaption align = "center">  Fig.A  </figcaption>
 </div>

</br>

**Note:** In this program we must provide the numbers/digits.This program restricts the unwanted type of data, example: String, Characters etc., except numbers/digits, as shown as Fig A.1.

<p align = "center"> 
 <img src = "Readme%20Screenshots/Fig_A.1.png" alt = "Fig_A.1" > 
</p>

<div align = "center">
  <figcaption align = "center">   A.1: The error will arise as a result of entering wrong type of data.   </figcaption>
 </div>

</br>

<p align = "center"> 
 <img src = "Readme%20Screenshots/Fig_B.png" alt = "Fig.B" > 
</p>

<div align = "center">
  <figcaption align = "center">  Fig.B  </figcaption>
 </div>

Now we will enter the data into this table, as shown in Fig B.1.

<p align = 'center'>
  <img src = "Readme%20Screenshots/Fig_B.1.png"  alt = "Fig_B.1" >
 </p>
 
 <div align = "center">
  <figcaption align = "center">  Fig-B.1  </figcaption>
 </div>

</br>

**Step – 03:** After clicking on check button, the program will generate need matrix as shown in Fig C.

<p align = 'center'>
  <img src = "Readme%20Screenshots/Fig_C.png"  alt = "Fig_C" >
 </p>
 
 <div align = "center">
  <figcaption align = "center">  Fig-C </figcaption>
 </div>

</br>

**Step – 04:** After generating the need matrix, the program will apply the Banker's algorithm and check the system state. As we can see in Fig D, the system is in the safe state with the safe sequence.

<p align = 'center'>
  <img src = "Readme%20Screenshots/Fig_D.png"  alt = "Fig_D" >
 </p>
 
 <div align = "center">
  <figcaption align = "center">  Fig-D   </figcaption>
 </div>

</br>

**Step – 05:** After clicking the "OK" button, the program will ask whether there is a Process Request or not, as shown in Fig E.

<p align = 'center'>
  <img src = "Readme%20Screenshots/Fig_E.png"  alt = "Fig_E" >
 </p>
 
 <div align = "center">
  <figcaption align = "center">  Fig-E </figcaption>
 </div>
 
 </br>

**Step – 06:** Suppose now that the process P1 requests one additional instance of resource type A and two instances of resource type C, so _Request__1_ = (1,0,2), As shown as Fig F.

<p align = 'center'>
  <img src = "Readme%20Screenshots/Fig_F.png"  alt = "Fig_F" >
 </p>
 
 <div align = "center">
  <figcaption align = "center">  Fig-F  </figcaption>
 </div>

</br>

**Step – 07:** After clicking on the check button, the program first executes the process request algorithm and then generate the need matrix and result, as shown in Fig G and Fig H.

<p align = 'center'>
  <img src = "Readme%20Screenshots/Fig_G.png"  alt = "Fig_G" >
 </p>
 
 <div align = "center">
  <figcaption align = "center">  Fig-G  </figcaption>
 </div>

</br>

<p align = 'center'>
  <img src = "Readme%20Screenshots/Fig_H.png"  alt = "Fig_H" >
 </p>
 
 <div align = "center">
  <figcaption align = "center">  Fig-H  </figcaption>
 </div>

</br>

**Note:** The answer is same as of the book. It can be checked from given reference book.

** <div id = "Refe"> References </div>

<div id = "Ref"> [1] </div> The problem is taken from example of the book named "Abraham-Silberschatz-Operating-System-Concepts 9th edition" on page no # 332.
