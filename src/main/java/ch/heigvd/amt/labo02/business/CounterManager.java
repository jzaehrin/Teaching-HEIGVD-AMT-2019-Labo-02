package ch.heigvd.amt.labo02.business;

import javax.ejb.Stateless;

@Stateless
public class CounterManager implements ICounterManager {
    private static int nextId = 1;
    private Integer counter = 0;
    private int id;

    public CounterManager() {
        id = nextId++;
    }

    public int getId() {
        return id;
    }

    @Override
    public Integer increment() {
        counter += 1;

        return counter;
    }
}
