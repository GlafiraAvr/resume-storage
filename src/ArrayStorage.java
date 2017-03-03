/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;


    void clear() {
        for (int i = 0; i <size ; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {

        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i <size ; i++) {
            if (storage[i].uuid.equals(uuid)) return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)){
                System.arraycopy(storage, i + 1, storage, i + 1 - 1, size - (i + 1));
                storage[size-1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume [] result = new Resume[size];
        System.arraycopy(storage, 0, result, 0, size);
           return result;
    }

    int size() {
        return size;
    }
}
