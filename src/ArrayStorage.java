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
        int i = getIndex(r.getUuid());
        if (i != -1) {
            System.out.println("Resume already in storage.");
        } else if (i >= storage.length) {
            System.out.println("Not enough space in storage.");
        } else {
            storage[i] = r;
            this.size += 1;
        }
    }

    public Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            return storage[i];
        } else {
            System.out.println("Resume not found.");
            return null;
        }
    }

    public void delete(String uuid) {
        int i = getIndex(uuid);
        if (i != -1) {
            storage[i] = storage[this.size - 1];
            storage[this.size - 1] = null;
            this.size -= 1;
        } else {
            System.out.println("Resume not found.");
        }
    }

    public void update(Resume r)
    {
        int i = getIndex(r.getUuid());
        if (i != -1) {
            storage[i] = r;
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
