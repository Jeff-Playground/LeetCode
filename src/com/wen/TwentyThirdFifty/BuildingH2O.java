package com.wen.TwentyThirdFifty;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class BuildingH2O {
    class H2O {
        private Semaphore hSemaphore;
        private Semaphore oSemaphore;
        private AtomicInteger hCount;

        public H2O() {
            hSemaphore = new Semaphore(0);
            oSemaphore = new Semaphore(1);
            hCount=new AtomicInteger(0);
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            hSemaphore.acquire();

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            if(hCount.incrementAndGet()%2==0){
                oSemaphore.release();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            oSemaphore.acquire();

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();

            hSemaphore.release();
            hSemaphore.release();
        }
    }
}
