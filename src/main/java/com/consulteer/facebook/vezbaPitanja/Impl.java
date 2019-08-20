package com.consulteer.facebook.vezbaPitanja;

/**
 * Created by Milos Stambolija on 16.8.2019.
 **/
public interface Impl {
    default void speak(){
        System.out.println("Speaking...");
    }
    int calc();
}
