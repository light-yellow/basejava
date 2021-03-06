package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int getIndex(String uuid) {
        return Arrays.binarySearch(this.storage, 0, this.size, new Resume(uuid));
    }

    @Override
    public void insertAtIndex(Resume resume, int index) {
        index = -index - 1;
        System.arraycopy(this.storage, index, this.storage, index + 1, this.size - index);
        this.storage[index] = resume;
    }

    @Override
    public void deleteAtIndex(int index) {
        System.arraycopy(this.storage, index + 1, this.storage, index, this.size - index);
    }
}
