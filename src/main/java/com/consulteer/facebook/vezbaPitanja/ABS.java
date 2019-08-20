package com.consulteer.facebook.vezbaPitanja;

/**
 * Created by Milos Stambolija on 16.8.2019.
 **/
public abstract class ABS implements Impl{
    public abstract void drive();
    public void ride(){
        System.out.println("Riding...");
    }
}
