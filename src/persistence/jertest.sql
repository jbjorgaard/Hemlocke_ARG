CREATE TABLE sqlite_sequence(name,seq);
CREATE TABLE "player" (
    "player_id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "username" TEXT,
    "password" TEXT,
    "character" TEXT
);
CREATE TABLE thing_contents (
    "thing_id" TEXT,
    "content" TEXT
);
CREATE TABLE thing_links (
    "thing_id" TEXT,
    "links" TEXT
);
CREATE TABLE things (
    "thing_id" TEXT,
    "name" TEXT,
    "short_description" TEXT,
    "description" TEXT,
    "type" TEXT,
    "location" TEXT,
    "brain" TEXT
);
CREATE TABLE brain (
    "brain_id" TEXT,
    "owner" TEXT
, "type" TEXT);
