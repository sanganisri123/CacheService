# CacheService
What is Cache??\
   An area in a local memory which holds frequently accessed data.
   
Why Cache?\
    High performance Scalable web applicatioins often use in-memory distibuted cache.

Lets implement a cache service:
  
  Rrequirments:\
	1. Any java application should able to use the service.\
	2. Able to insert objects into cache.\
	3. Able to get objects from cache.\
	4. Cached objects can determine for themselves when they expire, thereby allowing maximum flexibility. \
	  Caching services that expire all objects using the same expiration formula fail to provide optimal use of cached objects. \
	  This approach is inadequate in large-scale systems since, for example, a product list may change daily, whereas a list of store locations might change only once a month.\
	5. A background thread that runs under low priority removes exipred cached objects.\
	6. Cache service can be enhanced later through using LRU or LFU purging mechanism.
	
	
MainClasses or Interface:

1.Cacheable(interface):	According to requriment 4, every cahced objects should obey two rules.they are:
                                         1.every object should able to calculate whether that object is expired or not.(done by IsExpired() method).
			                             2. every object should give an identifier which distinguishes it from other objects.(done by getIdentifier() method).
				
    			 - - - - - - - - - - - - - - 				
				|		Cacheable    |
				|- - - - - - - - - - - - - - |
				|	+IsExpired()	     |
				|	+getIdentifier()     |
				|		             |
				 - - - - - - - - - - - - - - 
				 
2. CachedObjects(class): Any object placed in the cache should be wrapped inside an object that implements cacheable interface.
        
				
    			 - - - - - - - - - - - - - - - - - - 				
				| CachedObjects implements Cacheable|
				|- - - - - - - - - - - - - -        |
				|	+dateOfExpire	            |
				|	+identifier	            |
				|	+object		            |
				| - - - - - - - - - - - - - - - - - |
				|	+IsExpired()		    |
				|	+getIdentifier()	    |
				 - - - - - - - - - - - - - - - - - - 
3. CacheManager(class): This allows objects to be put into and retrieved from the cache. It also checks everytime is there any expired objects in the cache and remove them automatically.

     			- - - - - - - - - - - - - - 				
				|	CacheManager        |
				|- - - - - - - - - - - - - -|
				|	+putCache()	    |
				|	+getCache()	    |
				|		            |
				 - - - - - - - - - - - - - -          
