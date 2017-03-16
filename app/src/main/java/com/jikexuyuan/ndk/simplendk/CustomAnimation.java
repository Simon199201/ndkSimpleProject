package com.jikexuyuan.ndk.simplendk;

import android.content.Context;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;


class CustomAnimation extends Animation {
    private static final String TAG = "CustomAnimation";

    @Override
    public void setInterpolator(Context context, int resID) {
        super.setInterpolator(context, resID);
    }

    CustomAnimation() {
        super();
        setDuration(500);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Log.i(TAG, "applyTransformation: " + interpolatedTime);
        t.getMatrix().setTranslate((float) Math.sin(interpolatedTime * 10) * 50, 0);
        super.applyTransformation(interpolatedTime, t);
    }
}
