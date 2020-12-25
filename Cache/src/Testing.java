public class Testing {

     public static void main(String[] args)
     {
            String str=new String("hello world");

            CachedObject co=new CachedObject(str,new Long(123456789),10);

            CacheManager.putCache(co);

            CachedObject temp= (CachedObject)CacheManager.getCache(co.identifier);

            if(temp==null)
                 System.out.println("Failure Object not found");
           else
               System.out.println("Object found: "+temp.getObject().toString());

     }
}