/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package issues;

/**
 *
 * @author Badrul
 */
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Week5_6 {

    public static void main(String[] args) throws InterruptedException {
        CountThread countT = new CountThread();
        Thread t1 = new Thread(countT, "t1");
        Thread t2 = new Thread(countT, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Thread 1 = " + countT.countT1);
        System.out.println("Thread 2 = " + countT.countT2);
        System.out.println("Total = " + (countT.countT1 + countT.countT2));

    }

    static class CountThread implements Runnable {

        int countTotal, countT1, countT2;
        AtomicInteger count = new AtomicInteger();
        AtomicInteger t1Count = new AtomicInteger();
        AtomicInteger t2Count = new AtomicInteger();

        public void run() {
            do {
                int i = (int) ((Math.random() * 3000) + 500);
                countTotal = count.incrementAndGet();
                if ("t1".equals(Thread.currentThread().getName())) {
                    countT1 = t1Count.incrementAndGet();
                }
                if ("t2".equals(Thread.currentThread().getName())) {
                    countT2 = t2Count.incrementAndGet();
                }
            } while (countTotal < 1000);
        }
    }
}
