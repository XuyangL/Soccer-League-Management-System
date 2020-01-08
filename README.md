# Final Project

**Soccer League Management System**
Final Project for INFO5100 

## Author

Keyboard Man:

Xuyang Li 001409590	
Jiaao Yu 001464004

##Problem Overview:
Soccer is the biggest sport in the world. However, its complex rules associated with huge amount of match data confuse players, clubs and even Soccer Association. Players and coaches are struggling to improve while clubs and the Association find it hard to deal with all problems. The core conflict is that there isn’t a uniformed system to manage relationships and match data.
Imagine that there is a University Soccer League and whole of it keeps unorganized. Players need a system to better prepared for matches. Meanwhile, clubs, associations also require methods to manage their works. So, we would like to develop a Soccer League Management System to make it more “organized”. As a result, it will achieve “1+1>2” for all single roles.

##Application Functionalities:

Soccer Association	

* Manage matches (creating the schedule of a match with a referee)

* Manage referees (add & delete & update)
* Manage clubs (collect club information; giving disciplines to a player) 
* Send message to clubs, coaches and players

Referee

* Record booking info of a match 
* Record result of a match (score, substitution info, etc.)

Club Manager

* Manage players (transferring players between clubs; promoting or demoting a player to higher or lower team, etc.)
* Send information to coaches and players

Coach

* Manage a match (decide line-up, decide captain, decide formation)
* View players performance
* Send message to players

Player

* View statistics and performance

##Proposed Entities:
Players, Coaches, Clubs, Referees, Matches, Soccer Association (SA).

##Additional Features:
1.	The followings will be visible to all the people using this system:

	* Rank of teams
	* Result of each game 
	* The top strikers and top assisting players in the league
 
2.	The statistics belong to a club is only visible to that club and players under the club.
3.	SA is able to send message to anyone using the system while others can only send message to people under same club.
4.	A match simulator may be added to the system on day in order to better explain the whole system.