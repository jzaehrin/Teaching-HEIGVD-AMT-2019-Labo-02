package ch.heigvd.amt.labo02.business;

import javax.ejb.Local;

@Local
public interface ICounterManager {
    public int getId();
    public Integer increment();
}
