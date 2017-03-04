
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    public  class OverSizeException extends Exception{

        public OverSizeException(int s) {
            super(Integer.toString(s));
        }
    }



    Resume[] storage = new Resume[100];
    int size;


    void clear() {
        for (int i = 0; i <size ; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    /**
     * Add new resume in storage
     * @param r new resume
     * @return current index of new resume or -1 if resume already in storage
     * @throws OverSizeException
     */

   int save(Resume r) throws  OverSizeException {
       if (size==storage.length)
           throw  new OverSizeException(storage.length) ;
        if (get(r.uuid)!=null)
        {
            return -1;
        }
        storage[size] = r;
        size++;
       return  size-1;
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
