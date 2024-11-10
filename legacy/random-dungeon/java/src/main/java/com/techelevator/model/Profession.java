package com.techelevator.model;

public class Profession {

        private int professionId;
        private String professionName;

        public Profession() {
        }

        public Profession(int professionId, String professionName) {
            this.professionId = professionId;
            this.professionName = professionName;
        }

        public int getProfessionId() {
            return professionId;
        }

        public void setProfessionId(int professionId) {
            this.professionId = professionId;
        }

        public String getProfessionName() {
            return professionName;
        }

        public String setProfessionName(String professionName) {
            return this.professionName = professionName;
        }
}
