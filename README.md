# Java-Find-Highest-Student-in-School

## Problem Description

This Java project models a school results system for multiple classes such as Grade 12A, Grade 12B, and Grade 12C. Each class contains learners, and each learner has a name and an assessment mark. The program is designed to help the school manage learner records efficiently by allowing it to:

- keep track of students and their marks in the correct class,
- add new learners and update existing marks,
- display all learners and their marks for a specific class,
- calculate the average mark for any class,
- identify the learner or learners with the highest mark in a class,
- compare average marks across different classes,
- find the highest-scoring learner or learners across the entire school.

The solution also considers invalid marks, missing records, and situations where multiple learners achieve the same top score. It is built to accommodate changes in the number of classes and learners without requiring major redesign. Sample data is used to demonstrate the full functionality of the program.

## Compile and run

From the project directory, compile the Java source files:

```sh
javac *.java
```

Then run the class that contains the `main` method. For example, if the main class is `gradeClass` or `School`, run it like this:

```sh
java gradeClass
```

or

```sh
java School
```

## Changes

- Added error handling for invalid marks.
- Warns the user when no students are assigned to a class.
- Fixed a logic error when a class has two students.
