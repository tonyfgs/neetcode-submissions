class TimeMap {

    class Entry {
        public Integer time;
        public String value;

        public Entry(Integer time, String value) {
            this.time = time;
            this.value = value;
        }
    }

    HashMap<String, List<Entry>> map; 
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Entry> entry = map.get(key);
        if (entry == null) {
            return "";
        }
        int min = 0;
        int max = entry.size()-1;
        String res = "";
        while(min<=max) {
            int mid = min + (max - min) /2;
            Entry entryFound = entry.get(mid);
            if(entryFound.time == timestamp) {
                return entryFound.value;
            }

            if (entryFound.time > timestamp) {
                max = mid -1;
            }
            else {
                min = mid +1;
                res = entryFound.value;
            }
        }
        return res;
    }
}
