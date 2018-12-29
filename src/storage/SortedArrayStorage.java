package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    int getIndex(String uuid) {
        return Arrays.binarySearch(this.storage, new Resume(uuid));
    }

    public void insert(Resume r) {
        this.storage[size] = r;
        this.size += 1;
        Arrays.sort(this.storage);
    }

    public void deleteAtIndex(int index) {
        while (index + 1 < this.size)
        {
            this.storage[index] = this.storage[index + 1];
            index += 1;
        }
        this.storage[index] = null;
    }
}
