package com.techelevator.model;

public class Monster {

    private int monsterId;
    private String monsterName;
    private int challengeRating;
    private int groupId;
    private int roleId;
    private int monsterIntelligence;

    private String role_name;

    private String group_name;

    public Monster() {
    }

    public Monster(int monsterId, String monsterName, int challengeRating, int groupId, int roleId, int monsterIntelligence) {
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.challengeRating = challengeRating;
        this.groupId = groupId;
        this.roleId = roleId;
        this.monsterIntelligence = monsterIntelligence;
    }

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getChallengeRating() {
        return challengeRating;
    }

    public void setChallengeRating(int challengeRating) {
        this.challengeRating = challengeRating;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getMonsterIntelligence() {
        return monsterIntelligence;
    }

    public void setMonsterIntelligence(int monsterIntelligence) {
        this.monsterIntelligence = monsterIntelligence;
    }
}
