package com.mychat.mychat.dto;

import java.util.List;

public class MessageIdsToUpdateDTO {
    private List<Integer> idsToUpdate;
    public List<Integer> getIdsToUpdate(){
        return idsToUpdate;
    }
    public void setIdsToUpdate(List<Integer> idsToUpdate){
        this.idsToUpdate = idsToUpdate;
    }
}
