# 🔐 JavaFX Strong Password Generator

A simple yet powerful GUI application built using **JavaFX** that helps users generate strong and memorable passwords based on selected phrases and special symbols.

The app displays the **password length**, estimates **password strength** against potential hackers, and allows the user to save the password either **on paper** or in a **text file**.

---

## 🧰 Features

- ✅ Clean and intuitive JavaFX GUI
- ✅ User selects a **phrase** from a predefined list
- ✅ User selects a **special symbol** from another list
- ✅ Program generates a password by combining the selections with randomization
- ✅ Displays:
  1. The generated password
  2. Password length
  3. Estimated strength (weak / moderate / strong / very strong)
- ✅ Option to save password:
  - To a `.txt` file
  - Or copy it manually (e.g., write it down on paper)

---

## 🎬 Demo

![Password Generator Demo](files/PassWrdDemo.gif)

---

## 🚀 Getting Started

### 1. Prerequisites

Make sure you have the following installed:

- Java 11 or higher
- JavaFX SDK
- An IDE like IntelliJ IDEA, Eclipse, or VS Code with JavaFX support

### 2. Clone or Download the Project

```bash
git clone https://github.com/yourusername/strong-password-generator-javafx.git
cd strong-password-generator-javafx

### 3. Open and Configure the Project

Open the project in your IDE.

Link your JavaFX SDK to the project.

Ensure VM options are set correctly when running:
--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml

### 4. Run the App

Run Main.java from your IDE

Or from terminal:

javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d out src/*.java
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp out Main
