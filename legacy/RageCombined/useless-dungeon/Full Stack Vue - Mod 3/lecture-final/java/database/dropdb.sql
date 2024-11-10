-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
BEGIN TRANSACTION;

DROP DATABASE useless_dungeon;

COMMIT TRANSACTION;