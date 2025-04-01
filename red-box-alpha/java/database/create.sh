#!/bin/bash
export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=bdnd01
psql -U postgres -d $DATABASE -f "$BASEDIR/appcon/create_tables.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/appcon/initialize_tables.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/bdnd01/create_tables.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/bdnd01/initialize_tables.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/lore/create_tables.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/lore/initialize_tables.sql" 
