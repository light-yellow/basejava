package storage;

import model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;

    protected abstract int getIndex(String uuid);

    protected abstract void insertAtIndex(Resume resume, int index);

    protected abstract void deleteAtIndex(int index);

    public void clear() {
        Arrays.fill(this.storage, 0, this.size, null);
        this.size = 0;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Resume with id '" + resume.getUuid() + "' is already in storage.");
        } else if (this.size >= STORAGE_LIMIT) {
            System.out.println("Cannot save: not enough space in storage.");
        } else {
            insertAtIndex(resume, index);
            this.size += 1;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume with id '" + uuid + "' was not found.");
        } else {
            deleteAtIndex(index);
            this.storage[this.size - 1] = null;
            this.size -= 1;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume with id '" + uuid + "' was not found.");
            return null;
        } else {
            return this.storage[index];
        }
    }

    public void update(Resume resume)
    {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Resume with id '" + resume.getUuid() + "' was not found.");
        } else {
            this.storage[index] = resume;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(this.storage, this.size);
    }

    public int size() {
        return this.size;
    }
}
