import model.Resume;
import storage.SortedArrayStorage;

public class MainTestSortedArrayStorage {
    static final SortedArrayStorage SORTED_ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r4 = new Resume("uuid4");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r1 = new Resume("uuid1");
        Resume r5 = new Resume("uuid5");

        SORTED_ARRAY_STORAGE.save(r1);
        SORTED_ARRAY_STORAGE.save(r2);
        SORTED_ARRAY_STORAGE.save(r3);
        SORTED_ARRAY_STORAGE.save(r4);

        System.out.println("Get r1: " + SORTED_ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + SORTED_ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + SORTED_ARRAY_STORAGE.get("dummy"));

        SORTED_ARRAY_STORAGE.update(r5);
        SORTED_ARRAY_STORAGE.update(r4);

        printAll();
        SORTED_ARRAY_STORAGE.delete(r2.getUuid());
        printAll();
        System.out.println("Size: " + SORTED_ARRAY_STORAGE.size());
        SORTED_ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + SORTED_ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : SORTED_ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
