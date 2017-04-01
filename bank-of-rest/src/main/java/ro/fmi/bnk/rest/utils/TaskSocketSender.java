package ro.fmi.bnk.rest.utils;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class TaskSocketSender {

    private AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    TaskSocket taskSocket;

    @Scheduled(fixedDelay = 10000)
    public void sendCounterUpdate() {
    	taskSocket.counterIncrementedCallback(counter.incrementAndGet());
    }

}