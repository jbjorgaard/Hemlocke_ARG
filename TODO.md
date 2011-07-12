CURRENT
=======
* Start db support
* mimic sql example using game db tables
* create read update delete methods for things and brains
* change initializeGame() to store objects
* change runGame() to create objects
---

NEXT
====
* Make web interface work
* Make web interface pretty
* Creation Commands
* Gateway objects 

---

DONE
====
* Jeremiah 06-22-2011 Convert to use ID's instead of pointers (id = Game.getCurrent().nextId();) NO THING INSTANCE VAR
* Jeremiah 06-22-2011 getThing(id), putThing(thing)   hashmap to store ids
* Jeremiah 04-19-2011 Create 3 Brain Classes to handle different reactions Greedy, Nosey, Friendly
* Jeremiah 04-14-2011 Create Say Command
* Jeremiah 04-13-2011 Create method for NPC's to Run Commands and propagate them
* Jeremiah 03-29-2011 Modify command classes to propagate and identify themselves to brains
* Jeremiah 03-22-2011 Command classes including errors so we can move onto brains

---

DEFERRED
========
* Pilot command to remote control NPC's
* Creation command to create things in game
* Way to store everything to a database (save command and sql) 
* Make it multi user
* Export format 