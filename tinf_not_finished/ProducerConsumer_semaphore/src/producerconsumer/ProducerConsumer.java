/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Manuel
 */
public class ProducerConsumer {

    public static Semaphore available = new Semaphore(1);
    public static int count = 0;
    final public static int maxCapacity = 2000;
    public static Producer p;
    public static Consumer c;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        p = new Producer();
        c = new Consumer();
        c.start();
        p.start();
        while(p.isAlive())
            System.out.println(count);
    }
}
