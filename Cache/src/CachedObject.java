import java.util.Calendar;
import java.util.Date;

public class CachedObject implements  Cacheable {

        Date dateOfExpire;
        Object object;

    public Date getDateOfExpire() {
        return dateOfExpire;
    }

    public void setDateOfExpire(Date dateOfExpire) {
        this.dateOfExpire = dateOfExpire;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void setIdentifier(Object identifier) {
        this.identifier = identifier;
    }

    Object identifier;

        CachedObject(Object object,Object id,int minutestToLive)
        {
            this.object=object;
            this.identifier=id;

            if(minutestToLive!=0)
            {
                dateOfExpire=new Date();
                Calendar cal=Calendar.getInstance();
                cal.setTime(dateOfExpire);
                cal.set(Calendar.MINUTE,minutestToLive);
                dateOfExpire=cal.getTime();
            }

        }

    @Override
    public boolean isExpired() {
        if (dateOfExpire != null)
        {
            // date of expiration is compared.
            if (dateOfExpire.before(new java.util.Date()))
            {
                System.out.println("CachedResultSet.isExpired:  Expired from Cache! EXPIRE TIME: " + dateOfExpire.toString() + " CURRENT TIME: " +
                (new java.util.Date()).toString());
                return true;
            }
            else
            {
                System.out.println("CachedResultSet.isExpired:  Expired not from Cache!");
                return false;
            }
        }
        else // This means it lives forever!
            return false;
    }

    @Override
    public Object getIdentifier() {
        return identifier;
    }
}
