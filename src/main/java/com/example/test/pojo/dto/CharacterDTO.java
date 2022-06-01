package com.example.test.pojo.dto;

import javax.validation.Valid;

public class CharacterDTO {

    @Valid
    private String occupation;
    private String skill;
    public String getOccupation() {
        return occupation;
    }

    public String getSkill() {
        return skill;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }


}
