//
// Created by simon on 17/3/16.
//
#include <jni.h>

JNIEXPORT jint JNICALL Java_com_jikexuyuan_ndk_simplendk_Add_add
        (JNIEnv *env, jobject jobject1, jint num1, jint num2) {
    return num1 + num2;
}