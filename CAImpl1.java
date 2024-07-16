package it.unipr.ingsw.concurrency.esame062224;

import it.unipr.ingsw.concurrency.pool.Callable;

public class CAImpl1 implements CA {
    @Override
    public String ma(Callable<String>[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        Thread[] pool = new Thread[a.length];

        for (int i = 0; i < a.length; i++) {
            final int index = i;
            pool[index] = new Thread(() -> {
                try {
                    a[index].call();
                } catch (Exception e) {
                    // handle exception if needed
                }
            });
        }

        for (Thread thread : pool) {
            thread.start();
        }

        for (Thread thread : pool) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                return null;
            }
        }

        return null;
    }
}
