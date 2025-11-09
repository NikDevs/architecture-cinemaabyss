#!/bin/bash
set -e
if [ "$GRADUAL_MIGRATION" == "true" ]; then
  export MOVIES_WEIGHT=$MOVIES_MIGRATION_PERCENT
  export MONOLITH_WEIGHT=$((100-MOVIES_MIGRATION_PERCENT))
else
  export MOVIES_WEIGHT=100
  export MONOLITH_WEIGHT=0
fi
envsubst < /kong/declarative/declarative.yml.tmpl > /kong/declarative/declarative.yml

exec "$@"
