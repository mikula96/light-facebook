package com.consulteer.facebook.vezbaPitanja;

import com.consulteer.facebook.customAnnotation.IsValid;

/**
 * Created by Milos Stambolija on 16.8.2019.
 **/
public class Extend extends ABS {

    @Override
    public void drive() {
        System.out.println("Driving...");
    }

    @Override
    public void speak() {

    }

    @Override
    public int calc() {
        return 0;
    }
}
