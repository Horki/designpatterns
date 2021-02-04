# Design Patterns
Head First: Design Patterns

## [Behavioural patterns](https://en.wikipedia.org/wiki/Behavioral_pattern)

| Name       | Description     | Chapter     | Examples |
| :------------- | :----------: | -----------: | -----------: |
| [Observer](https://en.wikipedia.org/wiki/Observer_pattern) | *The Observer Pattern* defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically. | 2 | [Weather Data](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/Observer/ObserverMain.java), [Swing](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/Observer/SwingObserverMain.java) |
| [Strategy](https://en.wikipedia.org/wiki/Strategy_pattern) | *The Strategy Pattern* defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets algorithm vary independently from client to use it. | 1 | [Ducks](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/Strategy/Main.java) |


## [Creational patterns](https://en.wikipedia.org/wiki/Creational_pattern)

| Name       | Description     | Chapter     | Examples |
| :------------- | :----------: | -----------: | -----------: |
| [Abstract factory](https://en.wikipedia.org/wiki/Abstract_factory_pattern) | *The Abstract Factory Pattern* provides an interface for creating families of related or dependent class without specifying their concrete classes. | 4 | [Factory/Product Pizza](https://github.com/Horki/designpatterns/blob/main/src/Creational/AbstractFactory/AbstractFactoryMain.java) |
| [Factory method](https://en.wikipedia.org/wiki/Factory_method_pattern) | *The Factory Method Pattern* defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses. | 4 | [Creator/Product Pizza](https://github.com/Horki/designpatterns/blob/main/src/Creational/FactoryMethod/FactoryMethodMain.java) |
| [Singleton](https://en.wikipedia.org/wiki/Singleton_pattern) | *The Singleton Pattern* ensures a class has only one instance, and provides global point of access to it. | 5 | [Simple Singleton](https://github.com/Horki/designpatterns/blob/main/src/Creational/Singleton/SingletonMain.java), [Multi-threaded Singleton](https://github.com/Horki/designpatterns/blob/main/src/Creational/Singleton/Threads/SingletonThreadsFailMain.java) |


## [Structural patterns](https://en.wikipedia.org/wiki/Structural_pattern)

| Name       | Description     | Chapter     | Examples |
| :------------- | :----------: | -----------: | -----------: |
| [Decorator](https://en.wikipedia.org/wiki/Decorator_pattern) | *The Decorator Pattern* attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality. | 3 | [Beverages](https://github.com/Horki/designpatterns/blob/main/src/Structural/Decorator/DecoratorMain.java), [I/O Decorators](https://github.com/Horki/designpatterns/blob/main/src/Structural/Decorator/DecoratorIOMain.java) |
