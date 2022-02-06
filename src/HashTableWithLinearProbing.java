//시간복잡도
//1) Collision이 없는 경우 O(1)
//2) Collision이 모두 발생하는 경우 O(n)

public class HashTableWithLinearProbing {
    public Slot[] hashTable;

    public HashTableWithLinearProbing(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key){
        return (int)(key.charAt(0))%this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address]!=null){
            Integer currAddress = address;
            while(this.hashTable[currAddress]!=null){
                //이미 저장되어 있는 key라면 update
                if(this.hashTable[currAddress].key==key){
                    this.hashTable[currAddress].value = value;
                    return true;
                } else {
                    currAddress++;
                    if(currAddress>=this.hashTable.length){
                        return false;
                    }
                }
            }
            //key와 일치하는 곳을 찾지 못하고 빈 공간을 만난 경우
            this.hashTable[currAddress] = new Slot(key, value);
            return true;
        } else { //address 위치가 빈 공간이라면 바로 추가
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        //1) address에 해당하는 첫 위치가 비어있지 않은 경우
        if(this.hashTable[address]!=null){
            Integer currAddress = address;
            while(this.hashTable[currAddress]!=null){
                if(this.hashTable[currAddress].key == key){
                    return this.hashTable[currAddress].value;
                } else {
                    currAddress++;
                    if(currAddress>=this.hashTable.length){
                        return null;
                    }
                }
            }
            //전부 탐색했으나 key값이 없는 경우
            return null;
        }
        //2) address에 해당하는 첫 위치가 비어있는 경우
        else {
            return null;
        }
    }

    public void test(HashTableWithLinearProbing hash){
        hash.saveData("DaveLee", "01022223333");
        hash.saveData("fun-coding", "01033334444");
        hash.saveData("David", "01044445555");
        hash.saveData("Dave", "01055556666");
        System.out.println(hash.getData("DaveLeer"));
    }
}
