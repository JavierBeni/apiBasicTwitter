# apiBasicTwitter_geowox
API REST. BASIC TWITTER. GEOWOX

API created to emulate a twitter.
It use rest methods to see messages of users or create new posts.

GUIDE.
This api is done with 

WALL (Show all messages of the user sorted by time (id))
@GET
http://localhost:8080/api/user/1/wall

TIMELINE (Show all messages of the users who follows, sorted by time(id))
@GET
http://localhost:8080/api/user/1/timeline

FOLLOWING (Add if of user the list of folled people)
@GET
http://localhost:8080/api/user/1/follow/3

POSTING (Ceate a new pòst fo this user. Necessary pass a message. I use API TESTER chrome extension and add "message" to the body of teh post)
@POST
http://localhost:8080/api/user/1/

