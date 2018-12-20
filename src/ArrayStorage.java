import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < this.size; i += 1)
            storage[i] = null;
        this.size = 0;
    }

    void save(Resume r) {
        int i;
        for (i = 0; i < this.size; i += 1) {
            if (storage[i].uuid.equals(r.uuid))
                return;
        }
        if (i < storage.length) {
            storage[i] = r;
            this.size += 1;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < this.size; i += 1)
        {
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < this.size; i += 1)
        {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[this.size - 1];
                storage[this.size - 1] = null;
                this.size -= 1;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, this.size);
    }

    int size() {
        return this.size;
    }
}
