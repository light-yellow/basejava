package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < this.size; i += 1) {
            storage[i] = null;
        }
        this.size = 0;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < this.size; i += 1) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("Resume already in storage.");
        } else if (size >= storage.length) {
            System.out.println("Not enough space in storage.");
        } else {
            storage[size] = r;
            this.size += 1;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("Resume not found.");
            return null;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[this.size - 1];
            storage[this.size - 1] = null;
            this.size -= 1;
        } else {
            System.out.println("Resume not found.");
        }
    }

    public void update(Resume r)
    {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            storage[index] = r;
        } else {
            System.out.println("Resume not found.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, this.size);
    }

    public int size() {
        return this.size;
    }
}
