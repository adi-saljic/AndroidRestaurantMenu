# Final Project - Mobile Application Development  
## Application Using a Web API

---

> Faculty of Natural Sciences and Mathematics  
> Mobile Application Development  
> Nadir Dulić and Adi Šaljić

---

## Project Description
The project involves creating an Android application that presents data obtained through a Web API.

---

## Web API
A Web API is used to retrieve resources from a source. A request is sent, and the response returns data in a certain format.

---

## Android
Android is an operating system for mobile devices such as smartphones and tablets. It is based on the Linux kernel and other open-source software. In addition to phones and tablets, Android is also available on smart TVs, cars, and watches. Since 2011, Android has been the best-selling mobile operating system for phones.

---

## Android Studio
Android Studio is an integrated development environment (IDE) for the Android operating system. It was created for Android development and is based on IntelliJ IDEA software. It can be downloaded on Windows, macOS, and Linux operating systems and is used to develop Android applications. The first stable version was released in 2014, and in 2019, Kotlin replaced Java as the preferred programming language for Android development, although Java is still supported.

---

## Gradle
Gradle is the build system used in Android Studio. It runs whenever changes are made, whether in the code or when resources are added, and rebuilds the application. Whether using a physical device or an emulator, Gradle manages its execution.

---

## Android Jetpack
Android Jetpack is a set of libraries that helps developers follow best practices, reduce boilerplate code, and write cleaner code.

---

## Kotlin
Kotlin is a statically-typed programming language primarily used for writing Android applications. It is designed to work seamlessly with Java. While its main focus is on the JVM, it can also be compiled into JavaScript.

### JVM
The Java Virtual Machine (JVM) allows computers to run Java programs and other programs compiled into Java bytecode.

---

## Room Database
Room is a Database Object Mapping library that allows access to databases within Android applications. It provides APIs to query and check databases, enabling full access to SQLite while maintaining security.

Room consists of three main components:
- **Database**: Annotates a class as the database. It should be an abstract class that defines the list of entities and DAOs.
- **Entity**: Annotates a class as a row in the database (i.e., a table). A table is created for each entity to store data.
- **DAO**: Annotates a class or interface as a Data Access Object, defining the methods used to access the database.

---

## Retrofit Library
Retrofit is a REST client for Java and Android. It is a simple library used for network transactions. Using Retrofit, we can easily retrieve JSON responses from web services or APIs. It eliminates the need to parse JSON responses manually, as they are automatically parsed. Additionally, it offers better performance than other libraries.

---

## Glide
Glide is a fast and efficient Android library used for smooth scrolling. It has a simple API and provides functionalities for fetching, decoding, and displaying images, videos, and GIFs. Its primary purpose is to render images as quickly as possible while also handling tasks like resizing and image fetching.

---

## Lifecycle
In Android development, fragments and activities are the primary components of the user interface. As users navigate through the app, these components transition through various states in the Android lifecycle. The lifecycle determines how and when components are initialized, displayed, and destroyed.

### Activity States
An activity can have several states:
- **Initialized**
- **Created**
- **Started**
- **Resumed**
- **Destroyed**

Activities transition through these states based on user interaction and the system's resource management.

---

## Activity
An Activity in Android is a screen that contains a user interface. Each activity has a set of methods that are called based on its state.

### Key Activity Methods:
- **onCreate**: Called when the activity is first created. Used for initialization and setting up the user interface.
- **onStart**: Called after `onCreate` or `onRestart`. Used for drawing elements and starting animations.
- **onResume**: Called when the activity becomes active and interactive.
- **onPause**: Called when the activity is in the background. Used for stopping unnecessary processes to save resources.
- **onStop**: Called when the activity is no longer visible to the user.
- **onRestart**: Called after `onStop` when the activity is brought back to the foreground.
- **onDestroy**: Called when the activity is finishing or when the system is reclaiming resources.

---

## Fragment
A Fragment is a reusable portion of the user interface that can be used multiple times within an activity. Fragments have their own lifecycle and can handle inputs. They cannot exist independently and must be hosted by an activity or another fragment. Fragments offer modularity and flexibility for UI design.

---

## Layout
Layouts are files that define the structure of the user interface in an application. Each activity and fragment has its own layout. Layout files contain elements that define how the screen will appear.

### Layout Types
Commonly used layout types in Android Studio:
- **Constraint Layout**
- **Linear Layout**
- **Frame Layout**

In our application, we primarily used **Linear Layout** and **Constraint Layout**.

### Linear Layout
Linear Layout arranges elements either horizontally or vertically. Elements are placed one after another, and vertical lists have one element per row, while horizontal lists have one column per row.

### Constraint Layout
ConstraintLayout is a flexible layout that allows more complex UI designs using "constraints" to define the relationships between elements and their parent view. It is easier to use because it can be designed via drag-and-drop in the Layout Editor.

---

## View
Views are the elements that make up the user interface. Each view is an object that the user can interact with, such as a button, text, or image.

### Types of Views:
- **TextView**
- **Button**
- **ImageView**
- **RecyclerView**

---

## XML Layout
XML is used to define the layout of the user interface. It allows quick design of UIs similar to writing HTML code. Each layout file must have a root element, and other elements are added inside it. XML can be written directly or through the Layout Editor in Android Studio.

---

## Accessing Elements

### FindViewById()
`findViewById()` is used to access views defined in XML layouts by their ID.

### Data Binding
Data Binding is a library that allows quicker, easier, and more efficient access to views. With Data Binding enabled, all elements within an activity or fragment are automatically available, reducing the need to use `findViewById()`.

---

## Navigation
Navigation refers to the process of transitioning from one screen to another, whether from one activity or fragment to another.

### Key Navigation Components:
- **NavGraph**: A navigation graph that defines the destinations (fragments or activities) and the relationships between them.
- **NavHostFragment**: Responsible for swapping between destinations as needed.
- **NavController**: Controls the navigation between destinations within the NavHost.

---

## SafeArgs
SafeArgs is a plugin that allows safely passing data between destinations. It ensures that data is passed securely and correctly by generating code for safe argument handling.

---

## Intent
An Intent is an operation that has yet to be performed. There are two types of intents:
- **Explicit Intent**: Specifies the component to be launched.
- **Implicit Intent**: Offers a choice of components to launch based on the action requested.

Intents can also be used to send predefined messages between components.

---

## RecyclerView
RecyclerView is a more efficient way to display large sets of data. It uses a recycling mechanism to avoid excessive resource consumption and ensures fast data retrieval. For each item in the list, a layout is created to display the element's view.

---

## App Bar
The App Bar provides a space where users can see information about the current fragment or activity and interact with it. It can contain navigation elements, buttons, search functionality, and more.

---


