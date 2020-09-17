package fontys.sem3.service.repository;

import fontys.sem3.service.model.Shelter;
import fontys.sem3.service.model.Tiger;
import fontys.sem3.service.model.Platypus;

import java.util.ArrayList;
import java.util.List;

public class FakeDataStore {

    private final List<Tiger> tigerList = new ArrayList<>();
    private final List<Platypus> platypusList = new ArrayList<>();
    private final List<Shelter> shelterList = new ArrayList<>();

    public FakeDataStore() {
        // work this out better, add few more countries and students
        Shelter shelter1 = new Shelter("A1");
        Shelter shelter2 = new Shelter("B1");

        shelterList.add(shelter1);
        shelterList.add(shelter2);


        Tiger tiger1 = new Tiger(1, "Bilal", "Male", shelter1);
        Tiger tiger2 = new Tiger(2, "Wahid", "Female", shelter1);
        tigerList.add(tiger1);
        tigerList.add(tiger2);


        platypusList.add(new Platypus(3, "Perry", "Male", shelter2));
        platypusList.add(new Platypus(4, "Ferry", "Female", shelter2));
        platypusList.add(new Platypus(5, "Kurrr-sat", "Male", shelter2));


    }

    public List<Platypus> getPlatypus() {
        return platypusList;
    }

    public List<Platypus> getPlatypuses(int animalNumber) {
        if (animalNumber == 0) {
            return platypusList;
        }
        else {
            for (Platypus platypus : platypusList) {
                if (platypus.getAnimalNumber() == animalNumber) {
                    return platypusList;
                }
            }
        }
        return null;
    }
    public List<Tiger> getTigers(int animalNumber) {
        if (animalNumber == 0) {
            return tigerList;
        }
        else {
            for (Tiger tiger : tigerList) {
                if (tiger.getAnimalNumber() == animalNumber) {
                    return tigerList;
                }
            }
        }
        return null;
    }

    public Platypus getPlatypus(int animalNumber) {
        for (Platypus platypus : platypusList) {
            if (platypus.getAnimalNumber() == animalNumber)
                return platypus;
        }
        return null;
    }

    public Tiger getTiger(int animalNumber) {
        for (Tiger tiger : tigerList) {
            if (tiger.getAnimalNumber() == animalNumber)
                return tiger;
        }
        return null;
    }

    public boolean deletePlatypus(int animalNumber) {
        Platypus platypus = getPlatypus(animalNumber);
        if (platypus == null){
            return false;
        }

        return platypusList.remove(platypus);
    }

    public boolean deleteTiger(int animalNumber) {
        Tiger tiger = getTiger(animalNumber);
        if (tiger == null){
            return false;
        }

        return platypusList.remove(tiger);
    }

    public boolean addPlatypus(Platypus platypus) {
        if (this.getPlatypus(platypus.getAnimalNumber()) != null){
               return false;
        }
        platypusList.add(platypus);
        return true;
    }

    public boolean addTiger(Tiger tiger) {
        if (this.getPlatypus(tiger.getAnimalNumber()) != null){
            return false;
        }
        tigerList.add(tiger);
        return true;
    }

    public boolean updatePlatypus(Platypus platypus) {
        Platypus old = this.getPlatypus(platypus.getAnimalNumber());
        if (old == null) {
            return false;
        }
        old.setName(platypus.getName());
        old.setGender(platypus.getGender());
        old.setAnimalNumber(platypus.getAnimalNumber());
        old.setShelter(platypus.getShelter());
        return true;
    }
    public boolean updateTiger(Tiger tiger) {
        Tiger old = this.getTiger(tiger.getAnimalNumber());
        if (old == null) {
            return false;
        }
        old.setName(tiger.getName());
        old.setGender(tiger.getGender());
        old.setAnimalNumber(tiger.getAnimalNumber());
        old.setShelter(tiger.getShelter());
        return true;
    }


}
