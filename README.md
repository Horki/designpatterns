# Design Patterns
Head First: Design Patterns

## [Behavioural patterns](https://en.wikipedia.org/wiki/Behavioral_pattern)

| Name       | Description     | Chapter     | Examples |
| :------------- | :----------: | -----------: | -----------: |
| [Command](https://en.wikipedia.org/wiki/Command_pattern) | *The Command Pattern* encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue or log requests, and supports undoable operations. | 6 | [Simple Remote Control](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/Command/Simple/CommandSimpleMain.java), [Remote Control](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/Command/CommandMain.java), [Macro Command](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/Command/MacroCommand/MacroCommandMain.java) |
| [Observer](https://en.wikipedia.org/wiki/Observer_pattern) | *The Observer Pattern* defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically. | 2 | [Weather Data](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/Observer/ObserverMain.java), [Weather Data, using API](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/Observer/ObserverAPIMain.java), [Swing](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/Observer/SwingObserverMain.java) |
| [Strategy](https://en.wikipedia.org/wiki/Strategy_pattern) | *The Strategy Pattern* defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets algorithm vary independently from client to use it. | 1 | [Ducks](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/Strategy/Main.java) |
| [Template Method](https://en.wikipedia.org/wiki/Template_method_pattern) | *The Template Method Pattern* defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of algorithm without changing the algorithm's structure. | 8 | [Coffee/Tea w/ hook](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/TemplateMethod/TemplateMethodMain.java), [Comparable](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/TemplateMethod/DuckSortMain.java), [Swing Frame](https://github.com/Horki/designpatterns/blob/main/src/Behavioural/TemplateMethod/TemplateFrameMain.java) |


## [Creational patterns](https://en.wikipedia.org/wiki/Creational_pattern)

| Name       | Description     | Chapter     | Examples |
| :------------- | :----------: | -----------: | -----------: |
| [Abstract factory](https://en.wikipedia.org/wiki/Abstract_factory_pattern) | *The Abstract Factory Pattern* provides an interface for creating families of related or dependent class without specifying their concrete classes. | 4 | [Factory/Product Pizza](https://github.com/Horki/designpatterns/blob/main/src/Creational/AbstractFactory/AbstractFactoryMain.java) |
| [Factory method](https://en.wikipedia.org/wiki/Factory_method_pattern) | *The Factory Method Pattern* defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses. | 4 | [Creator/Product Pizza](https://github.com/Horki/designpatterns/blob/main/src/Creational/FactoryMethod/FactoryMethodMain.java) |
| [Singleton](https://en.wikipedia.org/wiki/Singleton_pattern) | *The Singleton Pattern* ensures a class has only one instance, and provides global point of access to it. | 5 | [Simple Singleton](https://github.com/Horki/designpatterns/blob/main/src/Creational/Singleton/SingletonMain.java), [Multi-threaded Singleton](https://github.com/Horki/designpatterns/blob/main/src/Creational/Singleton/Threads/SingletonThreadsFailMain.java) |


## [Structural patterns](https://en.wikipedia.org/wiki/Structural_pattern)

| Name       | Description     | Chapter     | Examples |
| :------------- | :----------: | -----------: | -----------: |
| [Adapter](https://en.wikipedia.org/wiki/Adapter_pattern) | *The Adapter Pattern* converts the interface of a class into another interface the clients except. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces. | 7 | [Duck -> Turkey -> Duck](https://github.com/Horki/designpatterns/blob/main/src/Structural/Adapter/DucksExample/AdapterMain.java), [Iter -> Enum -> Iter](https://github.com/Horki/designpatterns/blob/main/src/Structural/Adapter/IteratorExample/AdapterMain.java) |
| [Decorator](https://en.wikipedia.org/wiki/Decorator_pattern) | *The Decorator Pattern* attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality. | 3 | [Beverages](https://github.com/Horki/designpatterns/blob/main/src/Structural/Decorator/DecoratorMain.java), [I/O Decorators](https://github.com/Horki/designpatterns/blob/main/src/Structural/Decorator/DecoratorIOMain.java) |
| [Façade](https://en.wikipedia.org/wiki/Facade_pattern) | *The Façade Pattern* provides a unified interface to a set of interfaces in subsystem. Facade (Façade) defines a higher-level interface that makes the subsystem easier to use. | 7 | [Complex Home Theatre](https://github.com/Horki/designpatterns/blob/main/src/Structural/Facade/FacadeMain.java) |
