package ro.fmi.bnk.rest.utils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ro.fmi.bnk.dao.repo.TaskDAO;
import ro.fmi.bnk.models.TaskModel;

@Component
public class TaskSocketSender {



    @Autowired
    TaskSocket taskSocket;

    @Scheduled(fixedDelay = 10000)
    public void sendCounterUpdate() {

    	taskSocket.counterIncrementedCallback();
    }

}