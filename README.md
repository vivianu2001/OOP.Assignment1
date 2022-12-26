# OOP.Assignment
This project contains a framework that provides an implementation of the Observer design pattern 
for update members who register to the Group admin's UndoableStringBuilder.

#About observer pattern
Observer is a behavioral design pattern. It specifies communication between objects: observable and observers.
An observable is an object which notifies observers about the changes in its state.

##About UndoableStringBuilder
Our UndoableStringBuilder class, Is class that extends StringBuilder of JAVA via-
https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html

UndoableStringBuilder class override methods of StringBuilder(delete,append,insert etc.).
But also have the Method undo()- this method undo the last change we make in our UndoableStringBuilder.
In this project the undo implementation depends on stack data structure,every change saves in the stack. when we need to undo we pop from the stack the last action.

In this project GroupAdmin implements the Interface Sender, and holds the observable- UndoableStringBuilde.Also,The Group admin holds a list of members that register to the Group admin.

The members are objects of ConcreteMember that implements Member interface. The members are the observers.
Each change In UndoableStringBuilder of the Group admin needs to make update on the members.
Because this is a shallow copy each UndoableStringBuilder of member point to UndoableStringBuilder of the admin.

Each member register to the admin by adding to the list, every unregister remove the member from the list.

The GroupAdmin class can make changes in his UndoableStringBuilder with the methods- append, insert,delete and undo. after each method we need to call updateAll() to update each members on the list with the newst changes.


### 






