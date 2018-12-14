import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int arrSize = size();
        for (int i = 0; i < arrSize; i += 1)
            storage[i] = null;
    }

    void save(Resume r) {
        int arrSize = size();
        int i;
        for (i = 0; i < arrSize; i += 1) {
            if (storage[i].uuid.equals(r.uuid))
                return;
        }
        if (i < storage.length)
            storage[i] = r;
    }

    Resume get(String uuid) {
        int arrSize = size();
        for (int i = 0; i < arrSize; i += 1)
        {
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        int arrSize = size();
        for (int i = 0; i < arrSize; i += 1)
        {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[arrSize - 1];
                storage[arrSize - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int i = 0;
        while (i < storage.length && storage[i] != null)
            i += 1;
        return i;
    }
}
