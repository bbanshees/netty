#include "jni.h"
#include "com_spike_netty_JavaNative.h"
#include <stdio.h>
JNIEXPORT void JNICALL Java_com_spike_netty_JavaNative_sayHello(JNIEnv *env,jobject obj){
    printf("Hello World!\n");
    return;

}