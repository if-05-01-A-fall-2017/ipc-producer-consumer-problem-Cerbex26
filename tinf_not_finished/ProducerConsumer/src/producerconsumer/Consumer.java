/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class Consumer extends Thread{
    
    void consumer() throws InterruptedException
    {
        int item;
        while(true)
        {
            if(ProducerConsumer.count == 0)
            this.wait();
            item = remove();
            ProducerConsumer.count--;
            if(ProducerConsumer.count == ProducerConsumer.maxCapacity - 1)
               ProducerConsumer.p.notify();
            consume(item);
        }        
    }
    
    public void run()
    {
        try {
            consumer();
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int remove()
    {
        return ProducerConsumer.count;
    }

    private void consume(int item) {
        
    }
}
