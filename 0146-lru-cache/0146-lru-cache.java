class LRUCache {
    public Map<Integer, Integer> map;
    public int size;

    public LRUCache(int capacity) {
        // accessOrder값을 true로 변경해 접근 빈도에 따라 순서가 변경된다. 
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        size = capacity;
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value); 

        if(map.size() > size) {
            int lruKey = map.keySet().iterator().next();
            map.remove(lruKey);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */