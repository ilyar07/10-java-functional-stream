package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>>{

    private final Map<String, List<T>> mailbox = new HashMap<>(){
        @Override
        public List<T> get(Object key){
            return super.getOrDefault(key, Collections.emptyList());
        }
    };

    @Override
    public void accept(Sendable<T> item){
        String key = item.getTo();
        T content = item.getContent();

        mailbox.computeIfAbsent(key, k -> new ArrayList<>()).add(content);
    }

    public Map<String, List<T>> getMailBox(){
        return mailbox;
    }
}
