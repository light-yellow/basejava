package storage;

import model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage{

    int getIndex(String uuid) {
        for (int i = 0; i < this.size; i += 1) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void insert(Resume r) {
        this.storage[size] = r;
        this.size += 1;
    }

    public void deleteAtIndex(int index) {
        storage[index] = storage[this.size - 1];
        storage[this.size - 1] = null;
    }
}
