package com.jikexuyuan.ndk.simplendk;


class Add {
    static {
        System.loadLibrary("native-lib");
    }

    int addNum(int num1, int num2) {
        return add(num1, num2);
    }

    public native int add(int num1, int num2);
}
