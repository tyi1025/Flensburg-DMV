package database;


import model.LicenceHolder;

import java.util.Hashtable;


public class LicenceHolderDatabase
{
    // Design pattern Singleton
    private static LicenceHolderDatabase instance;

    private LicenceHolderDatabase() {}

    public synchronized static LicenceHolderDatabase getInstance()
    {
        if(instance == null)
        {
            instance = new LicenceHolderDatabase();
        }
        return instance;
    }

    private Hashtable<Integer, LicenceHolder> idTable= new Hashtable();
    private Hashtable<String, LicenceHolder> regNumberTable = new Hashtable();


    public void add(int id, String regNumber, String firstName, String lastName, int penaltyPoint)
    {
        LicenceHolder holder = new LicenceHolder();
        holder.setId(id);
        holder.setRegNumber(regNumber);
        holder.setFirstName(firstName);
        holder.setLastName(lastName);
        holder.setPenaltyPoint(penaltyPoint);
        idTable.put(id, holder);
        regNumberTable.put(regNumber, holder);
    }

    public LicenceHolder searchById(int id)
    {
        return idTable.get(id);
    }

    public LicenceHolder searchByRegNumber(String regNumber)
    {
        return regNumberTable.get(regNumber);
    }

    public boolean edit(Object key, int id, String regNumber, String firstName, String lastName, int penaltyPoint)
    {
        LicenceHolder holder;
        if (key instanceof Integer)
        {
            holder = searchById((int) key);
        }
        else if(key instanceof String)
        {
            holder= searchByRegNumber((String) key);
        }
        else
        {
            return false;
        }

        holder.setId(id);
        holder.setRegNumber(regNumber);
        holder.setFirstName(firstName);
        holder.setLastName(lastName);
        holder.setPenaltyPoint(penaltyPoint);
        idTable.put(id, holder);
        regNumberTable.put(regNumber, holder);
        return true;
    }

    public void delete(Object key) {
        LicenceHolder holder;
        if (key instanceof Integer) {
            holder = searchById((int) key);
            String regNumber = holder.getRegNumber();
            idTable.remove(key);
            regNumberTable.remove(regNumber);
        } else if (key instanceof String) {
            holder = searchByRegNumber((String) key);
            int id = holder.getId();
            regNumberTable.remove(key);
            idTable.remove(id);
        } else {
            throw new IllegalArgumentException();
        }


    }
}
