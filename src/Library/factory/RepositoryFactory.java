package Library.factory;

import Library.dao.impls.BookManagerRepository;
import Library.dao.impls.BookRepository;
import Library.dao.impls.StudentRepository;
import Library.dao.interfaces.IRepository;
import Library.enums.RepositoryType;

public class RepositoryFactory {
    private RepositoryFactory(){}

    public static IRepository createRepository(RepositoryType type){
        switch (type){
            case BOOK: return new BookRepository();
            case STUDENT: return new StudentRepository();
            case BOOKMANAGER: return new BookManagerRepository();
            default:throw new IllegalArgumentException("Error");
        }
    }
}
