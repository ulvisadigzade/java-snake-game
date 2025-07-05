# JavaSnakeGame
Simple Console Snake game using Java/C++

### Launching game
***
Compile Java file and generate .h file
```shell
javac -h . "GameInput.java"
```
Compile C++ file
```shell
g++ -c -I"C:\Program Files\Java\jdk-22\include" -I"C:\Program Files\Java\jdk-22\include\win32" inputs.cpp -o inputs.o
```
Create dll file
```shell
g++ -shared -o inputs.dll inputs.o
```
Compile Main.java
```shell
javac Main.java
```
Run Main class
```shell
java Main
```


