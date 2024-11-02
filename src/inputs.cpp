#include "inputs.h"
#include <iostream>
#include <conio.h>



JNIEXPORT char JNICALL Java_GameInput_getChar(JNIEnv *, jobject){
    char c = '\0';
    if(kbhit()){
        c = getch();
    }
    return tolower(c);
}