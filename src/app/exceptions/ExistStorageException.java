package app.exceptions;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String id) {
        super("Card " + id + " already exist", id);
    }
}
