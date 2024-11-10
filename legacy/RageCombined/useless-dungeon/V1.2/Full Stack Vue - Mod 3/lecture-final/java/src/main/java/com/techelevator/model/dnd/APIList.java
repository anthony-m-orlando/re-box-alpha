package com.techelevator.model.dnd;

import java.util.List;

public class APIList {
        public int count;
        public List<APIListItem> results;

        public int getCount() {
                return count;
        }

        public void setCount(int count) {
                this.count = count;
        }

        public List<APIListItem> getResults() {
                return results;
        }

        public void setResults(List<APIListItem> results) {
                this.results = results;
        }
}
