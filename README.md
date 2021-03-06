# Design Patterns

Head First: Design Patterns

## [Behavioural patterns](https://en.wikipedia.org/wiki/Behavioral_pattern)

| Name       | Description     | Chapter     | Examples |
| :------------- | :----------: | -----------: | -----------: |
| [Command](https://en.wikipedia.org/wiki/Command_pattern) | *The Command Pattern* encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue or log requests, and supports undoable operations. | 6 | [Simple Remote Control](src/Behavioural/Command/Simple/CommandSimpleMain.java), [Remote Control](src/Behavioural/Command/CommandMain.java), [Macro Command](src/Behavioural/Command/MacroCommand/MacroCommandMain.java) |
| [Iterator](https://en.wikipedia.org/wiki/Iterator_pattern) | *The Iterator Pattern* provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation. | 9 | [Waitress](src/Behavioural/Iterator/IteratorMain.java) |
| [Null Object](https://en.wikipedia.org/wiki/Null_object_pattern) | A *Null object* is useful when you don't have meaningful object to return, and yet you want to remove responsibility for handling *null* from client. | mention 9 | [Null Iterator](src/Structural/Composite/NullIterator.java) |
| [Observer](https://en.wikipedia.org/wiki/Observer_pattern) | *The Observer Pattern* defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically. | 2 | [Weather Data](src/Behavioural/Observer/ObserverMain.java), [Weather Data, using API](src/Behavioural/Observer/ObserverAPIMain.java), [Swing](src/Behavioural/Observer/SwingObserverMain.java) |
| [State](https://en.wikipedia.org/wiki/State_pattern) | *The State Pattern* allows an object to alter its behaviour when its internal state changes. The object will appear to change its class. | 10 | [Gumball Machine](src/Behavioural/State/StateMain.java) |
| [Strategy](https://en.wikipedia.org/wiki/Strategy_pattern) | *The Strategy Pattern* defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets algorithm vary independently from client to use it. | 1 | [Ducks](src/Behavioural/Strategy/Main.java) |
| [Template Method](https://en.wikipedia.org/wiki/Template_method_pattern) | *The Template Method Pattern* defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of algorithm without changing the algorithm's structure. | 8 | [Coffee/Tea w/ hook](src/Behavioural/TemplateMethod/TemplateMethodMain.java), [Comparable](src/Behavioural/TemplateMethod/DuckSortMain.java), [Swing Frame](src/Behavioural/TemplateMethod/TemplateFrameMain.java) |


## [Creational patterns](https://en.wikipedia.org/wiki/Creational_pattern)

| Name       | Description     | Chapter     | Examples |
| :------------- | :----------: | -----------: | -----------: |
| [Abstract factory](https://en.wikipedia.org/wiki/Abstract_factory_pattern) | *The Abstract Factory Pattern* provides an interface for creating families of related or dependent class without specifying their concrete classes. | 4 | [Factory/Product Pizza](src/Creational/AbstractFactory/AbstractFactoryMain.java) |
| [Composite](https://en.wikipedia.org/wiki/Composite_pattern) | *The Composite Pattern* allows you to composite objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of object uniformly. | 9 | [Composite Menu](src/Structural/Composite/CompositeMain.java) |
| [Factory method](https://en.wikipedia.org/wiki/Factory_method_pattern) | *The Factory Method Pattern* defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses. | 4 | [Creator/Product Pizza](src/Creational/FactoryMethod/FactoryMethodMain.java) |
| [Singleton](https://en.wikipedia.org/wiki/Singleton_pattern) | *The Singleton Pattern* ensures a class has only one instance, and provides global point of access to it. | 5 | [Simple Singleton](src/Creational/Singleton/SingletonMain.java), [Multi-threaded Singleton](src/Creational/Singleton/Threads/SingletonThreadsFailMain.java) |


## [Structural patterns](https://en.wikipedia.org/wiki/Structural_pattern)

| Name       | Description     | Chapter     | Examples |
| :------------- | :----------: | -----------: | -----------: |
| [Adapter](https://en.wikipedia.org/wiki/Adapter_pattern) | *The Adapter Pattern* converts the interface of a class into another interface the clients except. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces. | 7 | [Duck -> Turkey -> Duck](src/Structural/Adapter/DucksExample/AdapterMain.java), [Iter -> Enum -> Iter](src/Structural/Adapter/IteratorExample/AdapterMain.java) |
| [Decorator](https://en.wikipedia.org/wiki/Decorator_pattern) | *The Decorator Pattern* attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality. | 3 | [Beverages](src/Structural/Decorator/DecoratorMain.java), [I/O Decorators](src/Structural/Decorator/DecoratorIOMain.java) |
| [Façade](https://en.wikipedia.org/wiki/Facade_pattern) | *The Façade Pattern* provides a unified interface to a set of interfaces in subsystem. Facade (Façade) defines a higher-level interface that makes the subsystem easier to use. | 7 | [Complex Home Theatre](src/Structural/Facade/FacadeMain.java) |
| [Proxy](https://en.wikipedia.org/wiki/Proxy_pattern) | *The Proxy Pattern* provides a surrogate or placeholder for another object to control access to it. | 11 | Remote Proxy Gumball [server](src/Structural/Proxy/RemoteProxyGumball/GumballProxyServerMain.java) [client](src/Structural/Proxy/RemoteProxyGumball/GumballProxyClientMain.java), Virtual Proxy [CD](src/Structural/Proxy/VirtualProxyCD/VirtualProxyMain.java), Protection Proxy [Person](src/Structural/Proxy/ProtectionProxy/ProtectionProxyMain.java) |

