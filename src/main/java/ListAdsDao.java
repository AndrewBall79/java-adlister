import java.util.List;

public class ListAdsDao implements ads{
    public interface Ad {

        List<Ad> all(); // find all the ads records
        Ad findOne(long id); // find an individual record by its id
        void insert(Ad ad); // insert a new record
        void update(Ad ad); // update an existing record
        void destroy(Ad ad); // remove a record
    }
}

