package storage;

import model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract int getIndex(String uuid);

    protected abstract void insert(Resume r);

    protected abstract void deleteAtIndex(int index);

    public void clear() {
        for (int i = 0; i < this.size; i += 1) {
            this.storage[i] = null;
        }
        this.size = 0;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("Resume with id '" + r.getUuid() + "' is already in storage.");
        } else if (this.size >= this.storage.length) {
            System.out.println("Cannot save: not enough space in storage.");
        } else {
            insert(r);
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            deleteAtIndex(index);
            this.size -= 1;
        } else {
            System.out.println("Resume with id '" + uuid + "' was not found.");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return this.storage[index];
        } else {
            System.out.println("Resume with id '" + uuid + "' was not found.");
            return null;
        }
    }

    public void update(Resume r)
    {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            this.storage[index] = r;
        } else {
            System.out.println("Resume with id '" + r.getUuid() + "' was not found.");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(this.storage, this.size);
    }

    public int size() {
        return this.size;
    }
}
