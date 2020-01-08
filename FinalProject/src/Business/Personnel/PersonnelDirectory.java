/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Personnel;

import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class PersonnelDirectory {
    
    private ArrayList<Personnel> personnelList;

    public PersonnelDirectory() {
        personnelList = new ArrayList<>();
    }

    public ArrayList<Personnel> getPersonnelList() {
        return personnelList;
    }

    public void setPersonnelList(ArrayList<Personnel> personnelList) {
        this.personnelList = personnelList;
    }
    
    public Personnel createPersonel(String name)
    {
        Personnel personnel = new Personnel(name);
        personnelList.add(personnel);
        return personnel;
   
    }
}
