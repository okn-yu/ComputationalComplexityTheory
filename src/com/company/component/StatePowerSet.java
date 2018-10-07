package com.company.component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StatePowerSet extends StateSet {

    protected HashSet<StateSet> powerSet;

    public StatePowerSet(StateSet Q){

        powerSet = new HashSet<StateSet>();
        powerSet.add(new StateSet());

        HashSet<StateSet> copySet = new HashSet<StateSet>();

        for(State s: Q.set) {
                for(StateSet n: powerSet){
                    StateSet copy = new StateSet(n.set);
                    copy.set.add(s);
                    copySet.add(copy);
                }
                powerSet.addAll(copySet);
        }
        this.show();
    }

    @Override
    public void show(){
        System.out.println("PowerStateSet: { ");
        for(StateSet s : powerSet){
            System.out.print(" ");
            s.show();
        }
        System.out.println("}");
    }

}
