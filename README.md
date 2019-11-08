# DsLogger
This repository is devoted for an optional exercice proposed in the Software Design course.

Suppose that you want to have a Logger with just a log(String msg) method, 
but you don't want to have more than just one instance in the project.

Until now this would look like a normal singleton, however the statement 
has a second part.

Now you must suppose that you have two loggers, one for console one for a file,
that must specified in the constructor. You must maintain the singleton that is,
no matter the type, there must be just one Logger. The type is specified by an administrator
before running the application, so it should be totally trasparent to the previous users
the fact that you have now two types of loggers.


About my solution:

First of all, 
 I have considered Logger as an Interface called ILogger (C# Convention, I belive it's very understandable),
 and so, I have implemented both loggers.
 
 Now I was facing the problem about how to manage the creation of such loggers, because they
 need a different amount of resources for their creation, so at some point I would have to decide wheter
 to have some empty constructors or just repeat code, which would cause many problems in case that we have to
 implement even more types of loggers.
 
 I decided to have empty constructors, the best way I think it was possible. Passing a properties object, 
 loaded from a propeties file. And talking about the file...
 
 I have considered that I needed a file to decide which of the two loggers was currently "selected" (false, we are choosing a factory),
 but also one for specifying the parameters of the loggers' cosntructor. I decided to put them as
 properties in the file, so I can reuse the properties object. 
 
 The type of logger, is instanciated from a factory which is decided in the first property of the file.
 
