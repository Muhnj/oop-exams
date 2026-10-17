# OOP Exams — Java Solutions

Java solutions to Questions 3, 4 and 5 of the Object-Oriented Programming (1301 ST) examination, Victoria University Kampala.

**Repository:** https://github.com/Muhnj/oop-exams

| Folder | Topic | Main concepts |
|--------|-------|---------------|
| [`q3`](q3) | Abstract classes | abstract methods, concrete subclasses, `abstract` vs `final` |
| [`q4`](q4) | Interfaces | constants, static, abstract and default methods |
| [`q5`](q5) | Prime High School Student Records | encapsulation, `ArrayList`, exception handling, user input |

## Requirements

- Java JDK 8 or later

```bash
git clone https://github.com/Muhnj/oop-exams.git
cd oop-exams
```

---

## Question 3 — Abstract Classes

Fixes and explains code that breaks the rules of abstract classes, then defines an abstract class and a concrete subclass.

| Folder | What it shows |
|--------|---------------|
| `q3/original` | The given code, which fails with 2 errors: an abstract method with a body, and a subclass that does not implement `close()` |
| `q3/fixed` | The corrected code, plus two valid ways to create an object for `Account acc` |
| `q3/final_abstract` | Why `final abstract` is rejected (*illegal combination of modifiers*) |
| `q3/instantiate` | Why `new Account()` is rejected (*Account is abstract; cannot be instantiated*) |
| `q3/patient` | Abstract class `Patient` with `calculateBill()` and `getWard()`, and a concrete subclass `InPatient` |

```bash
cd q3/fixed && javac AccountTest.java && java AccountTest
cd ../patient && javac *.java && java PatientTest
```

Output of `PatientTest`:

```
P001 Nakato Sarah, General Ward, bill UGX 270000.0
```

---

## Question 4 — Interfaces X and Y

- **X:** constant `W = 5`, static method `m()` that prints "I am from X", and abstract method `a(String)`
- **Y:** constant `W = 10`, static method `m()` that prints "I am from Y", and default method `b(int)` that returns the square
- **A:** implements both interfaces and calls every method and constant in `main()`

```bash
cd q4 && javac *.java && java A
```

```
I am from X
I am from Y
W in X = 5
W in Y = 10
Method a() received: Hello
Square of 7 = 49
```

Static interface methods are not inherited, so they are called as `X.m()` and `Y.m()`. The two `W` constants are read as `X.W` and `Y.W` to avoid ambiguity.

---

## Question 5 — Prime High School Student Records

A console program that replaces the paper registration and results books. Each required function is a separate method called from `main()`.

| Method | Function |
|--------|----------|
| `login()` | Teacher login (3 attempts) |
| `registerStudents()` | Registers as many students as the teacher chooses: name, reg number, subject, class |
| `recordMarks()` | Records a mark (0–100) for each student |
| `viewStudents()` | Shows all students and their marks |

```bash
cd q5 && javac PrimeHighSchool.java && java PrimeHighSchool
```

**Login:** `teacher` / `prime123`

```
Reg No          Name                 Subject         Class    Mark
-----------------------------------------------------------------
PHS/001         Nakato Sarah         Mathematics     S.3      78.0
PHS/002         Okello Peter         Physics         S.4      64.0
```

Invalid marks and duplicate registration numbers are rejected. Records are held in memory while the program runs.

---

## Author

**MUNIRU MUJUZI— Faculty of Science & Technology, Victoria University Kampala# oop-exams
