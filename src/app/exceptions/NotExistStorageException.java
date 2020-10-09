package app.exceptions;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String id) {
        super("Card " + id + " not exist", id);
    }
}
