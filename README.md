# OOP.Assignment
This project contains a framework that provides an implementation of the Observer design pattern 
for update members who register to the Group admin's UndoableStringBuilder.

Observer pattern:
Observer is a behavioral design pattern. It specifies communication between objects: observable and observers.
An observable is an object which notifies observers about the changes in its state.

Class UndoableStringBuilder:
Our UndoableStringBuilder class, Its class that extends StringBuilder of JAVA via-
https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html

UndoableStringBuilder class override methods of StringBuilder(delete,append,insert etc.).
But also have the Method undo()- this method undo the last change we make in our UndoableStringBuilder.
In this project the undo implementation depends on stack data structure,every change saves in the stack. when we need to undo we pop from the stack the last action.

Class GroupAdmin:
In this project GroupAdmin implements the Interface Sender, and holds the observable- UndoableStringBuilder.Also,The Group admin holds a list of members that register to the Group admin.
- The register method add new ConcreteMember object to the list.
- The register method remove the given member from the list.
- delete,undo,insert and append methods are override from the interface Sender,to change the Group admin UndoableStringBuilder
after every operation we update all our members in current list with our changed UndoableStringBuilder.
- toString method for the tests.

Class ConcreteMember:
In this project ConcreteMember implements the Interface Member.The class holds also UndoableStringBuilder that updates.
- update method performs shallow copy(By request of project managers). 
UndoableStringBuilder of the member saves by reference from GroupAdmin UndoableStringBuilder.
- toString method for the tests.

Class Tests:

- testJvm
This test is preforming JvmUtilities- Utility class for tracking the Java Virtual Machine (JVM) resources allocated by the Operating System.
For this test we using logger messages to print total memory of the object GroupAdmin.
First,checking the objectFootprint- Shallow and deep size footprint of the object/objects
On the test we see that each operation on the groupAdmin make bigger foot print.
Why? because this object have list of members and UndoableStringBuilder, each register magnified the list and each operation for UndoableStringBuilder also change the footprint of our GroupAdmin.
Also printing JVM-info
JVM's process id, total memory allocated at the beginning of the program as well as the available number of cores.


- deleteMember
This test check the unregistered method. Because of the shallow copy the request was just delete the member from the list. 
After the register to all members, and the append to groupAdmin we check with objectTotalSize-
computes the total (deep) size of the given object.
Using toString compare the tostring of each member and the tostring of groupadmin.
For each member of the list the total size must be equal . also after the second append.


- updateMembers_undo
Test for checking  that our undo operation  works on the gropadmin and the members also by objectTotalSize.

- test3
Test for checking other operations on the UndoableStringBuilder of group admin.







