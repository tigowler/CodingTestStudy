public class HashTableWithChaining {
    public Slot[] hashTable;

    public HashTableWithChaining(Integer size){
        this.hashTable = new Slot[size];
    }

    private class Slot {
        String key;
        String value;
        Slot next;
        Slot(String key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key){
        return (int)(key.charAt(0))%this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address]!=null){
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while(findSlot!=null){
                if(findSlot.key == key){ //저장한 적이 있는 key일 경우 업데이트
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            //저장된 key가 없으면 맨 마지막에 새로 추가
            prevSlot.next = new Slot(key, value);
        } else {
            //key에 해당하는 첫 자리가 null인 경우 바로 추가
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address]!=null){
            Slot findSlot = this.hashTable[address];
            while(findSlot!=null){
                if(findSlot.key == key){
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public void test(HashTableWithChaining hashTable){
        hashTable.saveData("DaveLee", "01022223333");
        hashTable.saveData("fun-coding", "01033334444");
        hashTable.saveData("David", "01044445555");
        hashTable.saveData("Dave", "01055556666");
        System.out.println(hashTable.getData("Dave"));
    }
}
