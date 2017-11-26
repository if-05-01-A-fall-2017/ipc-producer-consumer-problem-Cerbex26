/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class Producer extends Thread{
    
    public void run()
    {
        try {
            producer();
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void producer() throws InterruptedException
    {
        int item;
        while (true) {
                        ProducerConsumer.available.acquire();
            item = produce();
            insert_item(item);
            ProducerConsumer.count++;
            if (ProducerConsumer.count == ProducerConsumer.maxCapacity) {
                synchronized(this){this.wait(); };
            }
            if (ProducerConsumer.count == 1) {
                synchronized(ProducerConsumer.c){ProducerConsumer.c.notify();};
            }
            ProducerConsumer.available.release();
        }
    }

    private int produce() {
        return ProducerConsumer.count;
    }

    private void insert_item(int item) {
        
    }
}