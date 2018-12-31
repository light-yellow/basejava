package storage;

import model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage{

    protected int getIndex(String uuid) {
        for (int i = 0; i < this.size; i += 1) {
            if (uuid.equals(this.storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void insertAtIndex(Resume r, int index) {
        this.storage[size] = r;
    }

    public void deleteAtIndex(int index) {
        this.storage[index] = this.storage[this.size - 1];
    }
}
