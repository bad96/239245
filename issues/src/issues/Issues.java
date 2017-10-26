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
public class Issues extends Thread {

    public double start, end, duration;

    public static void main(String[] args) {
        thread1.start();
        thread2.start();
    }

    static Issues thread1 = new Issues() {
        public void run() {
            start = System.nanoTime();
            synchronized (this) {
                for (int i = 0; i <= 10; i++) {
                    Thread.currentThread().getName();
                }
            }
            end = System.nanoTime();
            duration = (end - start) / 1000000000.0;
            System.out.printf("Synchronized Thread = %.8f seconds %n", duration);
        }
    };

    static Issues thread2 = new Issues() {
        public void run() {
            start = System.nanoTime();
            for (int i = 0; i <= 10; i++) {
                Thread.currentThread().getName();
            }
            end = System.nanoTime();
            duration = (end - start) / 1000000000.0;
            System.out.printf("Normal Thread = %.8f seconds %n", duration);
        }
    };
}
