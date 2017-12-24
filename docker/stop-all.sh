#!/usr/bin/env bash

# get the absolute path of the executable
SELF_PATH=$(cd -P -- "$(dirname -- "$0")" && pwd -P) && SELF_PATH="$SELF_PATH"/$(basename -- "$0")

echo "Stopping all"
docker ps | \
grep "auth-server\|config-server\|config-test\|eureka-server\|auth-mongodb\|gateway\|kibana\|elasticsearch\|fluentd\|monitoring\|account-service\|account-mongodb\|rabbitmq\|notification-service\|notification-mongodb\|store-service\|store-mongodb\|appointment-service\|appointment-mongodb" | \
awk '{print $1}' | xargs docker stop
