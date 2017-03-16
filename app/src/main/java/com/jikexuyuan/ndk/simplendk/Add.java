package com.jikexuyuan.ndk.simplendk;

/**
 * Created by simon on 17/3/16.
 */

public class Add {
    static {
        System.loadLibrary("native-lib");
    }

    public int addNum(int num1, int num2) {
        return add(num1, num2);
    }

    public native int add(int num1, int num2);
}
