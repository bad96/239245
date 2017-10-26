/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package issues;

import java.util.concurrent.*;

/**
 *
 * @author Badrul
 */
public class week5 extends Thread {

    public double start, end, duration;
    public int maximum;

    public static void main(String[] args) {
        sequential.start();
        concurrent.start();
    }

    static week5 sequential = new week5() {
        public void run() {
            start = System.nanoTime();
            for (int i = 0; i < 1000000; i++) {
                int x = (int) ((Math.random()) * 1000000);
                maximum = Math.max(maximum, x);
            }
            end = System.nanoTime();
            duration = (end - start) / 1000000000;
            System.out.printf("Sequential Program = %.8f seconds %n", duration);
        }
    };

    static week5 concurrent = new week5() {
        public void run() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                start = System.nanoTime();
                for (int i = 0; i < 1000000; i++) {
                    int x = (int) ((Math.random()) * 1000000);
                    maximum = Math.max(maximum, x);
                }
            });
            executor.shutdown();
            while (!executor.isTerminated()) {
            }

            end = System.nanoTime();
            duration = (end - start) / 1000000000;
            System.out.printf("Concurrent Program = %.8f seconds %n", duration);
        }
    };
}
